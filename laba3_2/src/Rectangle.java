import static java.lang.Math.acos; // Импортируем функцию арккосинуса

/**
 * Класс, представляющий прямоугольник, наследуется от абстрактного класса Shape.
 */
public class Rectangle extends Shape {
    /**
     * Конструктор класса Rectangle.
     * Запрашивает у пользователя координаты вершин прямоугольника.
     */
    public Rectangle() {
        this.id = 'R'; // Устанавливаем идентификатор фигуры
        this.n = 4; // Указываем количество вершин прямоугольника
        this.arc = new Point[n]; // Инициализируем массив точек
        System.out.println("Введите координаты прямоуголника " + 2 * n + " точек");
        for (int i = 0; i < n; i++) {
            arc[i] = new Point(); // Создаем новый объект Point для каждой вершины
            arc[i].x = in.nextDouble(); // Считываем координату x
            arc[i].y = in.nextDouble(); // Считываем координату y
        }
    }

    @Override
    double getPerimeter() {
        // Вычисляем периметр прямоугольника как сумму длин всех его сторон
        return arc[0].distance(arc[1]) + arc[1].distance(arc[2]) +
                arc[2].distance(arc[3]) + arc[3].distance(arc[0]);
    }

    /**
     * Проверяет, является ли текущая фигура прямоугольником.
     *
     * @return true, если фигура является прямоугольником; false в противном случае
     */
    public Boolean isRectangle() {
        // Векторы между последовательными точками
        double[] vector1 = {arc[1].x - arc[0].x, arc[1].y - arc[0].y};
        double[] vector2 = {arc[2].x - arc[1].x, arc[2].y - arc[1].y};
        double[] vector3 = {arc[3].x - arc[2].x, arc[3].y - arc[2].y};
        double[] vector4 = {arc[0].x - arc[3].x, arc[0].y - arc[3].y};

        // Вычисляем длины векторов
        double length1 = Math.sqrt(vector1[0] * vector1[0] + vector1[1] * vector1[1]);
        double length2 = Math.sqrt(vector2[0] * vector2[0] + vector2[1] * vector2[1]);
        double length3 = Math.sqrt(vector3[0] * vector3[0] + vector3[1] * vector3[1]);
        double length4 = Math.sqrt(vector4[0] * vector4[0] + vector4[1] * vector4[1]);

        // Скалярные произведения соседних векторов
        double dot1 = vector1[0] * vector2[0] + vector1[1] * vector2[1];
        double dot2 = vector2[0] * vector3[0] + vector2[1] * vector3[1];
        double dot3 = vector3[0] * vector4[0] + vector3[1] * vector4[1];
        double dot4 = vector4[0] * vector1[0] + vector4[1] * vector1[1];

        // Вычисляем углы через арккосинус косинусов углов
        double angle1 = Math.acos(dot1 / (length1 * length2));
        double angle2 = Math.acos(dot2 / (length2 * length3));
        double angle3 = Math.acos(dot3 / (length3 * length4));
        double angle4 = Math.acos(dot4 / (length4 * length1));

        // Проверяем, все ли углы равны 90 градусам
        return (Math.abs(angle1 - Math.PI / 2) < 1e-6 &&
                Math.abs(angle2 - Math.PI / 2) < 1e-6 &&
                Math.abs(angle3 - Math.PI / 2) < 1e-6 &&
                Math.abs(angle4 - Math.PI / 2) < 1e-6);
    }

    @Override
    double getSquare() {
        // Вычисляем длины сторон
        double d1 = arc[0].distance(arc[1]);
        double d2 = arc[1].distance(arc[2]);

        // Проверяем, является ли фигура прямоугольником
        if (isRectangle()) {
            return d1 * d2; // Площадь равна произведению сторон
        }
        // Выбрасываем исключение, если не прямоугольник
        throw new IllegalArgumentException("Фигура не является прямоугольником");
    }

    @Override
    void info() {
        // Если фигура является прямоугольником, выводим информацию
        if (isRectangle()) {
            System.out.println("Прямоугольник");
        } else {
            // Выбрасываем исключение, если не прямоугольник
            throw new IllegalArgumentException("Фигура не является прямоугольником");
        }
    }

    @Override
    boolean isIntersect(Shape otherShape) {
        // Проверяем, пересекается ли текущий прямоугольник с треугольником
        if (otherShape instanceof Triangle) {
            Triangle triangle = (Triangle) otherShape;
            return checkIntersectionWithTriangle(triangle);
        }
        return false; // Не обрабатываем другие фигуры
    }

    // Метод для проверки пересечения с треугольником
    protected boolean checkIntersectionWithTriangle(Triangle triangle) {
        // Проверяем пересечение с каждой стороной треугольника
        return lineIntersect(arc[0], arc[1], triangle.arc[0], triangle.arc[1]) ||
                lineIntersect(arc[1], arc[2], triangle.arc[0], triangle.arc[1]) ||
                lineIntersect(arc[2], arc[3], triangle.arc[0], triangle.arc[1]) ||
                lineIntersect(arc[3], arc[0], triangle.arc[0], triangle.arc[1]) ||
                lineIntersect(arc[0], arc[1], triangle.arc[1], triangle.arc[2]) ||
                lineIntersect(arc[1], arc[2], triangle.arc[1], triangle.arc[2]) ||
                lineIntersect(arc[2], arc[3], triangle.arc[1], triangle.arc[2]) ||
                lineIntersect(arc[3], arc[0], triangle.arc[1], triangle.arc[2]) ||
                lineIntersect(arc[0], arc[1], triangle.arc[2], triangle.arc[0]) ||
                lineIntersect(arc[1], arc[2], triangle.arc[2], triangle.arc[0]) ||
                lineIntersect(arc[2], arc[3], triangle.arc[2], triangle.arc[0]) ||
                lineIntersect(arc[3], arc[0], triangle.arc[2], triangle.arc[0]);
    }

    // Метод для проверки пересечения двух отрезков
    private boolean lineIntersect(Point a1, Point a2, Point b1, Point b2) {
        double d1 = direction(b1, b2, a1);
        double d2 = direction(b1, b2, a2);
        double d3 = direction(a1, a2, b1);
        double d4 = direction(a1, a2, b2);

        // Если отрезки пересекаются
        if (d1 * d2 < 0 && d3 * d4 < 0) return true;

        // Коллинеарные случаи
        if (d1 == 0 && onSegment(b1, b2, a1)) return true;
        if (d2 == 0 && onSegment(b1, b2, a2)) return true;
        if (d3 == 0 && onSegment(a1, a2, b1)) return true;
        if (d4 == 0 && onSegment(a1, a2, b2)) return true;

        return false; // Отрезки не пересекаются
    }

    // Метод для определения направления векторов
    private double direction(Point a, Point b, Point c) {
        return (c.y - a.y) * (b.x - a.x) - (c.x - a.x) * (b.y - a.y);
    }

    // Метод для проверки, находится ли точка на отрезке
    private boolean onSegment(Point a, Point b, Point c) {
        return Math.min(a.x, b.x) <= c.x && c.x <= Math.max(a.x, b.x) &&
                Math.min(a.y, b.y) <= c.y && c.y <= Math.max(a.y, b.y);
    }
}
