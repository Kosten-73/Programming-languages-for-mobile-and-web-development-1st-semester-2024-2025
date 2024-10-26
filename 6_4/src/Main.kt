object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        // динамический массив
        var ic: ICont = Container_1()
        ic.readFlights()
        println("Рейсы из ArrayList:")
        ic.displayCont()
        println("Поиск рейсов на 2024-10-21 в пункт назначения New York:")
        ic.searchFlights("2024-10-21", "New York")

        // словарь
        ic = Container_2()
        ic.readFlights()
        println("\nРейсы из HashMap:")
        ic.displayCont()
        println("Поиск рейсов на 2024-10-21 в пункт назначения New York:")
        ic.searchFlights("2024-10-21", "New York")
    }
}