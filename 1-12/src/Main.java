import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Класс {@code Function} содержит вспомогательные функции для работы с коллекциями.
 */
class Function {
    /**
     * Метод для вывода содержимого {@code ArrayList} в консоль.
     *
     * @param telephons Список телефонов, который нужно вывести.
     * @param <T>       Тип данных в списке.
     */
    public static <T> void print_arrayList(ArrayList<T> telephons) {
        for (T telephon : telephons) {
            System.out.println(telephon.toString());
        }
    }
}

/**
 * Главный {@code Main} класс программы, содержащий метод {@code main}.
 */
public class Main {
    
    /**
     * Конструктор по умолчанию для класса Main.
     * Создает объект класса Main без каких-либо параметров.
     */
    public Main() {
        // Конструктор по умолчанию
    }

    /**
     * Точка входа программы, которая создает телефоны и выполняет действия с ними.
     *
     * @param args Аргументы командной строки (не используются в данном примере).
     */
    public static void main(String[] args) {
        // Создание списка телефонов
        ArrayList<Telephone> telephones = new ArrayList<>();

        // Заполнение списка запомненных номеров для одного из телефонов
        ArrayList<Long> remembered_numbers1 = new ArrayList<>();
        remembered_numbers1.add(9341294283L);
        remembered_numbers1.add(9646215252L);
        remembered_numbers1.add(9526432337L);
        remembered_numbers1.add(9576435441L);

        // Создание нескольких экземпляров телефонов и добавление их в список
        telephones.add(new Telephone("iphone XS", "(903)472-99-36"));
        telephones.add(new Telephone("iphone 15"));
        telephones.add(new Telephone("iphone 16 Pro Max", "(952)642-52-52", remembered_numbers1, 0, 0.1));
        telephones.add(new Telephone("iphone 16 Plus", "(912)523-53-12", new ArrayList<>(Arrays.asList(5235231421L, 8494730074L, 1739572371L, 5235252421L, 8494745124L, 5439572371L, 5235253511L, 8494730114L, 1739599991L,9325231421L, 8494957344L, 9563102371L)), 0, 0.3));
        telephones.add(new Telephone("Samsung Galaxy S21", "(945)567-34-22", new ArrayList<>(Arrays.asList(9034729936L, 8494730074L, 1739572371L)), 1, 0.5));
        telephones.add(new Telephone("Google Pixel 5", "(934)123-45-67"));
        telephones.add(new Telephone("OnePlus 9 Pro", "(920)213-45-78", new ArrayList<>(Arrays.asList(9034729936L, 9646215252L, 9341294283L)), 2, 0.2));
        telephones.add(new Telephone("Xiaomi Mi 11", "(947)123-45-67", new ArrayList<>(Arrays.asList(9526425252L, 9034729936L, 9646215252L)), 3, 0.4));
        telephones.add(new Telephone("Sony Xperia 1 III", 9125235312L));
        telephones.add(new Telephone("Huawei P40", "(908)123-45-78", new ArrayList<>(Arrays.asList(9034729936L, 9341294283L, 9234567890L, 9876543210L)), 1, 0.25));
        telephones.add(new Telephone("Nokia 3310", "(800)555-35-35", new ArrayList<>(List.of(9034729936L)), 1, 0.15));
        telephones.add(new Telephone("Motorola Razr", "(987)654-32-10", new ArrayList<>(Arrays.asList(5235231421L, 8494730074L, 9034729936L)), 2, 0.12));

        // Вызовы между телефонами
        telephones.get(0).toCall(telephones.get(1));  // iphone XS звонит на iphone 15
        telephones.get(1).toAnswer(telephones.get(0), 5);  // iphone 15 отвечает, вызов длится 5 минут

        telephones.get(9).toCall(telephones.get(11));  // Huawei P40 звонит на Motorola Razr
        telephones.get(11).toAnswer(telephones.get(9), 7);  // Motorola Razr отвечает, вызов длится 7 минут
        telephones.get(11).toAnswer(telephones.get(1), 7);  // Motorola Razr отвечает, вызов длится 7 минут

        // Вывод всех телефонов на экран
        Function.print_arrayList(telephones);

        // Создаем объект Scanner для чтения данных с консоли
        Scanner scanner = new Scanner(System.in);

        /*// Чтение строки
        System.out.print("Введите модель телефона: ");
        String brand = scanner.nextLine();

        // Чтение целого числа
        System.out.print("Введите ваш номер телефона: ");
        String number = scanner.nextLine();

        // Добавление телефона в список введенный из консоли
        telephones.add(new Telephone(brand, String.valueOf(number)));

        // Закрытие Scanner
        scanner.close();*/

        while (true) {
            System.out.println("Введите команду:");
            System.out.println("1 - ввод данных");
            System.out.println("2 - позвонить n - с какого номера m - куда позвонить");
            System.out.println("3 - ответить n - с какого номера m - откуда звонок k - продолжительность");
            System.out.println("4 - вывод последнего");
            System.out.println("5 - выход");
            String input = scanner.nextLine(); // считываем всю строку

            // Проверка на пустой ввод
            if (input.trim().isEmpty()) {
                System.out.println("Ошибка: Ввод не может быть пустым. Попробуйте снова.");
                continue; // возвращаемся к началу цикла
            }

            // Разбиение строки на части
            String[] parts = input.split(" "); // разбиваем строку на части

            int command;

            try {
                command = Integer.parseInt(parts[0]); // первая часть — это команда
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректную команду.");
                continue;
            }

            switch (command) {
                case 1:
                    // Добавление элемента
                    if (parts.length != 1) {
                        System.out.println("Ошибка: Не указано значение для добавления.");
                        continue;
                    }
                    try {
                        parts = input.split(" ");
                        // Чтение строки
                        System.out.print("Введите модель телефона: ");
                        String brand1 = scanner.nextLine();

                        // Чтение целого числа
                        System.out.print("Введите ваш номер телефона: ");
                        String number1 = scanner.nextLine();
                        long value = Long.parseLong(number1); // второе значение — это значение для добавления
                        telephones.add(new Telephone(brand1, number1));
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: Введите целое число для добавления.");
                    }
                    break;
                case 2:
                    telephones.get(Integer.parseInt(parts[1])).toCall(telephones.get(Integer.parseInt(parts[2])));
                    break;
                case 3:
                    telephones.get(Integer.parseInt(parts[1])).toAnswer(telephones.get(Integer.parseInt(parts[2])), Integer.parseInt(parts[3]));  // iphone 15 отвечает, вызов длится 5 минут
                    break;
                case 4:
                    System.out.println(telephones.get(telephones.size() - 1).toString());
                    break;
                case 5:
                    // Выход из программы
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }
}
