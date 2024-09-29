/**
 * Класс Dollar наследует абстрактный класс Currency и представляет доллар США.
 * Реализует метод для конвертации долларов в рубли.
 */
public class Dollar extends Currency {
    // Константа для курса доллара к рублю
    private static final double DOLLAR_TO_RUBLES = 94.22;

    /**
     * Конструктор класса Dollar с заданным количеством долларов.
     * @param amount количество долларов.
     */
    public Dollar(double amount) {
        super(amount); // Вызывает конструктор базового класса Currency
    }

    /**
     * Конструктор по умолчанию для класса Dollar.
     * Устанавливает начальную сумму в 0.
     */
    public Dollar() {
        // Конструктор без параметров (по умолчанию amount = 0)
    }

    /**
     * Метод для конвертации долларов в рубли.
     * @return стоимость в рублях, рассчитанная на основе курса.
     */
    @Override
    public double toRubles() {
        return amount * DOLLAR_TO_RUBLES;
    }

    /**
     * Возвращает строковое представление объекта Dollar.
     * @return строка, описывающая объект Dollar с текущим количеством.
     */
    @Override
    public String toString() {
        return "Доллар{" +
                "количество=" + amount +
                '}';
    }
}
