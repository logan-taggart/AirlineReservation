/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airlinereservationclasses;

import airports.*;

import interfaces.Airport;

import java.util.*;

public class Reservation {
    /**
     * The private Ticket List representing the information from each individual ticket
     */
    private List<Ticket> airplaneTickets;
    /**
     * The private Airport representing the starting airport of the flight
     */
    private Airport originatingAirport;
    /**
     * The private Airport representing the ending airport of the flight
     */
    private Airport destinationAirport;
    /**
     * The private LayoverDecorator representing the information about any layovers the flight has
     */
    private LayoverDecorator layovers;

    /**
     * The Reservation Constructor creates a new Reservation object from the passed in params
     * @param airplaneTickets List Representing the information from each individual ticket
     * @param originatingAirport Airport Representing the starting airport
     * @param destinationAirport Airport Representing the ending airport
     * @param layovers LayoverDecorator Representing the flight's layover information
     * @throws IllegalArgumentException if airplaneTickets, originatingAirport, or destinationAirport is null
     */
    public Reservation(List<Ticket> airplaneTickets, Airport originatingAirport, Airport destinationAirport, LayoverDecorator layovers) {
        if (airplaneTickets == null || originatingAirport == null || destinationAirport == null) {
            throw new IllegalArgumentException("Bad param Reservation Constructor");
        }

        this.airplaneTickets = new ArrayList<>(airplaneTickets);
        this.originatingAirport = originatingAirport;
        this.destinationAirport = destinationAirport;
        this.layovers = layovers;
    }

    /**
     * The totalCost method collects and adds together the cost of all the individual tickets
     * @return int Representing the total cost of the reservation
     */
    public int totalCost() {
        int individualCost = 0;
        int totalCost = 0;

        for (int i = 0; i < airplaneTickets.size(); i++) {
            individualCost = airplaneTickets.get(i).getTicketCost();
            totalCost += individualCost;
        }

        return totalCost;
    }

    /**
     * The getFlightDateAndTime method randomly generates a year, month, day,
     * hour, and minute to be the flight's departure time
     * @return Date Representing the date and time of the flight
     */
    public Date getFlightDateAndTime() {
        Random random = new Random();

        Calendar calendar = Calendar.getInstance();

        int randomYear = calendar.get(Calendar.YEAR) + random.nextInt(2);
        int randomMonth = random.nextInt(12) + 1;
        int randomDay = random.nextInt(28) + 1;
        int randomHour = random.nextInt(24);
        int randomMinute = random.nextInt(60);

        Calendar randomCalendar = new GregorianCalendar(randomYear, randomMonth - 1, randomDay, randomHour, randomMinute);

        return randomCalendar.getTime();
    }

    /**
     * The toString method combines and formats all the information about the reservation
     * Overrides: toString in class Object
     * @return String representing the details of the reservation
     */
    @Override
    public String toString() {
        String result = "Reservation Details:" + "\n\t";

        for (int i = 0; i < airplaneTickets.size(); i++) {
            Ticket ticket = airplaneTickets.get(i);
            result += "Passenger #" + (i + 1) + "\n\t" + ticket.toString() + "\n\t";
        }

        result += "Flight Time: " + getFlightDateAndTime() + "\n\t"
                + "Departing From: " + originatingAirport.getAirportCode() + "\n\t"
                + "Arriving At: " + destinationAirport.getAirportCode() + "\n\n\t";

        if (layovers != null) {
            result += layovers + destinationAirport.getAirportCode() + "\n\t";

            int layoverHours = layovers.getTotalLayoverTime() / 60;
            int layoverMinutes = layovers.getTotalLayoverTime() % 60;

            Airport[] keys = layovers.getLayovers().keySet().toArray(new Airport[0]);

            for (int i = 0; i < layovers.getLayovers().size(); i++) {
                int singleLayoverHours = layovers.getLayoverTime(keys[i]) / 60;
                int singleLayoverMinutes = layovers.getLayoverTime(keys[i]) % 60;

                Airport[] stop = layovers.getLayovers().keySet().toArray(new Airport[0]);

                result += (i + 1) + ". " + stop[i].getAirportCode() + " (" + singleLayoverHours + " hours and " + singleLayoverMinutes + " minutes) ";
            }

            result += "\n\n\tThe layover(s) will take an additional " + layoverHours + " hour(s) and " + layoverMinutes + " minute(s)\n\n\t";
        }

        result += "Total Cost: $" + totalCost();

        return result;
    }
}