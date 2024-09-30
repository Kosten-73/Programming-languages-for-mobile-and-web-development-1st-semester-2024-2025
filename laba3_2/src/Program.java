public class Program {
    public static void main(String[] args) throws java.io.IOException{
        System.out.print("Какая фигура? ");
        char type = (char) System.in.read();
        Shape p1 = FactoryShape.createShape(type);
        if (p1 != null) {
            p1.info();
        } else {
            System.out.println("Неизвестная фигура");
        }
    }
}