## Vending Machine Program

This program is intended to simulate a vending machine. 
Takes in payment, checks if product is in stock, returns product and change, or an error and returns payment. 

## Things to add later
Till functionality which will provide change based on amounts of each denomination remaining
Multiple transactions
Restocking function and possibly a passcode/key to prevent unauthorized access

## Re-thinking the problem
    getChange(): 
        receives 
            total cash provided
            total cost
        returns: 
            amount of change in the fewest of each denomination of dollar bills and coins

        to do this we will set changeAmount = totalCash - totalCost
            
            As long as changeAmount >= 20Bill
                increment tally20Bill
                decrement the changeAmount by the value of denomination in question (here its 20Bill)
            repeat this for every denomination of dollar bills and coins using the same changeAmount subsequent denomination tallies 
            
        return talley of each denomination, you could do this in an array

## GUI with JavaFX
to be added in later