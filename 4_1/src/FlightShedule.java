public class FlightShedule {
    private String departureDate;      // Дата вылета
    private String departureTime;   // Время вылета
    private String destination;     // Пункт назначения
    private String arrivalTime;     // Время прибытия
    private int flightNumber;       // Номер рейса

    // Конструктор с пятью параметрами
    public FlightShedule(int flightNumber, String departureDate, String departureTime, String destination, String arrivalTime) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
    }

    // Геттеры для получения значений полей (если потребуется)
    public String getDepartureDate() { return departureDate; }
    public String getDepartureTime() { return departureTime; }
    public String getDestination() { return destination; }
    public String getArrivalTime() { return arrivalTime; }
    public int getFlightNumber() { return flightNumber; }

    // Метод для отображения информации о рейсе
    public void displayInfo() {
        System.out.printf("Рейс %s: %s -> %s, вылет: %s, прибытие: %s\n",
                flightNumber, departureTime, destination, departureDate, arrivalTime);
    }
}
