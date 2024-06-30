/**
 * this class creates an object of type denominations which contains:
 *  an int that keeps a tally of the number of times that denomination is required
 * a double which contains the value of this denomination in dollars and cents
 * a string used to hold the name of this denomination
 */
public class Denominations {

    int amount;
    double value;
    String name;

    /* Constructor */
    public Denominations(double v, String n){
            amount = 0;
            value = v;
            name = n;
        }

    /* Accessors */
    public int getAmount() {
        return amount;
    }
    public double getValue() {
        return value;
    }
    public String getName() {
        return name;
    }

    /* Mutators */
    public void setAmount(int a) {
        this.amount = a;
    }    
    public void setValue(double v) {
        value = v;
    }
    public void setName(String n) {
        name = n;
    }

}
