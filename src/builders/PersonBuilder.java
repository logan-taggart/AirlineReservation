/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package builders;

import airlinereservationclasses.Person;

import java.time.LocalDate;

public class PersonBuilder {
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
     * The Constructor for the PersonBuilder
     */
    public PersonBuilder() {}

    /**
     * Sets the value of firstName for the builder
     * @param firstName String Representing the first name
     * @return PersonBuilder Representing the PersonBuilder object
     * @throws IllegalArgumentException if firstName is null
     */
    public PersonBuilder setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("Bad param setFirstName");
        }

        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the value of lastName for the builder
     * @param lastName String Representing the last name
     * @return PersonBuilder Representing the PersonBuilder object
     * @throws IllegalArgumentException if lastName is null
     */
    public PersonBuilder setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Bad param setLastName");
        }

        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the value of birthday for the builder
     * @param birthday LocalDate Representing the birthday
     * @return PersonBuilder Representing the PersonBuilder object
     * @throws IllegalArgumentException if birthday is null
     */
    public PersonBuilder setBirthday(LocalDate birthday) {
        if (birthday == null) {
            throw new IllegalArgumentException("Bad param birthday");
        }

        this.birthday = birthday;
        return this;
    }

    /**
     * Sets the value of bagsChecked for the builder
     * @param bagsChecked int Representing the number of bags being checked
     * @return PersonBuilder Representing the PersonBuilder object
     * @throws IllegalArgumentException if bagsChecked is less than 0
     */
    public PersonBuilder setBagsChecked(int bagsChecked) {
        if (bagsChecked < 0) {
            throw new IllegalArgumentException("Bad param bagsChecked");
        }

        this.bagsChecked = bagsChecked;
        return this;
    }

    /**
     * Sets the value of boarding class for the builder
     * @param boardingClass char Representing the boarding class
     * @return PersonBuilder Representing the PersonBuilder object
     */
    public PersonBuilder setBoardingClass(char boardingClass) {
        this.boardingClass = boardingClass;
        return this;
    }

    /**
     * Calls the person constructor with instance fields to create a new Person object
     * @return Person Representing the new Person object
     */
    public Person getPerson() {
        return new Person(firstName, lastName, birthday, bagsChecked, boardingClass);
    }
}