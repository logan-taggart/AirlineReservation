/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package builders;

import airlinereservationclasses.Reservation;
import airlinereservationclasses.Ticket;

import airports.LayoverDecorator;

import interfaces.Airport;

import java.util.List;

public class ReservationBuilder {
    /**
     * The private Ticket List representing the list of each individual ticket's information
     */
    private List<Ticket> airplaneTickets;
    /**
     * The private Airport representing the starting airport
     */
    private Airport originatingAirport;
    /**
     * The private Airport representing the ending airport
     */
    private Airport destinationAirport;
    /**
     * The private LayoverDecorator representing
     */
    private LayoverDecorator layovers;

    /**
     * The Constructor for the ReservationBuilder
     */
    public ReservationBuilder() {}

    /**
     * Sets the value of the airplaneTickets list for the builder
     * @param airplaneTickets Ticket List Representing the information of each individual ticket
     * @return ReservationBuilder Representing the ReservationBuilder object
     * @throws IllegalArgumentException if airplaneTickets is null
     */
    public ReservationBuilder setAirplaneTickets(List<Ticket> airplaneTickets) {
        if (airplaneTickets == null) {
            throw new IllegalArgumentException("Bad param setAirplaneTickets");
        }

        this.airplaneTickets = airplaneTickets;

        return this;
    }

    /**
     * Sets the value of originatingAirport for the builder
     * @param originatingAirport Airport Representing the starting airport
     * @return ReservationBuilder Representing the ReservationBuilder object
     * @throws IllegalArgumentException if originatingAirport is null
     */
    public ReservationBuilder setOriginatingAirport(Airport originatingAirport) {
        if (originatingAirport == null) {
            throw new IllegalArgumentException("Bad param setOriginatingAirport");
        }

        this.originatingAirport = originatingAirport;

        return this;
    }

    /**
     * Sets the value of destinationAirport for the builder
     * @param destinationAirport Airport Representing the ending airport
     * @return ReservationBuilder Representing the ReservationBuilder object
     * @throws IllegalArgumentException if destinationAirport is null
     */
    public ReservationBuilder setDestinationAirport(Airport destinationAirport) {
        if (destinationAirport == null) {
            throw new IllegalArgumentException("Bad param destinationAirport");
        }

        this.destinationAirport = destinationAirport;

        return this;
    }

    /**
     * Sets the value of layovers for the builder
     * @param layovers LayoverDecorator Representing the information for the flight's layovers
     * @return ReservationBuilder Representing the ReservationBuilder object
     */
    public ReservationBuilder setLayovers(LayoverDecorator layovers) {
        this.layovers = layovers;

        return this;
    }

    /**
     * Calls the reservation constructor with instance fields to create a new Reservation object
     * @return Reservation Representing the new Reservation object
     */
    public Reservation getReservation() {
        return new Reservation(airplaneTickets, originatingAirport, destinationAirport, layovers);
    }
}