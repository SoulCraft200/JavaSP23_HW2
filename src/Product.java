/**
 * The type Product.
 */
public class Product {
    private SaleDate date;
    private String name;
    private double price;

    /**
     * Instantiates a new Product.
     */
    public Product(){}

    /**
     * Instantiates a new Product.
     *
     * @param date  the date
     * @param name  the name
     * @param price the price
     */
    public Product(SaleDate date, String name, double price){
        this.date = date;
        this.name = name;
        this.price = price;
    }

    /**
     * Get date sale date.
     *
     * @return the sale date
     */
    public SaleDate getDate(){
        return date;
    }

    /**
     * Get name string.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Get price double.
     *
     * @return the double
     */
    public double getPrice(){
        return price;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(SaleDate date) {
        this.date = date;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
