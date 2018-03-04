package pigeonsquare;

public abstract class MobileItem extends Item {

    protected int speed;
    protected int sixtyFPS = 16;
    protected int thirtyFPS = 32;
    protected int oneTwentyFPS = 8;

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
