public class Program {
    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки
     * @throws java.io.IOException если возникает ошибка ввода-вывода
     */
    public static void main(String[] args) throws java.io.IOException {
        // Запрашиваем у пользователя, какую фигуру он хочет создать
        System.out.print("Какая фигура? ");
        char type = (char) System.in.read(); // Читаем символ, определяющий тип фигуры
        Shape p1 = FactoryShape.createShape(type); // Создаем фигуру с помощью фабрики

        // Проверяем, была ли фигура успешно создана
        if (p1 != null) {
            p1.info(); // Выводим информацию о фигуре
            System.out.println(p1.getSquare()); // Выводим площадь фигуры
        } else {
            System.out.println("Неизвестная фигура"); // Если фигура неизвестная, выводим сообщение
        }

        // Запрашиваем у пользователя вторую фигуру
        System.out.print("Какая фигура? ");
        char type1 = (char) System.in.read(); // Читаем символ для второй фигуры
        Shape p2 = FactoryShape.createShape(type1); // Создаем вторую фигуру

        // Проверяем, была ли вторая фигура успешно создана
        if (p2 != null) {
            p2.info(); // Выводим информацию о второй фигуре
            System.out.println(p2.getSquare()); // Выводим площадь второй фигуры
        } else {
            System.out.println("Неизвестная фигура"); // Если фигура неизвестная, выводим сообщение
        }

        // Проверяем, что первая фигура не равна null, прежде чем продолжать
        assert p1 != null; // Используем assert для отладки

        // Выводим информацию о сравнении площадей двух фигур
        System.out.println(String.format("фигура с типом %s, различна с фигурой с типом %s в коэффициент %f",
                type, type1, p1.compareArea(p2))); // Сравниваем площади фигур

        // Проверяем, пересекаются ли фигуры, если обе фигуры успешно созданы
        if (p1 != null && p2 != null) {
            System.out.println(String.format("Фигура с типом %s и фигура с типом %s пересекаются: %b",
                    type, type1, p1.isIntersect(p2))); // Выводим результат проверки на пересечение
        }
    }
}
