
import java.util.Scanner;

/**
 * This a basic vending machine controlled via terminal and providing change
 * with denominations
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
        Scanner scanner = new Scanner(System.in);
        selection(prod, scanner);
        scanner.close(); 
        System.out.println("Thank You for shopping at Kuldeep's Vending Machine and have a nice day.");
    }

    public static void selection(Product[] prod, Scanner scanner) {
        System.out.println("Which item would you like?");
        
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
                        pay(prod[num].getPrice(), scanner);
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
                    
    }

    public static void pay(double cost, Scanner scanner) {

        System.out.println("Enter your payment amount.");
        double payment;
        
        // checks if we have the product, whether payment is sufficient, and required
        // change is available
        try {
            payment = scanner.nextDouble();
            while(payment < cost) {
                System.out.println("Payment is insufficient, please provide additional funds.");
                payment += scanner.nextDouble();
            }
            System.out.println("You provided: " + Double.toString(payment));
            getChange(cost, payment);

        } catch (NumberFormatException e) {
            System.out.println("Invalid Payment. Please enter an amount in dollars and cents.");
        }
        
    }


    /**
     * returns change in denominations of $10, $5, $1, 25cents, 10cents, 5cents, 1cent
     * @param cost
     * @param payment
     */
    public static void getChange(double cost, double payment) {
        // Create an array of Denominations objects
        Denominations[] denominations = {
            new Denominations(20.00, "$20 bills"),
            new Denominations(10.00, "$10 bills"),
            new Denominations(5.00, "$5 bills"),
            new Denominations(1.00, "$1 bills"),
            new Denominations(0.25, "Quarters"),
            new Denominations(0.10, "Dimes"),
            new Denominations(0.05, "Nickels"),
            new Denominations(0.01, "Pennies")
        };
    
        double changeAmount = payment - cost;
        String changeInDenominations = "Your Change is: $" + String.format("%.2f", changeAmount) + "\nBreakdown:\n";
    
        int changeInCents = (int) Math.round(changeAmount * 100);
    
        for (Denominations denom : denominations) {
            int denomInCents = (int) Math.round(denom.getValue() * 100);
            while (changeInCents >= denomInCents) {
                changeInCents -= denomInCents;
                denom.incrementAmount();
            }
            changeInDenominations += denom.getName() + ": " + denom.getAmount() + "\n";
        }
    
        // Print the change in denominations
        System.out.println(changeInDenominations);
    }
    
}
