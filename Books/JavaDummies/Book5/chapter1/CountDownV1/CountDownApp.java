package Book5.chapter1.CountDownV1;

public class CountDownApp
{
    public static void main(String[] args) {
        Thread clock = new CountDownClock();
        // Interesting: You can store objects into type Runnable if they implement that interface.
        Runnable flood, ignition, liftoff;

        // Storing the launch events into the runnable object.
        flood = new LaunchEvent(16, "Flood the pad!");
        ignition = new LaunchEvent(5, "Start the engines!");
        liftoff = new LaunchEvent(0, "Liftoff!");
        clock.start();

        // Creating threads and passing the runnable objects to the constructor & then calling the start method.
        new Thread(flood).start();
        new Thread(ignition).start();
        new Thread(liftoff).start();
    }
}
