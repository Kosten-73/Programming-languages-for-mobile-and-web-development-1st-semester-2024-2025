import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Container_1 implements ICont{
    ArrayList<FlightShedule> flights = new ArrayList<>(); // Исправлено имя коллекции

    // Метод для чтения данных о рейсах из файла
    @Override
    public void readFlights() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\korudenko\\IdeaProjects\\Programming-languages-for-mobile-and-web-development-1st-semester-2024-2025\\4_2\\src\\flights.txt"));
            String line;
            String[] substr;
            FlightShedule flight;
            while ((line = br.readLine()) != null) {
                substr = line.split(",");
                flight = new FlightShedule(Integer.parseInt(substr[0]), substr[1], substr[2], substr[3], substr[4]);
                flights.add(flight); // Добавляем объект в список
            }
        } catch (IOException e) {
            System.out.println("Ошибка! Файл не найден!");
        }
    }

    // Метод для отображения всех рейсов
    @Override
    public void displayCont() {
        for (FlightShedule flight : flights) {
            flight.displayInfo();
        }
    }

    @Override
    public void searchFlights(String date, String destination){
        for (FlightShedule flight : flights) {
            if (flight.getDepartureDate().equals(date) && flight.getDestination().equals(destination)) {
                flight.displayInfo();
            }
        }
    }
}
