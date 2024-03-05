/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package interfaces;

public interface SeatClassCostBehavior {
    /**
     * The calculateCost method
     * @param baseTicketCost int Representing the base cost of the ticket
     * @param checkedBags int Representing the amount of bags being checked for the ticket
     * @return int Representing the cost of the individual ticket
     */
    int calculateCost(int baseTicketCost, int checkedBags);
}