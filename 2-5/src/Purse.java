import java.util.ArrayList;
import java.util.List;

public class Purse {
    protected Dollar dollar;
    protected Euro euro;
    protected Pound pound;

    public Purse(Dollar dollar, Euro euro, Pound pound) {
        this.dollar = dollar;
        this.euro = euro;
        this.pound = pound;
    }

    public void minus(double d, double e, double p) throws Currency.InsufficientFundsException {
        this.dollar.subtractAmount(d);
        this.euro.subtractAmount(e);
        this.pound.subtractAmount(p);
    }

    public void minus() throws Currency.InsufficientFundsException {
        minus(0, 0, 0); // Если не переданы значения, все параметры по умолчанию 0
    }

    public void minus(double d) throws Currency.InsufficientFundsException {
        minus(d, 0, 0); // По умолчанию 0 для евро и фунтов
    }

    public void minus(double d, double e) throws Currency.InsufficientFundsException {
        minus(d, e, 0); // По умолчанию 0 для фунтов
    }


    public void plus(double d, double e, double p) {
        this.dollar.addAmount(d);
        this.euro.addAmount(e);
        this.pound.addAmount(p);
    }

    public void plus() {
        plus(0, 0, 0); // Если не переданы значения, все параметры по умолчанию 0
    }

    public void plus(double d) {
        plus(d, 0, 0); // По умолчанию 0 для евро и фунтов
    }

    public void plus(double d, double e) {
        plus(d, e, 0); // По умолчанию 0 для фунтов
    }

    public void currency_to_rubles() {
        System.out.println(String.format("Доллары %f в рубли: %f, Евро %f в рубли: %f, Фунт стерлингов %f в рубли: %f", this.dollar.getAmount(), this.dollar.toRubles(), this.euro.getAmount(), this.euro.toRubles(), this.pound.getAmount(), this.pound.toRubles()));
    }

    @Override
    public String toString() {
        return "Кошелек{" +
                dollar.toString() + ' ' +
                euro.toString() + ' ' +
                pound.toString() +
                '}';
    }
}
