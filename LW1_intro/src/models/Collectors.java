package models;

import java.util.Comparator;

public class Collectors implements Comparable<Collectors>
{
    public String CollectorSurName;
    public String StampName;
    public int NumberOfStamps;
    public double Price;

    public Collectors()
    {

    }
    public Collectors(String collectorSurName, String stampName,int numberOfStamps, double price)
    {
        this.CollectorSurName = collectorSurName;
        this.StampName = stampName;
        this.NumberOfStamps = numberOfStamps;
        this.Price = price;
    }

    @Override
    public String toString()
    {
    return String.format("| %11s  | %9s   |     %5d        |     %5.2f    |",GetSurName(),GetStampName(),GetNoOfStamp(),GetPrice());
    }


    public String  GetSurName()
    {
        return this.CollectorSurName;
    }

    public String  GetStampName()
    {
        return this.StampName;
    }

    public int GetNoOfStamp()
    {
        return this.NumberOfStamps;
    }

    public double GetPrice()
    {
        return this.Price;
    }

    public boolean Equals(Collectors col)
    {
        return (col.CollectorSurName== CollectorSurName &&
                (col.StampName == StampName)) &&
                (col.NumberOfStamps == NumberOfStamps)&&(col.Price == Price) ;
    }


    @Override
    public int compareTo(Collectors other) {
        int ip1 = StampName.compareTo(other.StampName) ;
        if (ip1 > 0 || (ip1==0 && Price > other.Price) )
            return 1;
        else if (ip1 < 0 || (ip1 == 0 && Price < other.Price))
            return -1;
        return 0;
    }
}
