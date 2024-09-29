public class Pound extends Currency {
    private static final double POUND_TO_RUBLES = 125.99;

    public Pound(double amount) {
        super(amount);
    }

    public Pound() {
    }

    /**
     * @return Число типа {@code double}, стоимость в рублях
     */
    @Override
    public double toRubles() {
        return amount * POUND_TO_RUBLES;
    }

    @Override
    public String toString() {
        return "Фунт стерлингов {" +
                "количество=" + amount +
                '}';
    }
}
