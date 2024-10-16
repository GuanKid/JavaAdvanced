package Book5.chapter1.Sync;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class DoTwoThingsSync
{
    ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2);
    CountDownClockSync clock = new CountDownClockSync(20);

    public static void main(String[] args) {
        new DoTwoThingsSync();
    }

    DoTwoThingsSync()
    {
        pool.execute(clock);
        pool.execute(clock);
        pool.shutdown();
    }

    class CountDownClockSync extends Thread
    {
        private int start;
        public CountDownClockSync(int start)
        {
            this.start = start;
        }

        synchronized public void run()
        {
            for (int t = start; t >= 0; t--) {
                System.out.println("T minus " + t);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

}
