public class Main {
    public static void main(String[] args) throws Currency.InsufficientFundsException {
        // Создание объекта Dollar с начальной суммой 12
        Dollar dollar = new Dollar(12);
        dollar.addAmount(1); // Добавление 1 доллара
        dollar.subtractAmount(14); // Снятие 14 долларов, может возникнуть исключение
        System.out.println(dollar.toString()); // Вывод информации о состоянии доллара

        // Создание объекта Euro с начальной суммой 12
        Euro euro = new Euro(12);
        euro.addAmount(-4); // Добавление отрицательной суммы (уменьшение)
        euro.subtractAmount(3); // Снятие 3 евро
        System.out.println(euro.toString()); // Вывод информации о состоянии евро

        // Создание объекта Pound с нулевой начальной суммой (по умолчанию)
        Pound pound = new Pound();
        pound.addAmount(12); // Добавление 12 фунтов
        pound.subtractAmount(-19); // Уменьшение на -19 (что эквивалентно увеличению)
        System.out.println(pound.toString()); // Вывод информации о состоянии фунтов

        // Создание объекта Purse, включающего dollar, euro и pound
        Purse purse = new Purse(dollar, euro, pound);
        System.out.println(purse.toString()); // Вывод информации о состоянии кошелька

        // Добавление сумм к валютам в кошельке
        purse.dollar.addAmount(12); // Добавление 12 долларов
        purse.euro.addAmount(4); // Добавление 4 евро
        purse.pound.addAmount(19); // Добавление 19 фунтов
        System.out.println(purse.toString()); // Вывод информации о кошельке после пополнения

        // Использование метода plus() с разными комбинациями аргументов
        purse.plus(1); // Добавление 1 доллара
        System.out.println(purse.toString());

        purse.plus(1, 12.1); // Добавление 1 доллара и 12.1 евро
        System.out.println(purse.toString());

        purse.plus(1, 12.1, 7); // Добавление 1 доллара, 12.1 евро и 7 фунтов
        System.out.println(purse.toString());

        purse.plus(); // Вызов без аргументов, значения по умолчанию
        System.out.println(purse.toString());

        // Использование метода minus() с разными комбинациями аргументов
        purse.minus(1); // Снятие 1 доллара
        System.out.println(purse.toString());

        purse.minus(1, 12.3); // Снятие 1 доллара и 12.3 евро
        System.out.println(purse.toString());

        purse.minus(5, 9, 1); // Снятие 5 долларов, 9 евро и 1 фунта
        System.out.println(purse.toString());

        purse.minus(); // Вызов без аргументов, значения по умолчанию
        System.out.println(purse.toString());

        // Конвертация всех валют в рубли и вывод результата
        purse.currency_to_rubles(); // Перевод валют в рубли
    }
}
