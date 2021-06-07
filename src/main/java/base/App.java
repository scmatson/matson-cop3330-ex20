package base;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Scott Matson
 */
/*
Exercise 20 - Multistate Sales Tax Calculator

More complex programs may have decisions nested in other decisions, so that when one decision is made, additional decisions must be made.

Create a tax calculator that handles multiple states and multiple counties within each state.
The program prompts the user for the order amount and the state where the order will be shipped.

-Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents, prompt for the county of residence.
    --For Eau Claire county residents, add an additional 0.005 tax.
    --For Dunn county residents, add an additional 0.004 tax.
-Illinois residents must be charged 8% sales tax with no additional county-level charge.
-All other states are not charged tax.

The program then displays the tax and the total for Wisconsin and Illinois residents but just the total for everyone else.

Example Output

What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane
The tax is $0.50.
The total is $10.50.

Constraints
-Ensure that all money is rounded up to the nearest cent.
-Use a single output statement at the end of the program to display the program results.

Challenges
-Add support for your state and county.
-Allow the user to enter a state abbreviation and county name in upper, lower, or mixed case.
-Allow the user to also enter the state’s full name in upper, lower, or mixed case.
-Implement the program using data structures to avoid nested if statements.
 */
public class App {
    static Scanner ui = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("##0.00");

    public static void main(String[] args) {
        System.out.print("What is the order amount? ");
        int amount = ui.nextInt();

        ui.nextLine();
        System.out.print("What state do you live in? ");
        String state = ui.nextLine();
        String state_test = state.toLowerCase();
        double price, total_tax;

        if(state_test.equals("wisconsin")) //5% sales tax
        {
            double wtax = 0.05;
            System.out.print("What county do you live in? ");
            String county = ui.nextLine();
            String county_test = county.toLowerCase();

            if(county_test.equals("eau claire"))
            {
                total_tax = (amount * (wtax + 0.005));
                price = amount + total_tax;
            }
            else if(county_test.equals("dunn"))
            {
                total_tax = (amount * (wtax + 0.004));
                price = amount + total_tax;
            }
            else
            {
                total_tax = (wtax * amount);
                price = amount + total_tax;
            }
        }

        else if(state_test.equals("illinois"))
        {
            double itax = 0.08;
            total_tax = (itax * amount);
            price = amount + (amount * itax);
        }

        else //All other states no tax
        {
            price = amount;
            total_tax = 0.00;
        }

        System.out.println("The tax is $" + df.format(total_tax) + ".\nThe total is $" + df.format(price) + ".");
    }
}
