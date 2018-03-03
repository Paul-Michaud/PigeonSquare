package pigeonsquare;

import pigeonsquare.utils.Position;

public abstract class MobileItem extends Item {

    protected int speed;
    protected Position position;

    public MobileItem() {
        this.position = new Position();
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        while (this.running) {

        }
    }


    }
