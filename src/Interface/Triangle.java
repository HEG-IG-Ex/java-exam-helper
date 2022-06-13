package Interface;

public class Triangle implements Polygon{
    @Override
    public void getArea(int length, int breadth) {
        System.out.println("The area of the triangle is " + (length / breadth));
    }
}
