import static java.lang.Math.sqrt;

public class Triangle extends Shape{
    public Triangle() {
        this.id = 'T';
        this.n = 3;
        this.arc = new Point[n];
        System.out.println("Введите координаты треугольника " + 2 * n + " точек");
        for (int i = 0; i < n; i++) {
            arc[i] = new Point();
            arc[i].x = in.nextDouble();
            arc[i].y = in.nextDouble();
        }
    }

    @Override
    double getPerimeter() {
        return arc[0].distance(arc[1]) + arc[1].distance(arc[2]) + arc[2].distance(arc[0]);
    }

    @Override
    double getSquare() {
        double a = arc[0].distance(arc[1]);
        double b = arc[1].distance(arc[2]);
        double c = arc[2].distance(arc[0]);
        double p = (a + b + c) / 2;
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    void info() {
        System.out.println("Треугольник");
    }
}
