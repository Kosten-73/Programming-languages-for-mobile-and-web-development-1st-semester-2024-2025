public class Dollar extends Currency {
    private static final double DOLLAR_TO_RUBLES = 94.22;

    public Dollar(double amount) {
        super(amount);
    }

    public Dollar() {
    }

    /**
     * @return Число типа {@code double}, стоимость в рублях
     */
    @Override
    public double toRubles() {
        return amount * DOLLAR_TO_RUBLES;
    }

    @Override
    public String toString() {
        return "Доллар{" +
                "количество=" + amount +
                '}';
    }
}
