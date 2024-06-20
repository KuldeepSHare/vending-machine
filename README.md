## Vending Machine Program

This program is intended to simulate a vending machine. 
Takes in payment, checks if product is in stock, returns product and change, or an error and returns payment. 

## How I want this to work

I want this program to display which products with accompanying price are available.
when a product is chosen, the price of the product is returned. 
Ask for payment, once received, check if it is enough. 
Check if the till has enough change ---with neccessary denominations
Provide Product and Change
end program

## Things to keep in mind 

Keep track of :
    product: amount and price
    Payment: amount received
    ---Till: amount of each denomination available to use as change

Calculates:
    change: amount
    ---currency: denominations to provide change

Errors:
    not enough payment for selected product
    ---Payment only accepts dollars and coins, nothing larger than a $20 bill, does not accept 50cent coins
    Product out of stock
    not enough change/---denominations remaining

## Things to add later
--- denominations and till 

--/--only 1 transaction at a time, providing change after each (won't be neccssary until a gui is built and program altered to do multiple transactions)

Restocking function and possibly a passcode/key to prevent unauthorized access

## Notes

So far, the program will ask for a product and a payment but does not address things when out of stock
I need to provide a status saying whether a product is in stock or not
I need to tell the customer to choose another product if the one they chose is out of stock and allow 
     them to make another choice.
I need to do something similar for payments: not enough payment, not enough change

I would like to seperate payments from selection, but was unable to due to scanner.close() issues
    - When i closed to the scanner in selection then attempted to use it in a static void pay method,
    it would throw a NoSuchElementException, combining the pay method into the selection method resolved
    this issue but doesnt allow me to make seperate modules for these processes

    Potential work arounds: 
        1. declare scanner object at class level
        2. pass in scanner object as arguement
        3. only close scanner at the very end of the program

Till Class has not been used yet