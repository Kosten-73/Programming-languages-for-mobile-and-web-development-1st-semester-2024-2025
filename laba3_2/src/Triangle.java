import static java.lang.Math.sqrt; // Импортируем функцию квадратного корня

/**
 * Класс, представляющий треугольник, наследуется от абстрактного класса Shape.
 */
public class Triangle extends Shape {
    /**
     * Конструктор класса Triangle.
     * Запрашивает у пользователя координаты вершин треугольника.
     */
    public Triangle() {
        this.id = 'T'; // Устанавливаем идентификатор фигуры
        this.n = 3; // Указываем количество вершин треугольника
        this.arc = new Point[n]; // Инициализируем массив точек
        System.out.println("Введите координаты треугольника " + 2 * n + " точек");
        for (int i = 0; i < n; i++) {
            arc[i] = new Point(); // Создаем новый объект Point для каждой вершины
            arc[i].x = in.nextDouble(); // Считываем координату x
            arc[i].y = in.nextDouble(); // Считываем координату y
        }
    }

    @Override
    double getPerimeter() {
        // Вычисляем периметр треугольника как сумму длин всех его сторон
        return arc[0].distance(arc[1]) + arc[1].distance(arc[2]) + arc[2].distance(arc[0]);
    }

    @Override
    double getSquare() {
        // Вычисляем длины сторон треугольника
        double a = arc[0].distance(arc[1]);
        double b = arc[1].distance(arc[2]);
        double c = arc[2].distance(arc[0]);

        // Проверка на то, является ли треугольник вырожденным (сумма двух сторон не больше третьей)
        if (a + b <= c || a + c <= b || b + c <= a) {
            return 0; // Вырожденный треугольник, площадь равна 0
        }

        // Полупериметр
        double p = (a + b + c) / 2;
        // Площадь по формуле Герона
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    void info() {
        // Выводим информацию о фигуре
        System.out.println("Треугольник");
    }

    /**
     * Метод для проверки пересечения с другим треугольником.
     *
     * @param triangle другой треугольник для проверки на пересечение
     * @return true, если треугольники пересекаются; false в противном случае
     */
    private boolean checkIntersectionWithTriangle(Triangle triangle) {
        // Проверяем пересечение каждой стороны нашего треугольника с каждой стороной другого треугольника
        return lineIntersect(arc[0], arc[1], triangle.arc[0], triangle.arc[1]) ||
                lineIntersect(arc[0], arc[1], triangle.arc[1], triangle.arc[2]) ||
                lineIntersect(arc[0], arc[1], triangle.arc[2], triangle.arc[0]) ||

                lineIntersect(arc[1], arc[2], triangle.arc[0], triangle.arc[1]) ||
                lineIntersect(arc[1], arc[2], triangle.arc[1], triangle.arc[2]) ||
                lineIntersect(arc[1], arc[2], triangle.arc[2], triangle.arc[0]) ||

                lineIntersect(arc[2], arc[0], triangle.arc[0], triangle.arc[1]) ||
                lineIntersect(arc[2], arc[0], triangle.arc[1], triangle.arc[2]) ||
                lineIntersect(arc[2], arc[0], triangle.arc[2], triangle.arc[0]);
    }

    @Override
    boolean isIntersect(Shape otherShape) {
        // Проверяем, пересекается ли текущий треугольник с другим геометрическим объектом
        if (otherShape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) otherShape;
            return rectangle.checkIntersectionWithTriangle(this); // Проверяем пересечение с прямоугольником
        } else if (otherShape instanceof Triangle) {
            Triangle triangle = (Triangle) otherShape;
            return checkIntersectionWithTriangle(triangle); // Проверяем пересечение с другим треугольником
        }
        return false; // Не обрабатываем другие фигуры
    }

    /**
     * Метод для проверки пересечения двух отрезков (p1, p2) и (q1, q2).
     *
     * @param p1 первая точка первого отрезка
     * @param p2 вторая точка первого отрезка
     * @param q1 первая точка второго отрезка
     * @param q2 вторая точка второго отрезка
     * @return true, если отрезки пересекаются; false в противном случае
     */
    private boolean lineIntersect(Point p1, Point p2, Point q1, Point q2) {
        double d1 = direction(q1, q2, p1);
        double d2 = direction(q1, q2, p2);
        double d3 = direction(p1, p2, q1);
        double d4 = direction(p1, p2, q2);

        // Пересечение отрезков проверяется с помощью знаков направлений:
        // Проверяем, пересекаются ли отрезки
        if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) &&
                ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {
            return true; // Отрезки пересекаются
        }

        /*Если отрезки коллинеарны (совпадают по направлению), проверяется, находятся ли точки на одном отрезке
        с помощью метода onSegment:*/
        // Проверяем коллинеарные случаи
        return (d1 == 0 && onSegment(q1, q2, p1)) ||
                (d2 == 0 && onSegment(q1, q2, p2)) ||
                (d3 == 0 && onSegment(p1, p2, q1)) ||
                (d4 == 0 && onSegment(p1, p2, q2));
    }

    /**
     * Вычисляем направление для проверки пересечения.
     *
     * @param pi первая точка
     * @param pj вторая точка
     * @param pk третья точка
     * @return направление
     */
    private double direction(Point pi, Point pj, Point pk) {
        return (pk.x - pi.x) * (pj.y - pi.y) - (pj.x - pi.x) * (pk.y - pi.y); // направление
    }

    /**
     * Проверка, находится ли точка на отрезке.
     *
     * @param pi первая точка отрезка
     * @param pj вторая точка отрезка
     * @param pk проверяемая точка
     * @return true, если точка pk находится на отрезке; false в противном случае
     */
    private boolean onSegment(Point pi, Point pj, Point pk) {
        return Math.min(pi.x, pj.x) <= pk.x && pk.x <= Math.max(pi.x, pj.x) &&
                Math.min(pi.y, pj.y) <= pk.y && pk.y <= Math.max(pi.y, pj.y);
    }
}
