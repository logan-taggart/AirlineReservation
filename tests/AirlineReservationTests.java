/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

import static org.junit.jupiter.api.Assertions.*;

import builders.PersonBuilder;
import builders.ReservationBuilder;
import builders.SeatBuilder;
import builders.TicketBuilder;
import directors.PersonDirector;
import directors.ReservationDirector;
import directors.SeatDirector;
import directors.TicketDirector;
import interfaces.SeatClassCostBehavior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import airlinereservationclasses.*;
import airlines.*;
import airplanes.*;
import airports.*;
import seatclassbenefitsbehavior.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AirlineReservationTests {
    private Person newPerson;
    private Seat newSeat;
    private Ticket newTicket;
    private PlaneSeats newSeats;
    private Reservation newReservation;
    private DeltaAirlines newDelta;
    private SouthwestAirlines newSouthwest;
    private UnitedAirlines newUnited;
    private AirbusA320 newAirbus;
    private Boeing737 newBoeing;
    private GulfstreamG200 newGulfstream;
    private SeatClassCostBehavior newFirst;
    private SeatClassCostBehavior newComfort;
    private SeatClassCostBehavior newEconomy;
    private ChicagoAirport newChicago;
    private HoustonAirport newHouston;
    private PhoenixAirport newPhoenix;
    private PortlandAirport newPortland;
    private SpokaneAirport newSpokane;
    private LayoverDecorator newLayover;
    private List<Ticket> newTicketList = new ArrayList<>();

    private ReservationBuilder reservationBuilder;
    private ReservationDirector reservationDirector;
    private PersonBuilder personBuilder;
    private PersonDirector personDirector;
    private TicketBuilder ticketBuilder;
    private TicketDirector ticketDirector;
    private SeatBuilder seatBuilder;
    private SeatDirector seatDirector;

    @BeforeEach
    public void initializeFields() {
        newDelta = new DeltaAirlines();
        newSouthwest = new SouthwestAirlines();
        newUnited = new UnitedAirlines();

        newAirbus = new AirbusA320();
        newBoeing = new Boeing737();
        newGulfstream = new GulfstreamG200();

        newFirst = new First();
        newComfort = new Comfort();
        newEconomy = new Economy();

        newChicago = new ChicagoAirport();
        newHouston = new HoustonAirport();
        newPhoenix = new PhoenixAirport();
        newPortland = new PortlandAirport();
        newSpokane = new SpokaneAirport();

        newLayover = new LayoverDecorator(newChicago);

        newTicketList.add(newTicket);

        newPerson = new Person("John", "Doe", LocalDate.of(2017, 3, 3), 3, 'A');
        newSeat = new Seat(newDelta, newComfort, "12C");
        newTicket = new Ticket(newPerson, newSeat);
        newSeats = new PlaneSeats();
        newReservation = new Reservation(newTicketList, newChicago, newSpokane, null);

        reservationBuilder = new ReservationBuilder();
        reservationDirector = new ReservationDirector(reservationBuilder);

        personBuilder = new PersonBuilder();
        personDirector = new PersonDirector(personBuilder);

        ticketBuilder = new TicketBuilder();
        ticketDirector = new TicketDirector(ticketBuilder);

        seatBuilder = new SeatBuilder();
        seatDirector = new SeatDirector(seatBuilder);
    }

    @Nested
    @DisplayName("Class Tests")
    public class ClassTests {
        @Test
        @DisplayName("Person successfully constructs")
        public void personConstructs() {
            assertTrue(newPerson instanceof Person);
        }

        @Test
        @DisplayName("Person fails at constructing (firstName null)")
        public void personFirstNameNullConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Person(
                                null,
                                "Doe",
                                LocalDate.of(2017, 3, 3),
                                3,
                                'A');
                    });
            assertEquals("Bad param Person Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Person fails at constructing (lastName null)")
        public void personLastNameNullConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Person(
                                "John",
                                null,
                                LocalDate.of(2017, 3, 3),
                                3,
                                'A');
                    });
            assertEquals("Bad param Person Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Person fails at constructing (birthday null)")
        public void personBirthdayNullConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Person(
                                "John",
                                "Doe",
                                null,
                                3,
                                'A');
                    });
            assertEquals("Bad param Person Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Person fails at constructing (bagsChecked < 0)")
        public void personNegativeBagsCheckedConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Person(
                                "John",
                                "Doe",
                                LocalDate.of(2017, 3, 3),
                                -1,
                                'A');
                    });
            assertEquals("Bad param Person Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Person fails at constructing (improper boarding class)")
        public void personImproperBoardingClassConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Person(
                                "John",
                                "Doe",
                                null,
                                3,
                                'Z');
                    });
            assertEquals("Bad param Person Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Person getFullName works")
        public void getFullNameWorks() {
            assertEquals("John Doe", newPerson.getFullName());
        }

        @Test
        @DisplayName("Person getBagsChecked works")
        public void getBagsCheckedWorks() {
            assertEquals(3, newPerson.getBagsChecked());
        }

        @Test
        @DisplayName("Seat successfully constructs")
        public void seatConstructs() {
           assertTrue(newSeat instanceof Seat);
        }

        @Test
        @DisplayName("Seat fails at constructing (name null)")
        public void seatNameNullConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Seat(
                                null,
                                newComfort,
                                "11B");
                    });
            assertEquals("Bad param Seat Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Seat fails at constructing (seat class null)")
        public void seatClassNullConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Seat(newDelta,
                                null,
                                "11B");
                    });
            assertEquals("Bad param Seat Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Seat fails at constructing (seat null)")
        public void seatNullConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Seat(newDelta,
                                newFirst,
                                null);
                    });
            assertEquals("Bad param Seat Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Seat getSeatClass works")
        public void getSeatClassWorks() {
            assertEquals(newComfort, newSeat.getSeatClass());
        }

        @Test
        @DisplayName("Ticket successfully constructs")
        public void ticketConstructs() {
            assertTrue(newTicket instanceof Ticket);
        }

        @Test
        @DisplayName("Ticket fails at constructing (person null)")
        public void ticketPersonNullConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Ticket(null,
                                    newSeat);
                    });
            assertEquals("Bad param Ticket Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Ticket fails at constructing (seat null)")
        public void ticketSeatNullConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Ticket(newPerson,
                                null);
                    });
            assertEquals("Bad param Ticket Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("PlaneSeats successfully construct")
        public void planeSeatsConstruct() {
            assertTrue(newSeats instanceof PlaneSeats);
        }

        @Test
        @DisplayName("Reservation successfully constructs")
        public void reservationConstructs() {
            assertTrue(newReservation instanceof Reservation);
        }

        @Test
        @DisplayName("Reservation fails at constructing (airplaneTickets null)")
        public void reservationTicketsNullConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Reservation(null,
                                        newChicago,
                                        newHouston,
                                        newLayover);
                    });
            assertEquals("Bad param Reservation Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Reservation fails at constructing (originatingAirport null)")
        public void reservationStartingAirportNullConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Reservation(newTicketList,
                                null,
                                newHouston,
                                newLayover);
                    });
            assertEquals("Bad param Reservation Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Reservation fails at constructing (destinationAirport null)")
        public void reservationEndingAirportNullConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Reservation(newTicketList,
                                newChicago,
                                null,
                                newLayover);
                    });
            assertEquals("Bad param Reservation Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("Reservation getFlightDateAndTime works")
        public void reservationGetFlightDateAndTimeWorks() {
            assertTrue(newReservation.getFlightDateAndTime() instanceof Date);
        }
    }

    @Nested
    @DisplayName("Airline Tests")
    public class AirlineTests {
        @Test
        @DisplayName("Delta successfully constructs")
        public void deltaConstructs() {
            assertTrue(newDelta instanceof DeltaAirlines);
        }

        @Test
        @DisplayName("Delta toString works")
        public void deltaToStringWorks() {
            assertEquals("Delta Airlines", newDelta.toString());
        }

        @Test
        @DisplayName("Southwest successfully constructs")
        public void southwestConstructs() {
            assertTrue(newSouthwest instanceof SouthwestAirlines);
        }

        @Test
        @DisplayName("Southwest toString works")
        public void southwestToStringWorks() {
            assertEquals("Southwest Airlines", newSouthwest.toString());
        }

        @Test
        @DisplayName("United successfully constructs")
        public void unitedConstructs() {
            assertTrue(newUnited instanceof UnitedAirlines);
        }

        @Test
        @DisplayName("United toString works")
        public void unitedToStringWorks() {
            assertEquals("United Airlines", newUnited.toString());
        }
    }

    @Nested
    @DisplayName("Airplane Tests")
    public class AirplaneTests {
        @Test
        @DisplayName("Airbus successfully constructs")
        public void airbusConstructs() {
            assertTrue(newAirbus instanceof AirbusA320);
        }

        @Test
        @DisplayName("Boeing successfully constructs")
        public void boeingConstructs() {
            assertTrue(newBoeing instanceof Boeing737);
        }

        @Test
        @DisplayName("Gulfstream successfully constructs")
        public void gulfstreamConstructs() {
            assertTrue(newGulfstream instanceof GulfstreamG200);
        }
    }

    @Nested
    @DisplayName("Airport Tests")
    public class AirportTests {
        @Test
        @DisplayName("LayoverDecorator successfully constructs")
        public void layoverDecoratorConstructs() {
            assertTrue(newLayover instanceof LayoverDecorator);
        }

        @Test
        @DisplayName("LayoverDecorator setLayover fails (airport null)")
        public void layoverDecoratorAirportNullSetLayoverFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        newLayover.setLayoverTime(null, 50);
                    });
            assertEquals("Bad params setLayoverTime", exception.getMessage());
        }

        @Test
        @DisplayName("LayoverDecorator setLayover fails (negative time)")
        public void layoverDecoratorNegativeTimeSetLayoverFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        newLayover.setLayoverTime(null, 50);
                    });
            assertEquals("Bad params setLayoverTime", exception.getMessage());
        }

        @Test
        @DisplayName("LayoverDecorator setLayoverTime and getLayoverTime works")
        public void layoverDecoratorSetAndGetTimeWorks() {
            newLayover.setLayoverTime(newHouston, 45);
            assertEquals(45, newLayover.getLayoverTime(newHouston));
        }

        @Test
        @DisplayName("LayoverDecorator setLayover fails (negative time)")
        public void layoverDecoratorGetLayoverAirportNullFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        newLayover.getLayoverTime(null);
                    });
            assertEquals("Bad param getLayoverTime", exception.getMessage());
        }

        @Test
        @DisplayName("LayoverDecorator getTotalLayoverTime works")
        public void totalLayoverTimeWorks() {
            newLayover.setLayoverTime(newPhoenix, 55);
            newLayover.setLayoverTime(newSpokane, 15);

            assertEquals(70, newLayover.getTotalLayoverTime());
        }

        @Test
        @DisplayName("Chicago successfully constructs")
        public void chicagoConstructs() {
            assertTrue(newChicago instanceof ChicagoAirport);
        }

        @Test
        @DisplayName("Chicago getAirport works")
        public void chicagoGetAirportWorks() {
            assertEquals("Chicago O'Hare International Airport", newChicago.getAirport());
        }

        @Test
        @DisplayName("Chicago getAirportCode works")
        public void chicagoGetAirportCodeWorks() {
            assertEquals("ORD", newChicago.getAirportCode());
        }

        @Test
        @DisplayName("Houston successfully constructs")
        public void houstonConstructs() {
            assertTrue(newHouston instanceof HoustonAirport);
        }

        @Test
        @DisplayName("Houston getAirport works")
        public void houstonGetAirportWorks() {
            assertEquals("George Bush Intercontinental Airport", newHouston.getAirport());
        }

        @Test
        @DisplayName("Houston getAirportCode works")
        public void houstonGetAirportCodeWorks() {
            assertEquals("IAH", newHouston.getAirportCode());
        }
        @Test
        @DisplayName("Phoenix successfully constructs")
        public void phoenixConstructs() {
            assertTrue(newPhoenix instanceof PhoenixAirport);
        }

        @Test
        @DisplayName("Phoenix getAirport works")
        public void phoenixGetAirportWorks() {
            assertEquals("Phoenix Sky Harbor International Airport", newPhoenix.getAirport());
        }

        @Test
        @DisplayName("Phoenix getAirportCode works")
        public void phoenixGetAirportCodeWorks() {
            assertEquals("PHX", newPhoenix.getAirportCode());
        }

        @Test
        @DisplayName("Portland successfully constructs")
        public void portlandConstructs() {
            assertTrue(newPortland instanceof PortlandAirport);
        }

        @Test
        @DisplayName("Portland getAirport works")
        public void portlandGetAirportWorks() {
            assertEquals("Portland International Airport", newPortland.getAirport());
        }

        @Test
        @DisplayName("Portland getAirportCode works")
        public void portlandGetAirportCodeWorks() {
            assertEquals("PDX", newPortland.getAirportCode());
        }

        @Test
        @DisplayName("Spokane successfully constructs")
        public void spokaneConstructs() {
            assertTrue(newSpokane instanceof SpokaneAirport);
        }

        @Test
        @DisplayName("Spokane getAirport works")
        public void spokaneGetAirportWorks() {
            assertEquals("Spokane International Airport", newSpokane.getAirport());
        }

        @Test
        @DisplayName("Spokane getAirportCode works")
        public void spokaneGetAirportCodeWorks() {
            assertEquals("GEG", newSpokane.getAirportCode());
        }
    }

    @Nested
    @DisplayName("Seat Class Tests")
    public class SeatClassTests {
        @Test
        @DisplayName("First successfully constructs")
        public void firstConstructs() {
            assertTrue(newFirst instanceof First);
        }

        @Test
        @DisplayName("First calculates cost correctly")
        public void firstCalculateCostWorks() {
            int cost = newFirst.calculateCost(100, 3);
            assertEquals(225, cost);
        }

        @Test
        @DisplayName("First calculates cost correctly w/ 2 free bags")
        public void firstCalculateCostFreeBagsWorks() {
            int cost = newFirst.calculateCost(125, 2);
            assertEquals(250, cost);
        }

        @Test
        @DisplayName("First calculateCost fails (negative base cost)")
        public void firstNegativeBaseCalculateCostFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        newFirst.calculateCost(-5, 3);
                    });
            assertEquals("Bad params calculateCost", exception.getMessage());
        }

        @Test
        @DisplayName("First calculateCost fails (negative bags)")
        public void firstNegativeBagsCalculateCostFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        newFirst.calculateCost(100, -3);
                    });
            assertEquals("Bad params calculateCost", exception.getMessage());
        }

        @Test
        @DisplayName("Comfort successfully constructs")
        public void comfortConstructs() {
            assertTrue(newComfort instanceof Comfort);
        }

        @Test
        @DisplayName("Comfort calculates cost correctly")
        public void comfortCalculateCostWorks() {
            int cost = newComfort.calculateCost(200, 2);
            assertEquals(325, cost);
        }

        @Test
        @DisplayName("Comfort calculates cost correctly w/ 1 free bag")
        public void comfortCalculateCostFreeBagWorks() {
            int cost = newComfort.calculateCost(140, 1);
            assertEquals(210, cost);
        }

        @Test
        @DisplayName("Comfort calculateCost fails (negative base cost)")
        public void comfortNegativeBaseCalculateCostFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        newComfort.calculateCost(-5, 3);
                    });
            assertEquals("Bad params calculateCost", exception.getMessage());
        }

        @Test
        @DisplayName("Comfort calculateCost fails (negative bags)")
        public void comfortNegativeBagsCalculateCostFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        newComfort.calculateCost(100, -3);
                    });
            assertEquals("Bad params calculateCost", exception.getMessage());
        }

        @Test
        @DisplayName("Economy successfully constructs")
        public void economyConstructs() {
            assertTrue(newEconomy instanceof Economy);
        }

        @Test
        @DisplayName("Economy calculates cost correctly")
        public void economyCalculateCostWorks() {
            int cost = newEconomy.calculateCost(140, 1);
            assertEquals(165, cost);
        }

        @Test
        @DisplayName("Economy calculateCost fails (negative base cost)")
        public void economyNegativeBaseCalculateCostFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        newEconomy.calculateCost(-5, 3);
                    });
            assertEquals("Bad params calculateCost", exception.getMessage());
        }

        @Test
        @DisplayName("Economy calculateCost fails (negative bags)")
        public void economyNegativeBagsCalculateCostFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        newEconomy.calculateCost(100, -3);
                    });
            assertEquals("Bad params calculateCost", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Director Tests")
    public class DirectorTests {
        @Test
        @DisplayName("PersonDirector successfully constructs")
        public void personDirectorConstructs() {
            assertTrue(personDirector instanceof PersonDirector);
        }

        @Test
        @DisplayName("PersonDirector construct fails (PersonBuilder null)")
        public void personDirectorNullBuilderFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new PersonDirector(null);
                    });
            assertEquals("Bad param PersonDirector Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("PersonDirector setFirstName fails (firstName null)")
        public void personDirectorSetFirstNameFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        personDirector.setFirstName(null);
                    });
            assertEquals("Bad param setFirstName", exception.getMessage());
        }

        @Test
        @DisplayName("PersonDirector setLastName fails (lastName null)")
        public void personDirectorSetLastNameFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        personDirector.setLastName(null);
                    });
            assertEquals("Bad param setLastName", exception.getMessage());
        }

        @Test
        @DisplayName("PersonDirector setBirthday fails (birthday null)")
        public void personDirectorSetBirthdayFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        personDirector.setBirthday(null);
                    });
            assertEquals("Bad param setBirthday", exception.getMessage());
        }

        @Test
        @DisplayName("PersonDirector setCheckedBags fails (checkedBags null)")
        public void personDirectorSetBagsFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        personDirector.setBagsChecked(-2);
                    });
            assertEquals("Bad param setBagsChecked", exception.getMessage());
        }

        @Test
        @DisplayName("ReservationDirector successfully constructs")
        public void reservationDirectorConstructs() {
            assertTrue(reservationDirector instanceof ReservationDirector);
        }

        @Test
        @DisplayName("ReservationDirector construct fails (ReservationBuilder null)")
        public void reservationDirectorNullBuilderFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new ReservationDirector(null);
                    });
            assertEquals("Bad param ReservationDirector Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("ReservationDirector setAirplaneTickets fails (tickets null)")
        public void reservationDirectorSetAirplaneTicketsFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        reservationDirector.setAirplaneTickets(null);
                    });
            assertEquals("Bad param setAirplaneTickets", exception.getMessage());
        }

        @Test
        @DisplayName("ReservationDirector setOrigin fails (airport null)")
        public void reservationDirectorSetOriginFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        reservationDirector.setOriginatingAirport(null);
                    });
            assertEquals("Bad param setOriginating", exception.getMessage());
        }

        @Test
        @DisplayName("ReservationDirector setDestination fails (airport null)")
        public void reservationDirectorSetDestinationFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        reservationDirector.setDestinationAirport(null);
                    });
            assertEquals("Bad param setDestination", exception.getMessage());
        }

        @Test
        @DisplayName("SeatDirector successfully constructs")
        public void seatDirectorConstructs() {
            assertTrue(seatDirector instanceof SeatDirector);
        }

        @Test
        @DisplayName("SeatDirector constructor fails (seatBuilder null)")
        public void seatDirectorConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new SeatDirector(null);
                    });
            assertEquals("Bad param SeatDirector Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("SeatDirector setAirline fails (airport null)")
        public void seatDirectorSetAirlineFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        seatDirector.setAirline(null);
                    });
            assertEquals("Bad param setAirline", exception.getMessage());
        }

        @Test
        @DisplayName("SeatDirector setSeatClass fails (seatClass null)")
        public void seatDirectorSetSeatClassFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        seatDirector.setSeatClass(null);
                    });
            assertEquals("Bad param setSeatClass", exception.getMessage());
        }

        @Test
        @DisplayName("SeatDirector setSeat fails (seat null)")
        public void seatDirectorSetSeatFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        seatDirector.setSeat(null);
                    });
            assertEquals("Bad param setSeat", exception.getMessage());
        }

        @Test
        @DisplayName("TicketDirector successfully constructs")
        public void ticketDirectorConstructs() {
            assertTrue(ticketDirector instanceof TicketDirector);
        }

        @Test
        @DisplayName("TicketDirector constructor fails (ticketBuilder null)")
        public void ticketDirectorConstructorFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        new TicketDirector(null);
                    });
            assertEquals("Bad param TicketDirector Constructor", exception.getMessage());
        }

        @Test
        @DisplayName("TicketDirector setPassenger fails (passenger null)")
        public void ticketDirectorSetPassengerFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        ticketDirector.setPassenger(null);
                    });
            assertEquals("Bad param setPassenger", exception.getMessage());
        }

        @Test
        @DisplayName("TicketDirector setSeat fails (seat null)")
        public void ticketDirectorSetSeatFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        ticketDirector.setSeat(null);
                    });
            assertEquals("Bad param setSeat", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Builder Tests")
    public class BuilderTests {
        @Test
        @DisplayName("PersonBuilder successfully constructs")
        public void personBuilderConstructs() {
            assertTrue(personBuilder instanceof PersonBuilder);
        }

        @Test
        @DisplayName("PersonBuilder setFirstName fails (firstName null)")
        public void personBuilderSetFirstNameFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        personBuilder.setFirstName(null);
                    });
            assertEquals("Bad param setFirstName", exception.getMessage());
        }

        @Test
        @DisplayName("PersonBuilder setLastName fails (lastName null)")
        public void personBuilderSetLastNameFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        personBuilder.setLastName(null);
                    });
            assertEquals("Bad param setLastName", exception.getMessage());
        }

        @Test
        @DisplayName("PersonBuilder setBirthday fails (birthday null)")
        public void personBuilderSetBirthdayFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        personBuilder.setBirthday(null);
                    });
            assertEquals("Bad param birthday", exception.getMessage());
        }

        @Test
        @DisplayName("PersonBuilder setCheckedBags fails (bagsChecked null)")
        public void personBuilderSetBagsFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        personBuilder.setBagsChecked(-2);
                    });
            assertEquals("Bad param bagsChecked", exception.getMessage());
        }

        @Test
        @DisplayName("ReservationBuilder successfully constructs")
        public void reservationBuilderConstructs() {
            assertTrue(reservationBuilder instanceof ReservationBuilder);
        }

        @Test
        @DisplayName("ReservationBuilder setAirplaneTickets fails (tickets null)")
        public void reservationBuilderSetAirplaneTicketsFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        reservationBuilder.setAirplaneTickets(null);
                    });
            assertEquals("Bad param setAirplaneTickets", exception.getMessage());
        }

        @Test
        @DisplayName("ReservationBuilder setOrigin fails (airport null)")
        public void reservationBuilderSetOriginFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        reservationBuilder.setOriginatingAirport(null);
                    });
            assertEquals("Bad param setOriginatingAirport", exception.getMessage());
        }

        @Test
        @DisplayName("ReservationBuilder setDestination fails (airport null)")
        public void reservationBuilderSetDestinationFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        reservationBuilder.setDestinationAirport(null);
                    });
            assertEquals("Bad param destinationAirport", exception.getMessage());
        }

        @Test
        @DisplayName("SeatBuilder successfully constructs")
        public void seatBuilderConstructs() {
            assertTrue(seatBuilder instanceof SeatBuilder);
        }

        @Test
        @DisplayName("SeatBuilder setAirline fails (airport null)")
        public void seatBuilderSetAirlineFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        seatBuilder.setAirline(null);
                    });
            assertEquals("Bad param setAirline", exception.getMessage());
        }

        @Test
        @DisplayName("SeatBuilder setSeatClass fails (seatClass null)")
        public void seatBuilderSetSeatClassFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        seatBuilder.setSeatClass(null);
                    });
            assertEquals("Bad param setSeatClass", exception.getMessage());
        }

        @Test
        @DisplayName("SeatBuilder setSeat fails (seat null)")
        public void seatBuilderSetSeatFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        seatBuilder.setSeat(null);
                    });
            assertEquals("Bad param setSeat", exception.getMessage());
        }

        @Test
        @DisplayName("TicketBuilder successfully constructs")
        public void ticketBuilderConstructs() {
            assertTrue(ticketBuilder instanceof TicketBuilder);
        }

        @Test
        @DisplayName("TicketBuilder setPassenger fails (passenger null)")
        public void ticketBuilderSetPassengerFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        ticketBuilder.setPassenger(null);
                    });
            assertEquals("Bad param setPassenger", exception.getMessage());
        }

        @Test
        @DisplayName("TicketBuilder setSeat fails (seat null)")
        public void ticketBuilderSetSeatFails() {
            Throwable exception =
                    assertThrows(IllegalArgumentException.class, () -> {
                        ticketBuilder.setSeat(null);
                    });
            assertEquals("Bad param setSeat", exception.getMessage());
        }
    }
}