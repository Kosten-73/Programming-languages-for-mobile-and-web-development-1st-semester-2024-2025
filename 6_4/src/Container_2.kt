import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class Container_2 : ICont {
    var flights: HashMap<Int, FlightShedule> = HashMap()

    override fun readFlights() {
        try {
            val br = BufferedReader(FileReader("C:\\Users\\korudenko\\IdeaProjects\\Programming-languages-for-mobile-and-web-development-1st-semester-2024-2025\\4_2\\src\\flights.txt"))
            var line: String
            var substr: Array<String>
            var flight: FlightShedule
            var key = 1 // Ключ для HashMap
            while ((br.readLine().also { line = it }) != null) {
                substr = line.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                flight = FlightShedule(substr[0].toInt(), substr[1], substr[2], substr[3], substr[4])
                flights[key] = flight
                key++
            }
        } catch (e: IOException) {
            println("Ошибка! Файл не найден!")
        }
    }

    override fun searchFlights(date: String?, destination: String?) {
        for (flight in flights.values) {
            if (flight.departureDate == date && flight.destination == destination) {
                flight.displayInfo()
            }
        }
    }

    override fun displayCont() {
        for (flight in flights.values) {
            flight.displayInfo()
        }
    }
}
