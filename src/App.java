
import java.util.Scanner;

/**
 * This a basic vending machine controlled via terminal and providing change
 * without denominations
 * 
 * @author Kuldeep Singh Hare
 * @version 1.0
 */

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Kuldeep's Vending Machine");

        System.out.println("We have the Following Products Available:");

        Product[] prod = {
            new Product("Doritos", 1.75, 10),
            new Product("Snickers", 2.00, 10),
            new Product("Nuka Cola", 1.50, 10),
            new Product("Poland Spring", 1.00, 10),
            new Product("Stims", 2.50, 10),
        };

        for (int i = 0; i < prod.length; i++) {
            System.out.println(i + 1 + ". " + prod[i].showProduct());
        }
        selection(prod);

    }

    public static void selection(Product[] prod) {
        System.out.println("Which item would you like?");
        Scanner scanner = new Scanner(System.in);
        int num;
        boolean validInput = false;
        
        // Asks for Product Choice
        while(!validInput) {
        
            try {
                
                num = scanner.nextInt() -1;
                if(num == 98) {
                    System.out.println("You have chosen to end Vending Machine Program.");
                    break;
                } else if((num >= 0) && (num < prod.length)) {

                    System.out.println("You chose " + prod[num].getName() + " which costs $" 
                        + String.format("%.2f", prod[num].getPrice()) + ".");

                    if (prod[num].getAmount() < 1) {
                        System.out.println("Unfortunately we are out of this product, please choose another. To exit program enter 99");
                        
                    } else {
                        pay(num);
                        validInput = true;                        
                    }
                } else {
                    System.out.println("Please enter a value between 1 and " + prod.length + " or 99 to exit program");
                } 


            } catch (java.util.InputMismatchException e) {
                System.out.println("Exception: Invalid Selection. Please enter a valid integer from 1 through " 
                    + (prod.length+1) + ".");
        }

    }
        scanner.close();             
    }

    public static void pay(int choice) {

        System.out.println("Enter your payment amount.");
        double payment;
        Scanner scanner = new Scanner(System.in);
        // Till t = new Till();

        // checks if we have the product, whether payment is sufficient, and required
        // change is available
        try {
            payment = scanner.nextDouble();
            System.out.println("You paid: " + Double.toString(payment));

        } catch (NumberFormatException e) {
            System.out.println("Invalid Payment. Please enter an amount in dollars and cents.");
        }

        // placeholder
        System.out.println("@@@@@@Calculate change and deliver product here.");
    }


    /**
     * returns change in denominations of $10, $5, $1, 25cents, 10cents, 5cents, 1cent
     * @param cost
     * @param payment
     */
    public static void getChange(double cost, double payment) {
        // $20 bills $10 bills, $5 bills, %1 bills, 25c, 10c, 5c, 1c

        //Denominations[] denom = new Denominations[8];

        Integer denominations[] = {0, 0, 0, 0, 0, 0, 0, 0};
       
        final double bill_20 = 20.0;
        final double bill_10 = 10.0;
        final double bill_5 = 5.0;
        final double bill_1 = 1.0;
        final double quarter = 0.25;
        final double dime = 0.10;
        final double nickel = 0.05;
        final double penny = 0.01;

        double changeAmount = cost - payment;

        while(changeAmount >= bill_20){
            changeAmount /= bill_20;
            denominations[0]++;
        }

        while(changeAmount >= bill_10){
            changeAmount /= bill_10;
            denominations[1]++;
        }

        while(changeAmount >= bill_5){
            changeAmount /= bill_5;
            denominations[2]++;
        }

        while(changeAmount >= bill_1){
            changeAmount /= bill_1;
            denominations[3]++;
        }

        while(changeAmount >= quarter){
            changeAmount /= quarter;
            denominations[4]++;
        }

        while(changeAmount >= dime){
            changeAmount /= dime;
            denominations[5]++;
        }

        while(changeAmount >= nickel){
            changeAmount /= nickel;
            denominations[6]++;
        }

        while(changeAmount >= penny){
            changeAmount /= penny;
            denominations[7]++;
        }

        // either return an array or print the change here

    }


}
