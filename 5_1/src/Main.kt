import java.util.*

internal object Function {
    fun <T> print_arrayList(telephons: ArrayList<T>) {
        for (telephon in telephons) {
            println(telephon.toString())
        }
    }
}


object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        // Создание списка телефонов
        val telephones = ArrayList<Telephone>()

        // Заполнение списка запомненных номеров для одного из телефонов
        val remembered_numbers1 = ArrayList<Long>()
        remembered_numbers1.add(9341294283L)
        remembered_numbers1.add(9646215252L)
        remembered_numbers1.add(9526432337L)
        remembered_numbers1.add(9576435441L)

        // Создание нескольких экземпляров телефонов и добавление их в список
        telephones.add(Telephone("iphone XS", "(903)472-99-36"))
        telephones.add(Telephone("iphone 15"))
        telephones.add(Telephone("iphone 16 Pro Max", "(952)642-52-52", remembered_numbers1, 0, 0.1))
        telephones.add(
            Telephone(
                "iphone 16 Plus",
                "(912)523-53-12",
                ArrayList(
                    mutableListOf(
                        5235231421L,
                        8494730074L,
                        1739572371L,
                        5235252421L,
                        8494745124L,
                        5439572371L,
                        5235253511L,
                        8494730114L,
                        1739599991L,
                        9325231421L,
                        8494957344L,
                        9563102371L
                    )
                ),
                0,
                0.3
            )
        )
        telephones.add(
            Telephone(
                "Samsung Galaxy S21",
                "(945)567-34-22",
                ArrayList(mutableListOf(9034729936L, 8494730074L, 1739572371L)),
                1,
                0.5
            )
        )
        telephones.add(Telephone("Google Pixel 5", "(934)123-45-67"))
        telephones.add(
            Telephone(
                "OnePlus 9 Pro",
                "(920)213-45-78",
                ArrayList(mutableListOf(9034729936L, 9646215252L, 9341294283L)),
                2,
                0.2
            )
        )
        telephones.add(
            Telephone(
                "Xiaomi Mi 11",
                "(947)123-45-67",
                ArrayList(mutableListOf(9526425252L, 9034729936L, 9646215252L)),
                3,
                0.4
            )
        )
        telephones.add(Telephone("Sony Xperia 1 III", 9125235312L))
        telephones.add(
            Telephone(
                "Huawei P40",
                "(908)123-45-78",
                ArrayList(mutableListOf(9034729936L, 9341294283L, 9234567890L, 9876543210L)),
                1,
                0.25
            )
        )
        telephones.add(Telephone("Nokia 3310", "(800)555-35-35", ArrayList(listOf(9034729936L)), 1, 0.15))
        telephones.add(
            Telephone(
                "Motorola Razr",
                "(987)654-32-10",
                ArrayList(mutableListOf(5235231421L, 8494730074L, 9034729936L)),
                2,
                0.12
            )
        )

        // Вызовы между телефонами
        telephones[0].toCall(telephones[1]) // iphone XS звонит на iphone 15
        telephones[1].toAnswer(telephones[0], 5) // iphone 15 отвечает, вызов длится 5 минут

        telephones[9].toCall(telephones[11]) // Huawei P40 звонит на Motorola Razr
        telephones[11].toAnswer(telephones[9], 7) // Motorola Razr отвечает, вызов длится 7 минут
        telephones[11].toAnswer(telephones[1], 7) // Motorola Razr отвечает, вызов длится 7 минут

        // Вывод всех телефонов на экран
        Function.print_arrayList(telephones)

        // Создаем объект Scanner для чтения данных с консоли
        val scanner = Scanner(System.`in`)

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
            println("Введите команду:")
            println("1 - ввод данных")
            println("2 - позвонить n - с какого номера m - куда позвонить")
            println("3 - ответить n - с какого номера m - откуда звонок k - продолжительность")
            println("4 - вывод последнего")
            println("5 - выход")
            val input = scanner.nextLine() // считываем всю строку

            // Проверка на пустой ввод
            if (input.trim { it <= ' ' }.isEmpty()) {
                println("Ошибка: Ввод не может быть пустым. Попробуйте снова.")
                continue  // возвращаемся к началу цикла
            }

            // Разбиение строки на части
            var parts = input.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray() // разбиваем строку на части

            val command: Int

            try {
                command = parts[0].toInt() // первая часть — это команда
            } catch (e: NumberFormatException) {
                println("Ошибка: Введите корректную команду.")
                continue
            }

            when (command) {
                1 -> {
                    // Добавление элемента
                    if (parts.size != 1) {
                        println("Ошибка: Не указано значение для добавления.")
                        continue
                    }
                    try {
                        parts = input.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                        // Чтение строки
                        print("Введите модель телефона: ")
                        val brand1 = scanner.nextLine()

                        // Чтение целого числа
                        print("Введите ваш номер телефона: ")
                        val number1 = scanner.nextLine()
                        val value = number1.toLong() // второе значение — это значение для добавления
                        telephones.add(Telephone(brand1, number1))
                    } catch (e: NumberFormatException) {
                        println("Ошибка: Введите целое число для добавления.")
                    }
                }

                2 -> telephones[parts[1].toInt()].toCall(telephones[parts[2].toInt()])
                3 -> telephones[parts[1].toInt()].toAnswer(telephones[parts[2].toInt()], parts[3].toInt()) // iphone 15 отвечает, вызов длится 5 минут
                4 -> println(telephones[telephones.size - 1].toString())
                5 -> {println("Выход из программы.")
                    scanner.close()
                    return
                }
                else -> println("Неверная команда. Попробуйте снова.")
            }
        }
    }
}