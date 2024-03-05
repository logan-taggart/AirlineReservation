/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airports;

import interfaces.Airport;

public class ChicagoAirport implements Airport {
    /**
     * The private String airport representing the name of the airport
     */
    private String airport;
    /**
     * The private String location representing the location of the airport
     */
    private String location;
    /**
     * The private String code representing the specified code for the airport
     */
    private String code;

    /**
     * The ChicagoAirport Constructor that creates a new ChicagoAirport object
     */
    public ChicagoAirport() {
        this.airport = "Chicago O'Hare International Airport";
        this.location = "Chicago, IL";
        this.code = "ORD";
    }

    /**
     * Retrieves the airport field
     * Overrides: getAirport in Airport interface
     * @return String Representing the airport's name
     */
    @Override public String getAirport() {
        return this.airport;
    }

    /**
     * Retrieves the code field
     * Overrides: getAirportCode in Airport interface
     * @return String representing the airport's code
     */
    @Override public String getAirportCode() {
        return this.code;
    }
}