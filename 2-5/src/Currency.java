/**
 * Абстрактный класс Currency для работы с денежными суммами.
 * Реализует базовые методы добавления и вычитания средств,
 * а также содержит метод для конвертации в рубли, который должен быть реализован в подклассах.
 */
abstract class Currency {
    // Текущая сумма валюты
    protected double amount = 0;

    /**
     * Конструктор класса Currency с заданным значением суммы.
     * @param amount начальное количество валюты.
     */
    public Currency(double amount) {
        this.amount = amount;
    }

    /**
     * Конструктор класса Currency без параметров.
     * По умолчанию сумма валюты инициализируется как 0.
     */
    public Currency() {
    }

    /**
     * Возвращает текущую сумму валюты.
     * @return количество валюты.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Устанавливает значение количества валюты.
     * @param amount новая сумма валюты.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Метод для добавления суммы к текущему балансу валюты.
     * @param value сумма для добавления.
     */
    public void addAmount(double value) {
        this.amount += value;
        System.out.println("Сумма пополнения +" + value + " успешно добавлена. Остаток: " + amount);
    }

    /**
     * Вложенный статический класс исключения, которое возникает при недостатке средств.
     */
    public static class InsufficientFundsException extends Exception {
        /**
         * Конструктор исключения с передачей сообщения.
         * @param message сообщение об ошибке.
         */
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    /**
     * Метод для вычитания суммы с текущего баланса.
     * Если запрашиваемая сумма больше доступной, бросается исключение InsufficientFundsException.
     * @param value сумма для снятия.
     * @throws InsufficientFundsException исключение при недостатке средств.
     */
    public void subtractAmount(double value) throws InsufficientFundsException {
        try {
            if (value <= amount) {
                this.amount -= value;
                System.out.println("Сумма " + value + " успешно снята. Остаток: " + amount);
            } else {
                // Бросаем исключение, если запрашиваемая сумма больше, чем доступная
                throw new InsufficientFundsException(String.format(
                        "Счёт дебитовый, поэтому средств не может быть меньше нуля (%f)",
                        this.amount - value
                ));
            }
        } catch (InsufficientFundsException e) {
            // Обрабатываем исключение прямо в методе и выводим сообщение
            System.out.println(e.getMessage());
        }
    }

    /**
     * Абстрактный метод для конвертации валюты в рубли.
     * Должен быть реализован в подклассах (например, для евро, долларов и фунтов).
     * @return сумма в рублях.
     */
    public abstract double toRubles();

    /**
     * Метод возвращает строковое представление объекта.
     * @return строка с информацией о текущем состоянии объекта Currency.
     */
    @Override
    public String toString() {
        return "Валюта{" +
                "количество=" + amount +
                '}';
    }
}
