package pigeonsquare;

import pigeonsquare.utils.Position;

public abstract class MobileItem extends Item {

    protected int speed;

    public MobileItem() {

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
