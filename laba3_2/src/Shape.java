import java.util.Scanner; // Импортируем класс Scanner для ввода данных

/**
 * Абстрактный класс, представляющий общую форму для различных геометрических фигур.
 */
abstract class Shape {
    /** Количество вершин фигуры. */
    int n;

    /** Массив точек, представляющих вершины фигуры. */
    Point[] arc;

    /** Идентификатор фигуры. */
    char id;

    /**
     * Вычисляет периметр фигуры.
     *
     * @return периметр фигуры
     */
    abstract double getPerimeter();

    /**
     * Вычисляет площадь фигуры.
     *
     * @return площадь фигуры
     */
    abstract double getSquare();

    /**
     * Выводит информацию о фигуре.
     */
    abstract void info();

    /**
     * Проверяет, пересекается ли данная фигура с другой фигурой.
     *
     * @param otherShape другая фигура для проверки на пересечение
     * @return true, если фигуры пересекаются; false в противном случае
     */
    abstract boolean isIntersect(Shape otherShape);

    /** Объект для считывания ввода с клавиатуры. */
    public Scanner in = new Scanner(System.in);

    /**
     * Метод для сравнения площадей текущей фигуры с площадью другой фигуры.
     *
     * @param otherShape другая фигура для сравнения
     * @return коэффициент, равный отношению площади текущей фигуры к площади другой фигуры
     */
    public double compareArea(Shape otherShape) {
        double thisArea = this.getSquare(); // Площадь текущей фигуры
        double otherArea = otherShape.getSquare(); // Площадь другой фигуры
        return thisArea / otherArea; // Возвращаем коэффициент
    }
}
