/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package directors;

import airlinereservationclasses.Reservation;
import airlinereservationclasses.Ticket;
import airports.LayoverDecorator;

import interfaces.Airport;

import builders.ReservationBuilder;

import java.util.List;

public class ReservationDirector {
    /**
     * The private ReservationBuilder representing the ReservationBuilder object
     */
    private ReservationBuilder reservationBuilder;
    /**
     * The private Ticket List representing the collection of info from each individual ticket
     */
    private List<Ticket> airplaneTickets;
    /**
     * The private Airport Representing the airport that the flight is starting at
     */
    private Airport originatingAirport;
    /**
     * The private Airport Representing the airport that the flight is ending at
     */
    private Airport destinationAirport;
    /**
     * The private LayoverDecorator Representing the information about any layovers the flight has
     */
    private LayoverDecorator layovers;

    /**
     * The ReservationDirector Constructor that creates a new reservationDirector object from
     * the passed in param
     * @param reservationBuilder ReservationBuilder Representing a personBuilder object
     * @throws IllegalArgumentException if reservationBuilder object is null
     */
    public ReservationDirector(ReservationBuilder reservationBuilder) {
        if (reservationBuilder == null) {
            throw new IllegalArgumentException("Bad param ReservationDirector Constructor");
        }

        this.reservationBuilder = reservationBuilder;
    }

    /**
     * Sets the value of airplaneTickets for the director
     * @param airplaneTickets Ticket List Representing the ticket info list
     * @throws IllegalArgumentException if airplaneTickets is null
     */
    public void setAirplaneTickets(List<Ticket> airplaneTickets) {
        if (airplaneTickets == null) {
            throw new IllegalArgumentException("Bad param setAirplaneTickets");
        }

        this.airplaneTickets = airplaneTickets;
    }

    /**
     * Sets the value of originatingAirport for the director
     * @param originatingAirport Airport Representing the starting airport
     * @throws IllegalArgumentException if originatingAirport is null
     */
    public void setOriginatingAirport(Airport originatingAirport) {
        if (originatingAirport == null) {
            throw new IllegalArgumentException("Bad param setOriginating");
        }

        this.originatingAirport = originatingAirport;
    }

    /**
     * Sets the value of destinationAirport for the director
     * @param destinationAirport Airport Representing the ending airport
     * @throws IllegalArgumentException if destinationAirport is null
     */
    public void setDestinationAirport(Airport destinationAirport) {
        if (destinationAirport == null) {
            throw new IllegalArgumentException("Bad param setDestination");
        }

        this.destinationAirport = destinationAirport;
    }

    /**
     * Sets the value of layovers for the director
     * @param layovers LayoverDecorator Representing the info about any of the layovers the flight has
     */
    public void setLayovers(LayoverDecorator layovers) {
        this.layovers = layovers;
    }

    /**
     * Sets all the values of the variables necessary to create a Reservatiom instance in the reservationBuilder
     * then calls the getReservation() method in the reservationBuilder which creates a new Reservatiom
     * @return Reservation Representing the reservation object set in this file
     */
    public Reservation buildReservation() {
        return reservationBuilder.setAirplaneTickets(airplaneTickets)
                .setOriginatingAirport(originatingAirport)
                .setDestinationAirport(destinationAirport)
                .setLayovers(layovers)
                .getReservation();
    }
}