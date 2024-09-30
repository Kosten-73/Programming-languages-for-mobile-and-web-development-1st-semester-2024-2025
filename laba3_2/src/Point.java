import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    double x, y;
    // Растояние между 2-мя точками
    double distance(Point p) {
        return sqrt(pow(x - p.x, 2) + pow(y - p.y, 2));
    }
}
