

public class Runner
{
    static final int SIZE = 800;
    public static void main(String[] args)
    {
       
        StdDraw.setCanvasSize(SIZE, SIZE);
        StdDraw.setXscale(-1, 1);
        StdDraw.setYscale(-1, 1);
        StarChart sChart = new StarChart("/Users/harshith/eclipse-workspace/Constellation2/data/stars.txt");
        sChart.drawStars();
        sChart.drawConstellation("/Users/harshith/eclipse-workspace/Constellation2/data/Big Dipper.txt");
        sChart.drawConstellation("/Users/harshith/eclipse-workspace/Constellation2/data/Bootes.txt");
        sChart.drawConstellation("/Users/harshith/eclipse-workspace/Constellation2/data/Cassiopeia.txt");
        sChart.drawConstellation("/Users/harshith/eclipse-workspace/Constellation2/data/Cygnet.txt");
        sChart.drawConstellation("/Users/harshith/eclipse-workspace/Constellation2/data/Gemini.txt");
        sChart.drawConstellation("/Users/harshith/eclipse-workspace/Constellation2/data/Hydra.txt");
        sChart.drawConstellation("/Users/harshith/eclipse-workspace/Constellation2/data/Ursa Major.txt");
        sChart.drawConstellation("/Users/harshith/eclipse-workspace/Constellation2/data/Ursa Minor.txt");
       
    }
   
}
