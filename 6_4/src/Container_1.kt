import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class Container_1 : ICont {
    var flights: ArrayList<FlightShedule> = ArrayList() // Исправлено имя коллекции

    // Метод для чтения данных о рейсах из файла
    override fun readFlights() {
        try {
            val br = BufferedReader(FileReader("C:\\Users\\korudenko\\IdeaProjects\\Programming-languages-for-mobile-and-web-development-1st-semester-2024-2025\\4_2\\src\\flights.txt"))
            var line: String
            var substr: Array<String>
            var flight: FlightShedule
            while ((br.readLine().also { line = it }) != null) {
                substr = line.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                flight = FlightShedule(substr[0].toInt(), substr[1], substr[2], substr[3], substr[4])
                flights.add(flight) // Добавляем объект в список
            }
        } catch (e: IOException) {
            println("Ошибка! Файл не найден!")
        }
    }

    // Метод для отображения всех рейсов
    override fun displayCont() {
        for (flight in flights) {
            flight.displayInfo()
        }
    }

    override fun searchFlights(date: String?, destination: String?) {
        for (flight in flights) {
            if (flight.departureDate == date && flight.destination == destination) {
                flight.displayInfo()
            }
        }
    }
}