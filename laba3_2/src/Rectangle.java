import static java.lang.Math.acos;

public class Rectangle extends Shape {
    public Rectangle() {
        this.id = 'R';
        this.n = 4;
        this.arc = new Point[n];
        System.out.println("Введите координаты прямоуголника " + 2 * n + " точек");
        for (int i = 0; i < n; i++) {
            arc[i] = new Point();
            arc[i].x = in.nextDouble();
            arc[i].y = in.nextDouble();
        }
    }

    @Override
    double getPerimeter() {
        return arc[0].distance(arc[1]) + arc[1].distance(arc[2]) + arc[2].distance(arc[3]) + arc[3].distance(arc[0]);
    }

    @Override
    double getSquare() {
        double dot1 = arc[0].x * arc[1].x + arc[0].y * arc[1].y;
        double dot2 = arc[1].x * arc[2].x + arc[1].y * arc[2].y;
        double dot3 = arc[2].x * arc[3].x + arc[2].y * arc[3].y;
        double dot4 = arc[3].x * arc[0].x + arc[3].y * arc[0].y;
        double d1 = arc[0].distance(arc[1]);
        double d2 = arc[1].distance(arc[2]);
        double d3 = arc[2].distance(arc[3]);
        double d4 = arc[3].distance(arc[0]);
        if (acos(dot1 / d1) == 0 && acos(dot2 / d2) == 0 && acos(dot3 / d3) == 0 && acos(dot4 / d4) == 0){
            return d1 * d2;
        }
        return 0; // throw new IllegalArgumentException();
    }

    @Override
    void info() {
        System.out.println("Прямоугольник");
    }
}
