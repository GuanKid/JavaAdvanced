package Book5.chapter1.CountDownV2;

public class LaunchEventV2 implements Runnable {

    private int start;
    private String message;
    TimeMonitorV2 tm;
    public LaunchEventV2(int start, String message, TimeMonitorV2 monitor)
    {
        this.start = start;
        this.message = message;
        this.tm = monitor;
    }

    public void run()
    {
        boolean eventDone = false;
        while (!eventDone)
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {}

            if (tm.getTime() <= start)
            {
                System.out.println(this.message);
                eventDone = true;
            }

        }
    }

}
