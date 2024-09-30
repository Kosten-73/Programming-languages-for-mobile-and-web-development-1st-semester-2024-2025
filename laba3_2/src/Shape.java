import java.util.Scanner;

abstract class Shape {
    int n;
    Point[] arc;
    char id;
    abstract double getPerimeter();
    abstract double getSquare();
    abstract void info();
    public Scanner in = new Scanner(System.in);
}
