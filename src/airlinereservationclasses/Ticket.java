/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airlinereservationclasses;

import interfaces.SeatClassCostBehavior;

import java.util.Random;
public class Ticket {
    /**
     * The private Person representing the Person object
     */
    private Person passenger;
    /**
     * The private Seat representing the Seat object
     */
    private Seat seat;
    /**
     * The private SeatClassCostBehavior representing the class of the seat
     */
    private SeatClassCostBehavior seatClass;

    /**
     * The Ticket Constructor creates a new Ticket object from the passed in params
     * @param passenger Person Representing the Person object
     * @param seat Seat Representing the Seat object
     * @throws IllegalArgumentException if passenger or seat is null
     */
    public Ticket(Person passenger, Seat seat) {
        if (passenger == null || seat == null) {
            throw new IllegalArgumentException("Bad param Ticket Constructor");
        }

        this.passenger = passenger;
        this.seat = seat;
        this.seatClass = seat.getSeatClass();
    }

    /**
     * The getTicketCost method creates a random cost between $100 and $500 for the ticket
     * @return int Representing the cost of the specific ticket
     */
    public int getTicketCost() {
        int minCost = 100;
        int maxCost = 500;

        Random randomValue = new Random();

        int baseCost = minCost + randomValue.nextInt(maxCost - minCost);

        return this.seatClass.calculateCost(baseCost, passenger.getBagsChecked());
    }

    /**
     * The toString method combines and formats the ticket information.
     * Overrides: toString in class Object
     * @return String representing the ticket information
     */
    @Override
    public String toString() {
        return
                passenger.toString()
                + seat.toString() + "\n";
    }
}