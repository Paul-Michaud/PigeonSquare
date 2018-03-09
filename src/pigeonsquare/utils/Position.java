package pigeonsquare.utils;

public class Position {
    public double x;
    public double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Position v) {
        double vx = v.x - this.x;
        double vy = v.y - this.y;
        return Math.sqrt(vx * vx + vy * vy);
    }

    private double getLength(){
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
    }

    public void normalize(){
        double length = getLength();
        if(length != 0){
            this.x = this.x/length;
            this.y = this.y/length;
        }
    }

    @Override
    public String toString() {
        return "Position[" + x + ", " + y + "]";
    }
}
