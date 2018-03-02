package pigeonsquare;

public class Mobile extends Thread{

    protected int size;
    protected int speed;
    protected double posX;
    protected double posY;

    public Mobile(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }


    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
}
