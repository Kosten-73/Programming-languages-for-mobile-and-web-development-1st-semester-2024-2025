import java.util.Scanner;

abstract class Shape {
    int n;
    Point[] arc;
    char id;
    abstract double getPerimeter();
    abstract double getSquare();
    abstract void info();
    public Scanner in = new Scanner(System.in);

    // Метод для сравнения площадей двух фигур
    public double compareArea(Shape otherShape) {
        double thisArea = this.getSquare();
        double otherArea = otherShape.getSquare();
        return thisArea / otherArea;
    }
}
