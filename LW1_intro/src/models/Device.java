package models;

public class Device {
    String Name;
    String Code;
    int age;
    double price;

    public Device(){}

    public Device( String Name,String Code,double price){
        this.Name = Name;
        this.Code = Code;
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format("%s %s price: %.2f ", Name, Code, price);
    }

    @Override
    public boolean equals(Object Device) {
        return ((Device) Device).Name.equals(this.Name) && ((Device) Device).Code.equals(this.Code);
    }
}
