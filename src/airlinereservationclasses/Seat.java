/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airlinereservationclasses;

import airlines.Airline;

import interfaces.SeatClassCostBehavior;

public class Seat {
    /**
     * The private Airline representing the specific airline
     */
    private Airline airline;
    /**
     * The private SeatClassCostBehavior representing the specific seat class
     */
    private SeatClassCostBehavior seatClass;
    /**
     * The private String representing the location of the specific seat
     */
    private String seat;

    /**
     * The Seat Constructor creates a new Seat object from the passed in params
     * @param airline Airline Representing the specific airline
     * @param seatClass SeatClassCostBehavior Representing the class of the seat
     * @param seat String Representing the location of the specific seat
     * @throws IllegalArgumentException if airline, seatClass, or seat is null
     */
    public Seat(Airline airline, SeatClassCostBehavior seatClass, String seat) {
        if (airline == null || seatClass == null || seat == null) {
            throw new IllegalArgumentException("Bad param Seat Constructor");
        }

        this.airline = airline;
        this.seatClass = seatClass;
        this.seat = seat;
    }

    /**
     * The getSeatClass method retrieves the seatClass field
     * @return SeatClassCostBehavior Representing the class of the seat
     */
    public SeatClassCostBehavior getSeatClass() {
        return this.seatClass;
    }

    /**
     * The toString method combines and formats the seat information
     * Overrides: toString in class Object
     * @return String representing the details of the seat
     */
    @Override
    public String toString() {
        return
                "Seat Information:" + "\n\t\t"
                + this.airline + "\n\t\t"
                + this.seatClass.toString() + "\n\t\t"
                + "Seat " + this.seat;
    }
}
