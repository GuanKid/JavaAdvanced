package Book5.chapter1.CountDownV1;

// Class implements Runnable interface, so it is required to override the run method
// Runnable is a functional interface as it has only 1 method.
public class LaunchEvent implements Runnable
{
    private int start;
    private String message;
    public LaunchEvent(int start, String message)
    {
        this.start = start;
        this.message = message;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(20000 - (start * 1000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(message);
    }
}
