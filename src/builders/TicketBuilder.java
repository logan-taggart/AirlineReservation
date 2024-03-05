/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package builders;

import airlinereservationclasses.Person;
import airlinereservationclasses.Seat;
import airlinereservationclasses.Ticket;

public class TicketBuilder {
    /**
     * The private Person representing the Person object
     */
    private Person passenger;
    /**
     * The private Seat representing the Seat object
     */
    private Seat seat;

    /**
     * The Constructor for the TicketBuilder
     */
    public TicketBuilder() {}

    /**
     * Sets the value of passenger for the builder
     * @param passenger Person Representing the passenger
     * @return TicketBuilder Representing the TicketBuilder object
     * @throws IllegalArgumentException if passenger is null
     */
    public TicketBuilder setPassenger(Person passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Bad param setPassenger");
        }

        this.passenger = passenger;
        return this;
    }

    /**
     * Sets the value of seat for the builder
     * @param seat Seat Representing the seat
     * @return TicketBuilder Representing the TicketBuilder object
     * @throws IllegalArgumentException if seat is null
     */
    public TicketBuilder setSeat(Seat seat) {
        if (seat == null) {
            throw new IllegalArgumentException("Bad param setSeat");
        }

        this.seat = seat;
        return this;
    }

    /**
     * Calls the ticket constructor with instance fields to create a new Ticket object
     * @return Ticket Representing the new Ticket object
     */
    public Ticket getTicket() {
        return new Ticket(passenger, seat);
    }
}
