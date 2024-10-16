package Book5.chapter1.Abort;

import java.util.ArrayList;

public class CountDownApp {
    public static void main(String[] args) {

        // Create a CountDownClock object, starting the countdown at 20 seconds
        CountDownClock clock = new CountDownClock(20);

        // Create an ArrayList to store LaunchEvent objects (events to trigger at specific times)
        ArrayList<LaunchEvent> events = new ArrayList<>();

        // Add various launch events to the events list, which will occur at specific times
        events.add(new LaunchEvent(16, "Flood the pad!", clock)); // Event at 16 seconds
        events.add(new LaunchEvent(6, "Start engines!", clock));  // Event at 6 seconds
        events.add(new LaunchEvent(0, "Liftoff!", clock));        // Event at 0 seconds (launch)

        // Start the countdown clock in its own thread
        clock.start();

        // Loop through the events list and start each event in its own thread
        // The LaunchEvent class implements Runnable, so each event can be run in a thread
        for (LaunchEvent e : events) {
            new Thread(e).start();
        }
    }
}
