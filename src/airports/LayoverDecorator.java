/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airports;

import interfaces.Airport;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LayoverDecorator {
    /**
     * The private Airport representing the airport a flight is at
     */
    private Airport airport;
    /**
     * The private LinkedHashMap representing the information of the layovers of a flight
     */
    private LinkedHashMap<Airport, Integer> layovers;

    /**
     * The LayoverDecorator Constructor that creates a new LayoverDecorator object from the passed in param
     * @param airport Airport Representing the airport a flight is at
     */
    public LayoverDecorator(Airport airport) {
        this.airport = airport;
        this.layovers = new LinkedHashMap<>();
    }

    /**
     * The setLayoverTime method adds a new layover and its length to the LinkedHashMap
     * @param airport Airport Representing the airport that the layover is at
     * @param timeInMinutes int Representing the length of the layover in minutes
     * @throws IllegalArgumentException if airport is null or if timeInMinutes is less than 0
     */
    public void setLayoverTime(Airport airport, int timeInMinutes) {
        if (airport == null) {
            throw new IllegalArgumentException("Bad params setLayoverTime");
        }
        if (timeInMinutes < 0) {
            throw new IllegalArgumentException("Bad params setLayoverTime");
        }

        layovers.put(airport, timeInMinutes);
    }

    /**
     * The getLayoverTime method retrieves the length of a layover using the passed in Airport
     * param as the key for the LinkedHashMap
     * @param airport Airport Representing the airport that the layover is at
     * @return int Representing the time of a layover (in minutes)
     * @throws IllegalArgumentException if airport is null
     */
    public int getLayoverTime(Airport airport) {
        if (airport == null) {
            throw new IllegalArgumentException("Bad param getLayoverTime");
        }

        return layovers.get(airport);
    }

    /**
     * The getTotalLayoverTime method retrieves all of the time values from the LinkedHashMap
     * add adds them together
     * @return int Representing the total combined time of all of the flight's layovers
     */
    public int getTotalLayoverTime() {
        int totalTime = 0;

        Iterator<Integer> iterator = layovers.values().iterator();

        while (iterator.hasNext()) {
            totalTime += iterator.next();
        }

        return totalTime;
    }

    /**
     * The getLayovers method retrieves layovers field
     * @return LinkedHashMap Representing all of the layovers
     */
    public LinkedHashMap<Airport, Integer> getLayovers() {
        return this.layovers;
    }

    /**
     * The toString method combines and formats information of the layovers
     * Overrides: toString in class Object
     * @return String representing the information of the layovers
     */
    @Override public String toString() {
        Object[] keys = this.layovers.keySet().toArray();

        String result = this.airport.getAirportCode() + " --> ";

        for (int i = 0; i < keys.length; i++) {
            Airport key = (Airport) keys[i];
            result += key.getAirportCode() + " --> ";
        }

        return result;
    }
}