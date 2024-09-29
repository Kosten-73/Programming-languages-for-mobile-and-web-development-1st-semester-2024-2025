public class Euro extends Currency {
    private static final double POUND_TO_RUBLES = 105.26;

    public Euro(double amount) {
        super(amount);
    }

    public Euro() {
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
        return "Евро{" +
                "количество=" + amount +
                '}';
    }
}
