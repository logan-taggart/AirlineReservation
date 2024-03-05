/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package seatclassbenefitsbehavior;

import interfaces.SeatClassCostBehavior;
public class Comfort implements SeatClassCostBehavior {
    /**
     * The calculateCost method for comfort class. It raises the base price of the ticket by 50%
     * then charges $25 for each checked bag after the first one.
     * @param baseTicketCost int Representing the base cost of the ticket
     * @param checkedBags int Representing the amount of bags being checked for the ticket
     * @return int Representing the total cost of the individual ticket
     */
    public int calculateCost(int baseTicketCost, int checkedBags) {
        if (baseTicketCost < 0 || checkedBags < 0) {
            throw new IllegalArgumentException("Bad params calculateCost");
        }

        int baseClassCost = (int) (baseTicketCost * 1.5);
        int freeBags = 1;
        int paidBags;

        if (checkedBags - freeBags > 0) {
            paidBags = checkedBags - freeBags;
        } else {
            paidBags = 0;
        }

        return baseClassCost + (paidBags * 25);
    }

    /**
     * The toString method that returns the string "Comfort Class".
     * Overrides: toString in class Object
     * @return String Representing the name of the seat class
     */
    @Override public String toString() {
        return "Comfort Class";
    }
}