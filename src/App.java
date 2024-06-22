
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
        
        // Asks for Product Choice
        try {
            boolean b = false; // if input is valid, b = false, ends loop
            do {
                b = true;
                num = scanner.nextInt() -1;
                System.out.println("You chose " + prod[num].getName() + " which costs $" 
                + String.format("%.2f", prod[num].getPrice()) + ".");

                if((num > 0) && (num < prod.length)) {
                    if (prod[num].getAmount() < 1) {
                        System.out.println("Unfortunately we are out of this product, please choose another. To exit program enter 99");
                        b = true;
                    } else {
                        pay(num);
                        b = false;
                    }
                } else if(num == 99) {
                    System.out.println("You have chosen to end Vending Machine Program.");
                    break;
                } else {
                    System.out.println("Please enter a value between 1 and " + prod.length + " or 99 to exit program");
                    b = true;
                }

                /* 
                if (prod[num].getAmount() < 1) {
                    System.out.println("Unfortunately we are out of this product, please choose another. To exit program enter 99");
                    b = true;
                }
                else if(num == 99) {
                    System.out.println("You have chosen to end Vending Machine Program.");
                    break;
                }
                else if(num > prod.length) {
                    System.out.println("Please enter a value between 1 and " + prod.length + " or 99 to exit program");
                    b = true;
                }
                else {
                    pay(num);
                    b = false;
                }
                */

            } while(b); 
                     
            

            /* I need to check if chosen product is available, if not, then ask the user for another choice
                Check README ## Notes for additional info
            
            */ 


        } catch (Exception e) {
            System.out.println("Exception: Invalid Selection. Please enter a valid integer from 1 through " 
                + (prod.length+1) + ".");
        }


        //scanner.close();             
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

}
