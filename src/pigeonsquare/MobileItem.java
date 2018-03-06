package pigeonsquare;

public abstract class MobileItem extends Item {

    protected int speed;
    protected final int sixtyFPS = 16;
    protected final int thirtyFPS = 32;
    protected final int oneTwentyFPS = 8;

    protected MobileItem() {

    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        while (this.running) {
            System.out.println("mobileItem");
        }
    }


    }
