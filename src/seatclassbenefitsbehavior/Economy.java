/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package seatclassbenefitsbehavior;

import interfaces.SeatClassCostBehavior;
public class Economy implements SeatClassCostBehavior {
    /**
     * The calculateCost method for economy class. It charges $25 for each checked bag.
     * @param baseTicketCost int Representing the base cost of the ticket
     * @param checkedBags int Representing the amount of bags being checked for the ticket
     * @return int Representing the total cost of the individual ticket
     */
    public int calculateCost(int baseTicketCost, int checkedBags) {
        if (baseTicketCost < 0 || checkedBags < 0) {
            throw new IllegalArgumentException("Bad params calculateCost");
        }

        return baseTicketCost + checkedBags * 25;
    }

    /**
     * The toString method that returns the string "Economy Class".
     * Overrides: toString in class Object
     * @return String Representing the name of the seat class
     */
    @Override public String toString() {
        return "Economy Class";
    }
}