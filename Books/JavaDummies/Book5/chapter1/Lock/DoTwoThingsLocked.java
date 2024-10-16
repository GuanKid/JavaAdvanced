package Book5.chapter1.Lock;

import Book5.chapter1.CountDownV3.CountDownClockNew;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class DoTwoThingsLocked
{
    ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2);
    CountDownClockLocked clock = new CountDownClockLocked();

    public static void main(String[] args) {
        new DoTwoThingsLocked();
    }

    DoTwoThingsLocked()
    {
        pool.execute(clock);
        pool.execute(clock);
        pool.shutdown();
    }

}
