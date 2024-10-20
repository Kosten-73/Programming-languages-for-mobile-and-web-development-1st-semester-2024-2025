import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;

public class Container_2 implements ICont{
    HashMap<Integer, FlightShedule> flights = new HashMap<>();

    @Override
    public void displayCont() {
        for (FlightShedule flight : flights.values()) {
            flight.displayInfo();
        }
    }

    @Override
    public void readFlights() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\korudenko\\IdeaProjects\\Programming-languages-for-mobile-and-web-development-1st-semester-2024-2025\\4_2\\src\\flights.txt"));
            String line;
            String[] substr;
            FlightShedule flight;
            int key = 1; // Ключ для HashMap
            while ((line = br.readLine()) != null) {
                substr = line.split(",");
                flight = new FlightShedule(Integer.parseInt(substr[0]), substr[1], substr[2], substr[3], substr[4]);
                flights.put(key, flight);
                key++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка! Файл не найден!");
        }
    }

    @Override
    public void searchFlights(String date, String destination) {
        for (FlightShedule flight : flights.values()) {
            if (flight.getDepartureDate().equals(date) && flight.getDestination().equals(destination)) {
                flight.displayInfo();
            }
        }
    }
}
