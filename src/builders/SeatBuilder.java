/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package builders;

import airlinereservationclasses.Seat;

import airlines.Airline;

import interfaces.SeatClassCostBehavior;

public class SeatBuilder {
    /**
     * The private Airport representing the specific airline
     */
    private Airline airline;
    /**
     * The private SeatClassCostBehavior representing the specific class of seat
     */
    private SeatClassCostBehavior seatClass;
    /**
     * The private String representing the seat location
     */
    private String seat;

    /**
     * The Constructor for the SeatBuilder
     */
    public SeatBuilder() {}

    /**
     * Sets the value of airline for the builder
     * @param airline Airline Representing the specific airline
     * @return SeatBuilder Representing the SeatBuilder object
     * @throws IllegalArgumentException if airline is null
     */
    public SeatBuilder setAirline(Airline airline) {
        if (airline == null) {
            throw new IllegalArgumentException("Bad param setAirline");
        }

        this.airline = airline;
        return this;
    }

    /**
     * Sets the value of seatClass for the builder
     * @param seatClass SeatClassCostBehavior Representing the specific class of seat
     * @return SeatBuilder Representing the SeatBuilder object
     */
    public SeatBuilder setSeatClass(SeatClassCostBehavior seatClass) {
        if (seatClass == null) {
            throw new IllegalArgumentException("Bad param setSeatClass");
        }

        this.seatClass = seatClass;
        return this;
    }

    /**
     * Sets the value of seat for the builder
     * @param seat Seat Representing the seat location
     * @return SeatBuilder Representing the SeatBuilder object
     */
    public SeatBuilder setSeat(String seat) {
        if (seat == null) {
            throw new IllegalArgumentException("Bad param setSeat");
        }

        this.seat = seat;
        return this;
    }

    /**
     * Calls the seat constructor with instance fields to create a new Seat object
     * @return Seat Representing the new Seat object
     */
    public Seat getSeat() {
        return new Seat(airline, seatClass, seat);
    }
}
