package Book5.chapter1.CountDownV2;


class CountDownClockV2 extends Thread implements TimeMonitorV2 {
    private int t;

    public CountDownClockV2(int start) {
        this.t = start;
    }

    public void run() {
        for (; t >= 0; t--) {
            System.out.println("T minus " + t);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public int getTime() {
        return t;
    }
}
