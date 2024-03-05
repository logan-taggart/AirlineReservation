/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package directors;

import airlinereservationclasses.Seat;
import airlines.Airline;

import builders.SeatBuilder;

import interfaces.SeatClassCostBehavior;

public class SeatDirector {
    /**
     * The private SeatBuilder representing the SeatBuilder object
     */
    private SeatBuilder seatBuilder;
    /**
     * The private Airline representing the specific airline
     */
    private Airline airline;
    /**
     * The private SeatClassCostBehavior representing the class of the seat
     */
    private SeatClassCostBehavior seatClass;
    /**
     * The private String representing the specific seat
     */
    private String seat;

    /**
     * The SeatDirector Constructor that creates a new seatDirector object from
     * the passed in param
     * @param seatBuilder SeatBuilder Representing a seatBuilder object
     * @throws IllegalArgumentException if seatBuilder object is null
     */
    public SeatDirector(SeatBuilder seatBuilder) {
        if (seatBuilder == null) {
            throw new IllegalArgumentException("Bad param SeatDirector Constructor");
        }

        this.seatBuilder = seatBuilder;
    }

    /**
     * Sets the value of airline for the director
     * @param airline Airline Representing the specific airline
     * @throws IllegalArgumentException if airline is null
     */
    public void setAirline(Airline airline) {
        if (airline == null) {
            throw new IllegalArgumentException("Bad param setAirline");
        }

        this.airline = airline;
    }

    /**
     * Sets the value of seatClass for the director
     * @param seatClass SeatClassCostBehavior Representing the class of the seat
     * @throws IllegalArgumentException if seatClass is null
     */
    public void setSeatClass(SeatClassCostBehavior seatClass) {
        if (seatClass == null) {
            throw new IllegalArgumentException("Bad param setSeatClass");
        }

        this.seatClass = seatClass;
    }

    /**
     * Sets the value of seat for the director
     * @param seat String Representing the specific seat
     * @throws IllegalArgumentException if seat is null
     */
    public void setSeat(String seat) {
        if (seat == null) {
            throw new IllegalArgumentException("Bad param setSeat");
        }

        this.seat = seat;
    }

    /**
     * Sets all the values of the variables necessary to create a Seat instance in the seatBuilder
     * then calls the getSeat() method in the seatBuilder which creates a new Seat
     * @return Seat Representing the seat object set in this file
     */
    public Seat buildSeat() {
        return seatBuilder.setAirline(airline)
                .setSeatClass(seatClass)
                .setSeat(seat)
                .getSeat();
    }
}