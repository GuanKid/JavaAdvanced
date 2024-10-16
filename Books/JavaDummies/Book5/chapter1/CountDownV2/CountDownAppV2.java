package Book5.chapter1.CountDownV2;

import java.util.ArrayList;

public class CountDownAppV2 {
    public static void main(String[] args) {

        // Instantiate a CountDownClockV2 object.
        CountDownClockV2 clock = new CountDownClockV2(20);
        // Instantiate a ArrayList that can store objects that implement the Runnable interface.
        ArrayList<Runnable> events = new ArrayList<Runnable>();
        // Create new LaunchEventV2 objects and add them to the event ArrayList
        events.add(new LaunchEventV2(16, "Flood the pad!", clock));
        events.add(new LaunchEventV2(6, "Start engines!", clock));
        events.add(new LaunchEventV2(0, "Liftoff!", clock));
        // Start the clock
        clock.start();
        // Loop through all the events, create a new thread passing it the object that implements the
        //   runnable interface and then call the start method which calls the run method in turn.
        for (Runnable e : events) {
            new Thread(e).start();
        }

    }
}