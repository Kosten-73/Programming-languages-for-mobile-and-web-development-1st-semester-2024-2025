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

        return (Math.abs(angle1 - Math.PI / 2) < 1e-6 &&
                Math.abs(angle2 - Math.PI / 2) < 1e-6 &&
                Math.abs(angle3 - Math.PI / 2) < 1e-6 &&
                Math.abs(angle4 - Math.PI / 2) < 1e-6);
    }

    @Override
    double getSquare() {
        // Вычисляем скалярные произведения векторов
        double dot1 = arc[0].x * arc[1].x + arc[0].y * arc[1].y;
        double dot2 = arc[1].x * arc[2].x + arc[1].y * arc[2].y;

        // Вычисляем длины сторон
        double d1 = arc[0].distance(arc[1]);
        double d2 = arc[1].distance(arc[2]);

        if (isRectangle()){
            return d1 * d2;
        }
        throw new IllegalArgumentException("Фигура не является прямоугольником");
    }


    @Override
    void info() {
        if (isRectangle()){
            System.out.println("Прямоугольник");
        }
        else {
            // Выбрасываем исключение, если не прямоугольник
            throw new IllegalArgumentException("Фигура не является прямоугольником");
        }
    }
}
