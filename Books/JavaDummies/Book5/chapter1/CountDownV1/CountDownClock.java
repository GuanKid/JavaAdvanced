package Book5.chapter1.CountDownV1;

public class CountDownClock extends Thread
{
    // Override & implement the run method that comes from the Thread class that actually comes from the Runnable interface.
    @Override
    public void run() {
        // Run timer for 20 seconds
        for (int t = 20; t > 0; t--)
        {
            System.out.println("T minus " + t);
            // InterruptedException is a checked exception we must check for.
            try {
                // Sleep every second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
