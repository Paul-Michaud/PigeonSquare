package pigeonsquare;

public abstract class MobileItem extends Item {

    protected int speed;

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
