import java.util.*;
public class Star
{
    double x;
    double y;
    int henryDraper;
    double magnitude;
    ArrayList<String> starNameLst;
    public Star(double x, double y, int henryDraper, double magnitude, ArrayList<String> starNameLst)
    {
        this.x = x;
        this.y = y;
        this.henryDraper = henryDraper;
        this.magnitude = magnitude;
        this.starNameLst = starNameLst;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public ArrayList<String> getStarNames(){
        return this.starNameLst;
    }
    public int getHenryDraper()
    {
        return this.henryDraper;
    }
    public double getMagnitude(){
        return this.magnitude;
    }
    public static double getStarRadius(double magnitude)
    {
        double radius = 2 / (100 * (magnitude + 2));
        return radius;
    }
}
