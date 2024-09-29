abstract class Currency {
    protected double amount = 0; // количество валюты

    public Currency(double amount) {
        this.amount = amount;
    }

    public Currency() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void addAmount(double value) {
        this.amount += value;
        System.out.println("Сумма пополнения +" + value + " успешно добавлена. Остаток: " + amount);
    }

    public static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }


    public void subtractAmount(double value) throws InsufficientFundsException {
        try {
            if (value <= amount) {
                this.amount -= value;
                System.out.println("Сумма " + value + " успешно снята. Остаток: " + amount);
            } else {
                throw new InsufficientFundsException(String.format("Счёт дебитовый, поэтому средств не может быть меньше нуля (%f)", this.amount - value));
            }
        } catch (InsufficientFundsException e) {
            // Обрабатываем исключение прямо в методе и выводим сообщение
            System.out.println(e.getMessage());
        }
    }

    public abstract double toRubles(); // Перевод в рубли

    @Override
    public String toString() {
        return "Currency{" +
                "amount=" + amount +
                '}';
    }
}
