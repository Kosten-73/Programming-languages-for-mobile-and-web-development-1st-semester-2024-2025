public class Program {
    public static void main(String[] args) throws java.io.IOException{
        System.out.print("Какая фигура? ");
        char type = (char) System.in.read();
        Shape p1 = FactoryShape.createShape(type);
        if (p1 != null) {
            p1.info();
            System.out.println(p1.getSquare());
        } else {
            System.out.println("Неизвестная фигура");
        }

        System.out.print("Какая фигура? ");
        char type1 = (char) System.in.read();
        Shape p2 = FactoryShape.createShape(type1);
        if (p2 != null) {
            p2.info();
            System.out.println(p2.getSquare());
        } else {
            System.out.println("Неизвестная фигура");
        }

        assert p1 != null;
        System.out.println(String.format("фигура с типом %s, различна с фигурой с типом %s в коэффициент %f", type, type1, p1.compareArea(p2)));
    }
}
/*
0
0
5
8
10
0
*/
/*
1
1
3
1
3
3
1
3
*/