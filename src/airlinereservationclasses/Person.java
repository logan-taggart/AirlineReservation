/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airlinereservationclasses;

import java.time.LocalDate;
public class Person {
    /**
     * The private String representing the first name
     */
    private String firstName;
    /**
     * The private String representing the last name
     */
    private String lastName;
    /**
     * The private LocalDate representing the birthday
     */
    private LocalDate birthday;
    /**
     * The private int representing the number of bags being checked
     */
    private int bagsChecked;
    /**
     * The private char representing the boarding class
     */
    private char boardingClass;

    /**
     * The Person Constructor that creates a new Person object from the passed in params
     * @param firstName String Representing the first name
     * @param lastName String Representing the last name
     * @param birthday LocalDate Representing the birthday
     * @param bagsChecked int Representing the number of bags being checked
     * @param boardingClass char Representing the boarding class
     * @throws IllegalArgumentException if firstName, lastName, or birthday is null,
     * if bagsChecked is less than 0,
     * or if boardingClass is not 'A', 'B', or 'C'
     */
    public Person(String firstName, String lastName, LocalDate birthday, int bagsChecked, char boardingClass) {
        if (firstName == null || lastName == null || birthday == null) {
            throw new IllegalArgumentException("Bad param Person Constructor");
        }
        if (bagsChecked < 0) {
            throw new IllegalArgumentException("Bad param Person Constructor");
        }
        if (boardingClass != 'A' && boardingClass != 'B' && boardingClass != 'C') {
            throw new IllegalArgumentException("Bad param Person Constructor");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.bagsChecked = bagsChecked;
        this.boardingClass = boardingClass;
    }

    /**
     * The getFullName method combines the firstName and lastName
     * @return String Representing the person's full name
     */
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * The getBagsChecked method retrieves the bagsChecked field
     * @return int Representing the amount of bags the person checked
     */
    public int getBagsChecked() {
        return this.bagsChecked;
    }

    /**
     * The toString method combines and formats the personal information of the passenger.
     * Overrides: toString in class Object
     * @return String representing the personal information of passenger
     */
    @Override
    public String toString() {
        return
                "Personal Information:" + "\n\t\t"
                + this.getFullName() + "\n\t\t"
                + this.birthday + "\n\t\t"
                + this.bagsChecked + " Checked Bag(s)\n\t\t"
                + "'" + this.boardingClass + "' Boarding Class\n\t";
    }
}