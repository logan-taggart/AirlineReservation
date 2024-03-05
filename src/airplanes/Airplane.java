/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airplanes;

public abstract class Airplane {
    /**
     * The private String representing the name of the airplane
     */
    private String name;
    /**
     * The private int Representing the amount of rows in first class on the specific plane
     */
    private int amountOfRowsFirstClass;
    /**
     * The private int Representing the amount of rows in comfort class on the specific plane
     */
    private int amountOfRowsComfortClass;
    /**
     * The private int Representing the amount of rows in economy class on the specific plane
     */
    private int amountOfRowsEconomyClass;
    /**
     * The private int Representing the number of seats in a row in first class
     */
    private int seatsInRowFirstClass;
    /**
     * The private int Representing the number of seats in a row in comfort class
     */
    private int seatsInRowComfortClass;
    /**
     * The private int Representing the number of seats in a row in economy class
     */
    private int seatsInRowEconomyClass;

    /**
     * The Airplane Constructor that creates a new Airplane object with the passed in params
     * @param name String Representing the name of the airplane
     * @param amountOfRowsFirstClass int Representing the number of rows in first class
     * @param amountOfRowsComfortClass int Representing the number of rows in comfort class
     * @param amountOfRowsEconomyClass int Representing the number of rows in economy class
     * @param seatsInRowFirstClass int Representing the number of seats in a row in first class
     * @param seatsInRowComfortClass int Representing the number of seats in a row in comfort class
     * @param seatsInRowEconomyClass int Representing the number of seats in a row in economy class
     * @throws IllegalArgumentException if name is null,
     * if amountOfRowsFirstClass, amountOfRowsComfortClass, or amountOfRowsEconomyClass is less than 0,
     * or if seatsInRowFirstClass, seatsInRowComfortClass, or seatsInRowEconomyClass is less than 0
     */
    public Airplane(String name, int amountOfRowsFirstClass, int amountOfRowsComfortClass, int amountOfRowsEconomyClass,
                    int seatsInRowFirstClass, int seatsInRowComfortClass, int seatsInRowEconomyClass) {
        if (name == null) {
            throw new IllegalArgumentException("Bad param Airplane Constructor");
        }
        if (amountOfRowsFirstClass < 0 || amountOfRowsComfortClass < 0 || amountOfRowsEconomyClass < 0) {
            throw new IllegalArgumentException("Bad param Airplane Constructor");
        }
        if (seatsInRowFirstClass < 0 || seatsInRowComfortClass < 0 || seatsInRowEconomyClass < 0) {
            throw new IllegalArgumentException("Bad param Airplane Constructor");
        }

        this.name = name;
        this.amountOfRowsFirstClass = amountOfRowsFirstClass;
        this.amountOfRowsComfortClass = amountOfRowsComfortClass;
        this.amountOfRowsEconomyClass = amountOfRowsEconomyClass;
        this.seatsInRowFirstClass = seatsInRowFirstClass;
        this.seatsInRowComfortClass = seatsInRowComfortClass;
        this.seatsInRowEconomyClass = seatsInRowEconomyClass;
    }

    /**
     * The getAmountOfRowsFirstClass method retrieves the amountOfRowsFirstClass field
     * @return int Representing the amount of rows in first class
     */
    public int getAmountOfRowsFirstClass() {
        return amountOfRowsFirstClass;
    }

    /**
     * The getAmountOfRowsComfortClass method retrieves the amountOfRowsComfortClass field
     * @return int Representing the amount of rows in comfort class
     */
    public int getAmountOfRowsComfortClass() {
        return amountOfRowsComfortClass;
    }

    /**
     * The getAmountOfRowsEconomyClass method retrieves the amountOfRowsEconomyClass field
     * @return int Representing the amount of rows in economy class
     */
    public int getAmountOfRowsEconomyClass() {
        return amountOfRowsEconomyClass;
    }

    /**
     * The getSeatsInRowFirstClass method retrieves the seatsInRowFirstClass field
     * @return int Representing the number of seats in a first class row
     */
    public int getSeatsInRowFirstClass() {
        return seatsInRowFirstClass;
    }

    /**
     * The getSeatsInRowComfortClass method retrieves the seatsInRowComfortClass field
     * @return int Representing the number of seats in a comfort class row
     */
    public int getSeatsInRowComfortClass() {
        return seatsInRowComfortClass;
    }

    /**
     * The getSeatsInRowEconomyClass method retrieves the seatsInRowEconomyClass field
     * @return int Representing the number of seats in an economy class row
     */
    public int getSeatsInRowEconomyClass() {
        return seatsInRowEconomyClass;
    }
}