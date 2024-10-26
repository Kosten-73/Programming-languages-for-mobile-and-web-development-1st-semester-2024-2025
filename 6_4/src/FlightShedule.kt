class FlightShedule(
    val flightNumber: Int,
    val departureDate: String, // Дата вылета
    val departureTime: String, // Пункт назначения
    val destination: String, // Время прибытия
    val arrivalTime: String // Время вылета
) {
    // Метод для отображения информации о рейсе
    fun displayInfo() {
        System.out.printf(
            "Рейс %s: %s -> %s, вылет: %s, прибытие: %s\n",
            flightNumber, departureTime, destination, departureDate, arrivalTime
        )
    }
}
