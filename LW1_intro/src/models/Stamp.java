package models;

public class Stamp implements Comparable<Stamp>
{
    public String StampName;
    public int IssueYear;
    public double AvgPrice;

    public Stamp()
    {

    }

    public Stamp(String stampName,int issueYear,double avgPrice)
    {
        this.StampName = stampName;
        this.IssueYear = issueYear;
        this.AvgPrice = avgPrice;
    }


    public boolean Equals(Stamp stmp)
    {
        return (stmp.StampName == this.StampName) &&
                (stmp.IssueYear == this.IssueYear &&
                        (stmp.AvgPrice == this.AvgPrice));
    }

    @Override
    public  String toString()
{
    return String.format("| %8s      |  %9d     | %8.2f      |",GetStampName(),GetIssueYear(),GetAngPrice());
}
    public String GetStampName()
    {
        return this.StampName;
    }

    public int GetIssueYear()
    {
        return this.IssueYear;
    }

    public double GetAngPrice()
    {
        return this.AvgPrice;
    }

    @Override
    public int compareTo(Stamp other) {
        int ip1 = StampName.compareTo(other.StampName) ;
        if (ip1 > 0 || (ip1==0 && AvgPrice > other.AvgPrice) )
            return 1;
        else if (ip1 < 0 || (ip1 == 0 &&AvgPrice < other.AvgPrice))
            return -1;
        return 0;
    }
}
