public class Product {
    private String date;
    private String name;
    private int price;

    public Product(String date, String name, int price){
        this.date = date;
        this.name = name;
        this.price = price;
    }

    public String getDate(){
        return date;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }
}
