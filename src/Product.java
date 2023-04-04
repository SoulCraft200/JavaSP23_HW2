public class Product {
    private SaleDate date;
    private String name;
    private double price;

    public Product(SaleDate date, String name, double price){
        this.date = date;
        this.name = name;
        this.price = price;
    }

    public SaleDate getDate(){
        return date;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
