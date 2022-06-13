package Interface;

public interface Polygon {
    void getArea(int length, int breadth);

    // calculate the perimeter of a Polygon
    default void getPerimeter(int... sides) {
        int perimeter = 0;
        for (int side: sides) {
            perimeter += side;
        }

        System.out.println("Perimeter: " + perimeter);
    }
}
