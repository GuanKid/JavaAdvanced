package Book5.chapter1.Abort;

// CountDownClock class extends Thread to create a thread that counts down
// It implements TimeMonitor interface to allow external monitoring of the countdown
public class CountDownClock extends Thread implements TimeMonitor {
    // t is the countdown starting point
    private int t;

    // Constructor to initialize the countdown starting value
    public CountDownClock(int start) {
        this.t = start;
    }

    // Override the run() method from the Thread class
    // This method executes when the thread starts
    public void run() {
        boolean aborted = false; // Flag to check if the countdown is aborted

        // Countdown loop that decrements t until it reaches 0
        for (; t >= 0; t--) {
            System.out.println("T minus " + t); // Print the current countdown value

            try {
                Thread.sleep(1000); // Pause for 1 second between countdown ticks
            } catch (InterruptedException e) {
                // If thread is interrupted, set aborted flag to true
                aborted = true;
            }

            // Check if the thread has been interrupted
            if (Thread.interrupted()) {
                aborted = true; // If interrupted, set aborted flag to true
            }

            // If the aborted flag is true, stop the countdown
            if (aborted) {
                System.out.println("Stopping the clock!");
                break; // Exit the loop, ending the countdown
            }
        }
    }

    // Method to get the current countdown time
    public int getTime() {
        return t;
    }

    // Method to abort the countdown by interrupting all active threads
    public synchronized void abortCountDown() {
        // Create an array to hold all active threads
        Thread[] threads = new Thread[Thread.activeCount()];

        // Populate the threads array with all currently active threads
        Thread.enumerate(threads);

        // Iterate through all threads and interrupt them
        for (Thread t : threads) {
            t.interrupt(); // Sends an interrupt signal to stop the thread
        }
    }
}
