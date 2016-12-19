package myclass;
public class Product {
    String ID;
    String Name;
    String Type;
    double Price;

    public Product(String ID, String Name, String Type, double Price) {
        this.ID = ID;
        this.Name = Name;
        this.Type = Type;
        this.Price = Price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
}
