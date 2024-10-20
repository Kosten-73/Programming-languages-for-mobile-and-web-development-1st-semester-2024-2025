public class Main {
    public static void main(String[] args) {
        // динамический массив
        ICont ic = new Container_1();
        ic.readFlights();
        System.out.println("Рейсы из ArrayList:");
        ic.displayCont();
        System.out.println("Поиск рейсов на 2024-10-21 в пункт назначения New York:");
        ic.searchFlights("2024-10-21", "New York");

        // словарь
        ic = new Container_2();
        ic.readFlights();
        System.out.println("\nРейсы из HashMap:");
        ic.displayCont();
        System.out.println("Поиск рейсов на 2024-10-21 в пункт назначения New York:");
        ic.searchFlights("2024-10-21", "New York");
    }
}
