public class FactoryShape {
    public static Shape createShape(char cd){
        Shape sh = switch (cd) {
            case 'T' -> new Triangle();
            case 'R' -> new Rectangle();
            default -> null;
        };
        return sh;
    }
}
