package Book5.chapter1.CountDownV3;

public class LaunchEventNew implements Runnable
{
    private String message;
    public LaunchEventNew(String message)
    {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message);
    }

}
