/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airlines;

public abstract class Airline {
    /**
     * The private String representing the name of the airline
     */
    private String name;

    /**
     * The Airline Constructor that creates a new Airline from the passed in param
     * @param name String representing name of the airline
     * @throws IllegalArgumentException if name is null
     */
    public Airline(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Bad param Airline Constructor");
        }

        this.name = name;
    }

    /**
     * The toString method combines and formats information of the airline
     * Overrides: toString in class Object
     * @return String representing the information of the airline
     */
    @Override public String toString() {
        return this.name;
    }
}