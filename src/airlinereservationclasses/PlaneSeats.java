/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airlinereservationclasses;

import airplanes.*;

import interfaces.SeatClassCostBehavior;
import seatclassbenefitsbehavior.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PlaneSeats {
    /**
     * The private final ArrayList containing information on the seat map and seat layout of the plane
     */
    private final ArrayList<ArrayList<ArrayList<Object>>> planeSeats;

    /**
     * The PlaneSeats Constructor that calls the method createSeats to make the seating information
     */
    public PlaneSeats() {
        this.planeSeats = createSeats();
    }

    /**
     * The createAirplanes method that creates a HashMap of the defined planes
     * @return HashMap with Integer keys and Airplane values Representing the list of defined planes
     */
    public HashMap<Integer, Airplane> createAirplanes() {
        HashMap<Integer, Airplane> airplanes = new HashMap<>();

        Airplane boeing737 = new Boeing737();
        Airplane airbusA320 = new AirbusA320();
        Airplane gulfstreamG200 = new GulfstreamG200();

        airplanes.put(1, boeing737);
        airplanes.put(2, airbusA320);
        airplanes.put(3, gulfstreamG200);

        return airplanes;
    }

    /**
     * The selectAirplanes method randomly selects one of the defined planes in a HashMap
     * @return Airplane Representing the random airplane that was chosen
     */
    public Airplane selectAirplane() {
        HashMap<Integer,Airplane> airplaneList = createAirplanes();

        int min = 1;
        int max = 3;

        Random randomValue = new Random();
        int random = min + randomValue.nextInt(max - min);

        Airplane randomPlane = airplaneList.get(random);

        return randomPlane;
    }

    /**
     * The createSeats method creates the seat map for each class in a plane depending
     * on the number of rows and the number of seats in a row
     * @return ArrayList Representing the info of the seat map and seat layout
     */
    public ArrayList<ArrayList<ArrayList<Object>>> createSeats() {
        Airplane plane = selectAirplane();
        ArrayList<ArrayList<ArrayList<Object>>> seats = new ArrayList<>();

        ArrayList<ArrayList<Object>> firstClassSeats = new ArrayList<>();

        for (int i = 1; i <= plane.getAmountOfRowsFirstClass(); i++) {
            for (int j = 0; j <= plane.getSeatsInRowFirstClass(); j++) {
                ArrayList<Object> firstClassSeatsInfo = new ArrayList<>();
                char seatLetter = (char) ('A' + j);

                firstClassSeatsInfo.add(Integer.toString(i) + seatLetter);
                firstClassSeatsInfo.add(false);
                firstClassSeats.add(firstClassSeatsInfo);
            }
        }
        seats.add(firstClassSeats);

        ArrayList<ArrayList<Object>> comfortClassSeats = new ArrayList<>();

        for (int i = 1; i <= plane.getAmountOfRowsComfortClass(); i++) {
            for (int j = 0; j <= plane.getSeatsInRowComfortClass(); j++) {
                ArrayList<Object> comfortClassSeatsInfo = new ArrayList<>();
                char seatLetter = (char) ('A' + j);

                comfortClassSeatsInfo.add(Integer.toString(i) + seatLetter);
                comfortClassSeatsInfo.add(false);
                comfortClassSeats.add(comfortClassSeatsInfo);
            }
        }
        seats.add(comfortClassSeats);

        ArrayList<ArrayList<Object>> economyClassSeats = new ArrayList<>();

        for (int i = 1; i <= plane.getAmountOfRowsEconomyClass(); i++) {
            for (int j = 0; j <= plane.getSeatsInRowEconomyClass(); j++) {
                ArrayList<Object> economyClassSeatsInfo = new ArrayList<>();
                char seatLetter = (char) ('A' + j);

                economyClassSeatsInfo.add(Integer.toString(i) + seatLetter);
                economyClassSeatsInfo.add(false);
                economyClassSeats.add(economyClassSeatsInfo);
            }
        }
        seats.add(economyClassSeats);

        return seats;
    }

    /**
     * The createSeats method iterates through the seat map of the plane and depending on
     * the seat class and finds the first available seat in that class
     * @param seats ArrayList Representing the information on the seat map and seat layout of the plane
     * @param seatClass SeatClassCostBehavior Representing the class of the seat
     * @return String Representing the first available seat in the given class
     */
    public String selectOpenSeat(ArrayList<ArrayList<ArrayList<Object>>> seats, SeatClassCostBehavior seatClass) {
        if (seats == null || seatClass == null) {
            throw new IllegalArgumentException("Bad param selectOpenSeat");
        }

        String openSeat = "";

        if (seatClass instanceof First) {
            for (int i = 0; i < seats.get(0).size(); i++) {
                boolean singleSeat = (boolean) seats.get(0).get(i).get(1);

                if (!singleSeat) {
                    seats.get(0).get(i).set(1, true);
                    openSeat = (String) seats.get(0).get(i).get(0);
                    break;
                }
            }
        } else if (seatClass instanceof Comfort) {
            for (int i = 0; i < seats.get(1).size(); i++) {
                boolean singleSeat = (boolean) seats.get(1).get(i).get(1);

                if (!singleSeat) {
                    seats.get(1).get(i).set(1, true);
                    openSeat = (String) seats.get(1).get(i).get(0);
                    break;
                }
            }
        } else {
            for (int i = 0; i < seats.get(2).size(); i++) {
                boolean singleSeat = (boolean) seats.get(2).get(i).get(1);

                if (!singleSeat) {
                    seats.get(2).get(i).set(1, true);
                    openSeat = (String) seats.get(2).get(i).get(0);
                    break;
                }
            }
        }

        return openSeat;
    }

    /**
     * The getPlaneSeats method is used to generate a new seat map
     * @return ArrayList Representing the seat map and seat layout
     */
    public ArrayList<ArrayList<ArrayList<Object>>> getPlaneSeats() {
        return planeSeats;
    }
}
