/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

import airlinereservationclasses.*;
import airlines.*;
import airports.*;
import builders.*;
import directors.*;
import interfaces.*;
import seatclassbenefitsbehavior.*;

import java.time.LocalDate;
import java.util.*;

/**
 * The main class of Airline Reservation
 */
public class Main {
    public static void main(String[] args) {
        PlaneSeats seats = new PlaneSeats();

        HashMap<String, Airport> airports = new HashMap<>();

        Airport chicago = new ChicagoAirport();
        Airport houston = new HoustonAirport();
        Airport phoenix = new PhoenixAirport();
        Airport portland = new PortlandAirport();
        Airport spokane = new SpokaneAirport();

        airports.put("phoenix", phoenix);
        airports.put("chicago", chicago);
        airports.put("spokane", spokane);
        airports.put("portland", portland);
        airports.put("houston", houston);

        HashMap<String, Airline> airlines = new HashMap<>();

        Airline united = new UnitedAirlines();
        Airline delta = new DeltaAirlines();
        Airline southwest = new SouthwestAirlines();

        airlines.put("united", united);
        airlines.put("delta", delta);
        airlines.put("southwest", southwest);

        HashMap<String, SeatClassCostBehavior> seatClasses = new HashMap<>();

        SeatClassCostBehavior first = new First();
        SeatClassCostBehavior comfort = new Comfort();
        SeatClassCostBehavior economy = new Economy();

        seatClasses.put("first", first);
        seatClasses.put("comfort", comfort);
        seatClasses.put("economy", economy);

        List<Ticket> tickets = new ArrayList<>();

        ReservationBuilder reservationBuilder = new ReservationBuilder();
        ReservationDirector reservationDirector = new ReservationDirector(reservationBuilder);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Where are you flying from? ");
        Airport origin = null;

        while (origin == null) {
            String start = scanner.nextLine().toLowerCase();
            origin = airports.get(start);

            if (origin == null) {
                System.out.println("Invalid airport. Please enter a valid airport: ");
            }
        }

        reservationDirector.setOriginatingAirport(origin);

        System.out.println("Where are you flying to? ");
        Airport destination = null;

        while (destination == null || destination == origin) {
            String end = scanner.nextLine().toLowerCase();
            destination = airports.get(end);

            if (destination == null || destination == origin) {
                System.out.println("Invalid airport. Please enter a valid airport: ");
            }
        }

        reservationDirector.setDestinationAirport(destination);

        System.out.println("How many layovers would you like? ");
        int numberOfLayovers = scanner.nextInt();

        while (numberOfLayovers < 0) {
            System.out.println("Invalid value. Please enter a valid number: ");
            numberOfLayovers = scanner.nextInt();
        }

        LayoverDecorator itinerary = new LayoverDecorator(origin);

        for (int i = 0; i < numberOfLayovers; i++) {
            System.out.println("Where would you like the layover to be? ");
            scanner.nextLine();
            Airport airport = null;

            while (airport == null || airport == origin || airport == destination || itinerary.getLayovers().containsKey(airport)) {
                String start = scanner.nextLine().toLowerCase();
                airport = airports.get(start);

                if (airport == null || airport == origin || airport == destination || itinerary.getLayovers().containsKey(airport)) {
                    System.out.println("Invalid airport. Please enter a valid airport: ");
                }
            }

            System.out.println("How long will the layover be? ");
            int time = scanner.nextInt();

            while (time <= 0) {
                System.out.println("Invalid value. Please enter a valid number: ");
                time = scanner.nextInt();
            }

            itinerary.setLayoverTime(airport, time);
            reservationDirector.setLayovers(itinerary);
        }

        System.out.println("How many tickets will be part of your reservation? ");
        int emptyTickets = scanner.nextInt();

        while (emptyTickets <= 0) {
            System.out.println("Invalid value. Please enter a valid number: ");
            emptyTickets = scanner.nextInt();
        }

        while (emptyTickets > 0) {
            PersonBuilder personBuilder = new PersonBuilder();
            PersonDirector personDirector = new PersonDirector(personBuilder);

            TicketBuilder ticketBuilder = new TicketBuilder();
            TicketDirector ticketDirector = new TicketDirector(ticketBuilder);

            SeatBuilder seatBuilder = new SeatBuilder();
            SeatDirector seatDirector = new SeatDirector(seatBuilder);

            boolean optionOneComplete = false;
            boolean optionTwoComplete = false;
            boolean optionThreeComplete = false;
            boolean optionFourComplete = false;
            boolean optionFiveComplete = false;
            boolean optionSixComplete = false;

            int choice;

            do {
                System.out.println("1) Enter your name" + (optionOneComplete ? " (Complete)" : ""));
                System.out.println("2) Enter your birthday" + (optionTwoComplete ? " (Complete)" : ""));
                System.out.println("3) Enter the number of bags that you are checking" + (optionThreeComplete ? " (Complete)" : ""));
                System.out.println("4) Enter the airline" + (optionFourComplete ? " (Complete)" : ""));
                System.out.println("5) Enter your boarding class" + (optionFiveComplete ? " (Complete)" : ""));
                System.out.println("6) Enter your seat class" + (optionSixComplete ? " (Complete)" : ""));
                System.out.println("7) -- ADD TICKET TO RESERVATION --");

                System.out.println("Make your choice:");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("What is your first name? ");
                        scanner.nextLine();
                        String firstName = scanner.nextLine();
                        personDirector.setFirstName(firstName);

                        System.out.println("What is your last name? ");
                        String lastName = scanner.nextLine();
                        personDirector.setLastName(lastName);

                        optionOneComplete = true;
                        break;

                    case 2:
                        System.out.println("What month number were you born? ");
                        int month = scanner.nextInt();

                        while (month <= 0 || month > 12) {
                            System.out.println("Invalid value. Please enter a valid number: ");
                            month = scanner.nextInt();
                        }

                        System.out.println("What day were you born? ");
                        int day = scanner.nextInt();

                        while (day < 1 || day > 31) {
                            System.out.println("Invalid value. Please enter a valid number: ");
                            day = scanner.nextInt();
                        }

                        System.out.println("What year were you born? ");
                        int year = scanner.nextInt();

                        while (year < 1900 || year > 2100) {
                            System.out.println("Invalid value. Please enter a valid number: ");
                            year = scanner.nextInt();
                        }

                        personDirector.setBirthday(LocalDate.of(year, month, day));

                        optionTwoComplete = true;
                        break;

                    case 3:
                        System.out.println("How many bags will you be checking? ");
                        int bags = scanner.nextInt();

                        while (bags < 0) {
                            System.out.println("Invalid value. Please enter a valid number: ");
                            bags = scanner.nextInt();
                        }

                        personDirector.setBagsChecked(bags);

                        optionThreeComplete = true;
                        break;

                    case 4:
                        System.out.println("What airline are you flying with? ");
                        Airline airline = null;

                        scanner.nextLine();

                        while (airline == null) {
                            String company = scanner.nextLine().toLowerCase();
                            airline = airlines.get(company);

                            if (airline == null) {
                                System.out.println("Invalid airline. Please enter a valid airline: ");
                            }
                        }

                        seatDirector.setAirline(airline);

                        optionFourComplete = true;
                        break;

                    case 5:
                        System.out.println("What boarding class are you in? (A, B, or C) ");
                        char boardingClass = scanner.next().toUpperCase().charAt(0);

                        while (boardingClass != 'A' && boardingClass != 'B' && boardingClass != 'C') {
                            System.out.println("Invalid class. Please enter a valid class: ");
                            boardingClass = scanner.next().toUpperCase().charAt(0);
                        }

                        personDirector.setBoardingClass(boardingClass);

                        optionFiveComplete = true;
                        break;

                    case 6:
                        System.out.println("What class of seat would you like? (Economy, Comfort, or First)");
                        SeatClassCostBehavior seatClass = null;

                        scanner.nextLine();

                        while (seatClass == null) {
                            String tier = scanner.nextLine().toLowerCase();
                            seatClass = seatClasses.get(tier);

                            if (seatClass == null) {
                                System.out.println("Invalid class. Please enter a valid class: ");
                            }
                        }

                        seatDirector.setSeatClass(seatClass);

                        String seat = seats.selectOpenSeat(seats.getPlaneSeats(), seatClass);

                        seatDirector.setSeat(seat);

                        optionSixComplete = true;
                        break;

                    case 7:
                        System.out.println("Ticket Submitted!\n");

                        Person newPerson = personDirector.buildPerson();
                        Seat newSeat = seatDirector.buildSeat();

                        ticketDirector.setPassenger(newPerson);
                        ticketDirector.setSeat(newSeat);

                        Ticket newTicket = ticketDirector.buildTicket();

                        tickets.add(newTicket);

                        emptyTickets--;
                        break;

                    default:
                        System.out.println("Invalid Selection!");
                        break;
                }

            } while (choice != 7);
        }

        scanner.close();

        reservationDirector.setAirplaneTickets(tickets);

        Reservation newReservation = reservationDirector.buildReservation();

        System.out.println(newReservation.toString());
    }
}