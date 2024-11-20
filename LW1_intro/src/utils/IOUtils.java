package utils;
import models.Collectors;
import models.Stamp;

import java.io.*;
import java.util.Scanner;

public class IOUtils
{
    public static LinkedList<models.Stamp> ReadStamp(String filename)
    {
        LinkedList<models.Stamp> selectedStamp = new LinkedList<models.Stamp>();
        FileInputStream fileStream ;
        Scanner scanner = null;
        try {
            fileStream = new FileInputStream(filename);
            scanner = new Scanner(fileStream, "UTF-8");

            while (scanner.hasNextLine())
            {
                String[] lines = scanner.nextLine().split(";");
                selectedStamp.add(new Stamp(lines[0], Integer.parseInt(lines[1]), Double.parseDouble(lines[2])));
            }
            fileStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (scanner != null)
            {
                scanner.close();
            }
        }
    return selectedStamp ;
    }

    public static LinkedList<models.Collectors> ReadCollectors(String filename)
    {
        LinkedList<models.Collectors> selectedCollectors = new LinkedList<models.Collectors>();
        FileInputStream fileStream2 = null;
        Scanner scanner = null;
        try {
            fileStream2 = new FileInputStream(filename);
            scanner = new Scanner(fileStream2, "UTF-8");

            while (scanner.hasNextLine())
            {
                String[] lines = scanner.nextLine().split(";");
                selectedCollectors.add(new Collectors(lines[0],lines[1],Integer.parseInt(lines[2]),Double.parseDouble(lines[3])));
            }
            fileStream2.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (scanner != null)
            {
                scanner.close();
            }
        }
        return selectedCollectors;
    }


public static void DisplayCollectors(String Header,LinkedList<Collectors> C)
    {
        System.out.println("\n"+Header);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("|    SurName   |   StampName |     No.Of Stamps |     Price    |");
        System.out.println("-------------------------------------------------------------------");
       for(Collectors c: C)
       {
           System.out.println(c.toString());
       }
        System.out.println("-------------------------------------------------------------------");
    }

    public static void DisplayStamps(String Header,LinkedList<Stamp> S)
    {
        System.out.println("\n"+Header);
        System.out.println("----------------------------------------------------");
        System.out.println("|  StampName    |  Year of issue | Average price |");
        System.out.println("----------------------------------------------------");
        for(int i=0;i<S.Count;i++)
        {
            Stamp s=S.get(i);
            System.out.println(s.toString());
        }
        System.out.println("----------------------------------------------------");
    }

   public static void DisplayResultCollector(String Header, LinkedList<Collectors> C, PrintWriter pw)
   {
       pw.println("\n"+Header);
       pw.println("-------------------------------------------------------------------");
       pw.println("|    SurName   |   StampName |     No.Of Stamps |     Price    |");
       pw.println("-------------------------------------------------------------------");
       for(Collectors c: C)
       {
           pw.println(c.toString());
       }
       pw.println("-------------------------------------------------------------------");


   }
    public static void DisplayResultStamp(String Header, LinkedList<Stamp> S, PrintWriter pw)
    {
        pw.println("\n"+Header);
        pw.println("----------------------------------------------------");
        pw.println("|  StampName    |  Year of issue | Average price |");
        pw.println("----------------------------------------------------");
        for(Stamp s: S)
        {
            pw.println(s.toString());
        }
        pw.println("----------------------------------------------------");

    }
}
