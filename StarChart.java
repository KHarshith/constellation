import java.io.*;

import java.io.FileNotFoundException;

import java.util.Scanner;

import java.util.*;


public class StarChart

{

    String fileName;

    ArrayList<Star> starsLst = new ArrayList<Star>();

    HashTable Star;

    HashTable StarName;

    public StarChart(String fileName)

    {

        this.fileName = fileName;

        this.Star = new HashTable(4000);

        this.StarName = new HashTable(4000);

        readStars();

        populateMaps();

    }

    

    private void readStars(){

        BufferedReader reader;

        try{

            reader = new BufferedReader(new FileReader(this.fileName));

            String line = reader.readLine();

            int numLines = 0;

            while(line != null)

            {

                Star star;

                numLines++;

                double x;

                double y;

                int henryDraper;

                double magnitude;

                ArrayList<String> namesLst = new ArrayList<String>();

                String[] starAttTmp = line.split(";");

                String[] starAtt;

                String starName = "";

                if(starAttTmp.length == 1)

                {

                    

                    starAtt = starAttTmp[0].split(" ");

                    x = Double.parseDouble(starAtt[0]);

                    y = Double.parseDouble(starAtt[1]);

                   // System.out.println("x: " + x);

                    System.out.println("y: " + y);

                    henryDraper = Integer.parseInt(starAtt[3]);

                    magnitude = Double.parseDouble(starAtt[4]);

                  //  System.out.println("henryDraper: " + henryDraper);
//
                   // System.out.println("magnitude: " + magnitude);

                    if(starAtt.length >= 7)

                    {

                        for (int i=6; i<starAtt.length; i++)

                        {

                            if (i == 6){

                                starName = starAtt[6];

                            }else{

                                starName = starName + " " + starAtt[i];

                            }

                        }

                        namesLst.add(starName);  

                   //     System.out.println ("Star Names:" + namesLst.toString());

                    }

                    star = new Star(x, y,henryDraper, magnitude,namesLst);

                    this.starsLst.add(star);

                }

                else{

                  //  System.out.println("Line: " + line); 

                    starAtt = starAttTmp[0].split(" ");

                    x = Double.parseDouble(starAtt[0]);

                    y = Double.parseDouble(starAtt[1]);

                  //  System.out.println("x: " + x);

                  //  System.out.println("y: " + y);

                    henryDraper = Integer.parseInt(starAtt[3]);

                    magnitude = Double.parseDouble(starAtt[4]);

                 //   System.out.println("henryDraper: " + henryDraper);

                //    System.out.println("magnitude: " + magnitude);

                    namesLst.add(starAtt[6]);

                    for (int i = 1; i< starAttTmp.length; i++)

                    {

                        namesLst.add (starAttTmp[i]);

                    }

                    System.out.println ("Star Names:" + namesLst.toString());

                    star = new Star(x, y,henryDraper, magnitude,namesLst);

                    this.starsLst.add(star);

                }     

                line = reader.readLine();

            }

            System.out.println ("Number of Lines:" + numLines);

        }

        catch(Exception e){

             System.out.print(e.getMessage());

        }

    }

    private void populateMaps()

    {

        for(Star star: starsLst)

        {

            Point point = new Point(star.getX(),star.getY());

            this.Star.put(new Integer(star.getHenryDraper()), point);

            for(String name: star.getStarNames()){

                this.StarName.put(name.trim(),new Integer(star.getHenryDraper()));

            }

        }

    }

    public void drawStars()

    {

        StdDraw.clear(StdDraw.BLACK);

        StdDraw.setPenColor(StdDraw.WHITE);

        for(Star star: starsLst)

        {

            StdDraw.filledCircle(star.x,star.y,star.getStarRadius(star.getMagnitude()));

        }

    }

    public void drawConstellation(String fileName){

        BufferedReader reader;

        try{

            reader = new BufferedReader(new FileReader(fileName));

            String line = reader.readLine();

            while(line != null)

            {

                String[] names = line.split(",");

               // System.out.println("Source star name:" + names[0]);

                Integer objSrcDrapeNum = (Integer)this.StarName.get(names[0].trim());

                if (objSrcDrapeNum != null){

                  //  System.out.println("Source star drape number:" + objSrcDrapeNum.intValue());

                }

                Point srcPoint = (Point)this.Star.get(objSrcDrapeNum);

               // System.out.println("Source coordinates");

                if (srcPoint != null)

                {

                    //System.out.println("X:" + srcPoint.getX());

                   // System.out.println("Y:" + srcPoint.getY());

                }

                //System.out.println("Dest star name:" + names[1]);

                Integer objDestDrapeNum = (Integer)this.StarName.get(names[1].trim());

                if (objDestDrapeNum != null){

                    //System.out.println("Dest star drape number:" + objDestDrapeNum.intValue());

                }

                Point destPoint = (Point)this.Star.get(objDestDrapeNum);

               // System.out.println("Destination coordinates");

                if (destPoint != null)

                {

                   // System.out.println("X:" + destPoint.getX());

                 //   System.out.println("Y:" + destPoint.getY());

                }

                StdDraw.setPenColor(StdDraw.YELLOW);

                StdDraw.line(srcPoint.getX(),srcPoint.getY(), destPoint.getX(),destPoint.getY());

                line = reader.readLine();

            }

        }catch(Exception e){

           System.out.print(e.getMessage());

        }

    }

}

