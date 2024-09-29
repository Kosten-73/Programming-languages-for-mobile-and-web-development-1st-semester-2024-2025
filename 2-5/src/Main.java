public class Main {
    public static void main(String[] args) throws Currency.InsufficientFundsException {
        Dollar dollar = new Dollar(12);
        dollar.addAmount(1);
        dollar.subtractAmount(14);
        System.out.println(dollar.toString());

        Euro euro = new Euro(12);
        euro.addAmount(-4);
        euro.subtractAmount(3);
        System.out.println(euro.toString());

        Pound pound = new Pound();
        pound.addAmount(12);
        pound.subtractAmount(-19);
        System.out.println(pound.toString());

        Purse purse = new Purse(dollar, euro, pound);
        System.out.println(purse.toString());
        purse.dollar.addAmount(12);
        purse.euro.addAmount(4);
        purse.pound.addAmount(19);
        System.out.println(purse.toString());

        purse.plus(1);
        System.out.println(purse.toString());
        purse.plus(1, 12.1);
        System.out.println(purse.toString());
        purse.plus(1, 12.1, 7);
        System.out.println(purse.toString());
        purse.plus();
        System.out.println(purse.toString());

        purse.minus(1);
        System.out.println(purse.toString());
        purse.minus(1, 12.3);
        System.out.println(purse.toString());
        purse.minus(5, 9, 1);
        System.out.println(purse.toString());
        purse.minus();
        System.out.println(purse.toString());

        purse.currency_to_rubles();
    }
}