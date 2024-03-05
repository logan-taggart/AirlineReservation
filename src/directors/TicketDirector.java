/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package directors;

import airlinereservationclasses.Person;
import airlinereservationclasses.Seat;
import airlinereservationclasses.Ticket;

import builders.TicketBuilder;

public class TicketDirector {
    /**
     * The private TicketBuilder representing the TicketBuilder object
     */
    private TicketBuilder ticketBuilder;
    /**
     * The private Person representing the Person object
     */
    private Person passenger;
    /**
     * The private Seat representing the Seat object
     */
    private Seat seat;

    /**
     * The TicketDirector Constructor that creates a new ticketDirector object from
     * the passed in param
     * @param ticketBuilder TicketBuilder Representing a ticketBuilder object
     * @throws IllegalArgumentException if ticketBuilder object is null
     */
    public TicketDirector(TicketBuilder ticketBuilder) {
        if (ticketBuilder == null) {
            throw new IllegalArgumentException("Bad param TicketDirector Constructor");
        }

        this.ticketBuilder = ticketBuilder;
    }

    /**
     * Sets the value of passenger for the director
     * @param passenger Person Representing a person object
     * @throws IllegalArgumentException if passenger is null
     */
    public void setPassenger(Person passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Bad param setPassenger");
        }

        this.passenger = passenger;
    }

    /**
     * Sets the value of seat for the director
     * @param seat Seat Representing a seat object
     * @throws IllegalArgumentException if seat is null
     */
    public void setSeat(Seat seat) {
        if (seat == null) {
            throw new IllegalArgumentException("Bad param setSeat");
        }

        this.seat = seat;
    }

    /**
     * Sets all the values of the variables necessary to create a Ticket instance in the ticketBuilder
     * then calls the getTicket() method in the ticketBuilder which creates a new Ticket
     * @return Ticket Representing the ticket object set in this file
     */
    public Ticket buildTicket() {
        return ticketBuilder.setPassenger(passenger)
                .setSeat(seat)
                .getTicket();
    }
}