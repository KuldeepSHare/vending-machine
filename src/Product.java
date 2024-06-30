public class Product {

    private String name;
    private double price;
    private int amount;

    /* Constructor */
    public Product(String n, double p, int a){
        name = n;
        price = p;
        amount = a;
    }

    /* Accessors and Mutators */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }    
    public double getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }    
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /* returns String with Product name and Price */
    public String showProduct() {
        return (name + " $" + String.format("%.2f", price));
    }

}
