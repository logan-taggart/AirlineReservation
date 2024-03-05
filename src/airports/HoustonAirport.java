/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airports;

import interfaces.Airport;

public class HoustonAirport implements Airport {
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
     * The HoustonAirport Constructor that creates a new HoustonAirport object
     */
    public HoustonAirport() {
        this.airport = "George Bush Intercontinental Airport";
        this.location = "Houston, TX";
        this.code = "IAH";
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