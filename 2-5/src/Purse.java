import java.util.ArrayList;
import java.util.List;

public class Purse {
    // Поля для хранения объектов валют
    protected Dollar dollar; // Объект доллара
    protected Euro euro; // Объект евро
    protected Pound pound; // Объект фунта стерлингов

    // Конструктор кошелька, принимающий объекты валют
    public Purse(Dollar dollar, Euro euro, Pound pound) {
        this.dollar = dollar;
        this.euro = euro;
        this.pound = pound;
    }

    /**
     * Метод для снятия указанного количества каждой валюты.
     * @param d - сумма долларов
     * @param e - сумма евро
     * @param p - сумма фунтов стерлингов
     * @throws Currency.InsufficientFundsException - если на счету недостаточно средств
     */
    public void minus(double d, double e, double p) throws Currency.InsufficientFundsException {
        this.dollar.subtractAmount(d); // Снятие суммы долларов
        this.euro.subtractAmount(e); // Снятие суммы евро
        this.pound.subtractAmount(p); // Снятие суммы фунтов стерлингов
    }

    /**
     * Метод для снятия суммы валют, если не переданы значения (используются значения по умолчанию).
     * @throws Currency.InsufficientFundsException - если на счету недостаточно средств
     */
    public void minus() throws Currency.InsufficientFundsException {
        minus(0, 0, 0); // Все значения по умолчанию равны 0
    }

    /**
     * Метод для снятия суммы только в долларах, остальные валюты по умолчанию 0.
     * @param d - сумма долларов
     * @throws Currency.InsufficientFundsException - если на счету недостаточно средств
     */
    public void minus(double d) throws Currency.InsufficientFundsException {
        minus(d, 0, 0); // По умолчанию 0 для евро и фунтов
    }

    /**
     * Метод для снятия суммы в долларах и евро, фунты по умолчанию 0.
     * @param d - сумма долларов
     * @param e - сумма евро
     * @throws Currency.InsufficientFundsException - если на счету недостаточно средств
     */
    public void minus(double d, double e) throws Currency.InsufficientFundsException {
        minus(d, e, 0); // По умолчанию 0 для фунтов
    }

    /**
     * Метод для добавления указанной суммы к каждой валюте.
     * @param d - сумма долларов
     * @param e - сумма евро
     * @param p - сумма фунтов стерлингов
     */
    public void plus(double d, double e, double p) {
        this.dollar.addAmount(d); // Добавление суммы долларов
        this.euro.addAmount(e); // Добавление суммы евро
        this.pound.addAmount(p); // Добавление суммы фунтов стерлингов
    }

    /**
     * Метод для добавления суммы валют, если не переданы значения (по умолчанию 0).
     */
    public void plus() {
        plus(0, 0, 0); // Все значения по умолчанию равны 0
    }

    /**
     * Метод для добавления суммы только в долларах, остальные валюты по умолчанию 0.
     * @param d - сумма долларов
     */
    public void plus(double d) {
        plus(d, 0, 0); // По умолчанию 0 для евро и фунтов
    }

    /**
     * Метод для добавления суммы в долларах и евро, фунты по умолчанию 0.
     * @param d - сумма долларов
     * @param e - сумма евро
     */
    public void plus(double d, double e) {
        plus(d, e, 0); // По умолчанию 0 для фунтов
    }

    /**
     * Метод для конвертации всех валютных сумм в рубли и вывода результата на экран.
     */
    public void currency_to_rubles() {
        System.out.println(String.format(
                "Доллары %f в рубли: %f, Евро %f в рубли: %f, Фунт стерлингов %f в рубли: %f",
                this.dollar.getAmount(), this.dollar.toRubles(), // Конвертация долларов в рубли
                this.euro.getAmount(), this.euro.toRubles(), // Конвертация евро в рубли
                this.pound.getAmount(), this.pound.toRubles() // Конвертация фунтов в рубли
        ));
    }

    /**
     * Переопределенный метод toString для вывода информации о кошельке.
     * @return Строка с данными о валютах и их количестве
     */
    @Override
    public String toString() {
        return "Кошелек{" +
                dollar.toString() + ' ' + // Информация о долларах
                euro.toString() + ' ' + // Информация о евро
                pound.toString() + // Информация о фунтах
                '}';
    }
}
