package app.domain;

public class Product {
    private String title;
    private double price;
    private int id;


//    public Product(String name, double price) {
//        this.name = name;
//        this.price = price;
//    }


    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double prise) {
        this.price = prise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
