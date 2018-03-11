package pigeonsquare.utils;

/**
 * Position class
 */
public class Position {
    public double x,y;

    /**
     * Constructor
     * @param x The absciss
     * @param y The ordinate
     */
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the distance between the current position and the position given
     * @param v The position
     * @return The distance between the current position and the position given
     */
    public double distance(Position v) {
        double vx = v.x - this.x;
        double vy = v.y - this.y;
        return Math.sqrt(vx * vx + vy * vy);
    }

    /**
     * Return the length of the vector
     * @return The length of the vector
     */
    private double getLength(){
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
    }

    /**
     * Normalize a vector
     */
    public void normalize(){
        double length = getLength();
        if(length != 0){
            this.x = this.x/length;
            this.y = this.y/length;
        }
    }

    /**
     * Return a string to display the position
     * @return A string to display the position
     */
    @Override
    public String toString() {
        return "Position[" + x + ", " + y + "]";
    }
}
