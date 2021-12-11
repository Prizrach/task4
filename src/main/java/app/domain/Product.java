package app.domain;

public class Product {
    private String name;
    private double price;
    private int id;


//    public Product(String name, double price) {
//        this.name = name;
//        this.price = price;
//    }

     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double prise) {
        this.price = prise;
    }


}
