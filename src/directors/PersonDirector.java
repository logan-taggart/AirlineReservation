/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package directors;

import airlinereservationclasses.Person;
import builders.PersonBuilder;

import java.time.LocalDate;

public class PersonDirector {
    /**
     * The private PersonBuilder representing the personBuilder object
     */
    private PersonBuilder personBuilder;
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
     * The private int representing the number of bags checked
     */
    private int bagsChecked;
    /**
     * The private char representing the boarding class
     */
    private char boardingClass;

    /**
     * The PersonDirector Constructor that creates a new personDirector object from
     * the passed in param
     * @param personBuilder PersonBuilder Representing a personBuilder object
     * @throws IllegalArgumentException if personBuilder object is null
     */
    public PersonDirector(PersonBuilder personBuilder) {
        if (personBuilder == null) {
            throw new IllegalArgumentException("Bad param PersonDirector Constructor");
        }

        this.personBuilder = personBuilder;
    }

    /**
     * Sets the value of the first name for the director
     * @param firstName String Representing the first name
     * @throws IllegalArgumentException if firstName is null
     */
    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("Bad param setFirstName");
        }

        this.firstName = firstName;
    }

    /**
     * Sets the value of the last name for the director
     * @param lastName String Representing the last name
     * @throws IllegalArgumentException if lastName is null
     */
    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Bad param setLastName");
        }

        this.lastName = lastName;
    }

    /**
     * Sets the value of the birthday for the director
     * @param birthday LocalDate Representing the birthday
     * @throws IllegalArgumentException if birthday is null
     */
    public void setBirthday(LocalDate birthday) {
        if (birthday == null) {
            throw new IllegalArgumentException("Bad param setBirthday");
        }

        this.birthday = birthday;
    }

    /**
     * Sets the value of the bagsChecked for the director
     * @param bagsChecked int Representing the number of bags checked
     * @throws IllegalArgumentException if bagsChecked is less than 0
     */
    public void setBagsChecked(int bagsChecked) {
        if (bagsChecked < 0) {
            throw new IllegalArgumentException("Bad param setBagsChecked");
        }

        this.bagsChecked = bagsChecked;
    }

    /**
     * Sets the value of the boardingClass for the director
     * @param boardingClass char Representing the boarding class
     */
    public void setBoardingClass(char boardingClass) {
        this.boardingClass = boardingClass;
    }

    /**
     * Sets all the values of the variables necessary to create a Person instance in the personBuilder
     * then calls the getPerson() method in the personBuilder which creates a new Person
     * @return Person Representing the person object set in this file
     */
    public Person buildPerson() {
        return personBuilder.setFirstName(firstName)
                .setLastName(lastName)
                .setBirthday(birthday)
                .setBagsChecked(bagsChecked)
                .setBoardingClass(boardingClass)
                .getPerson();
        }
}