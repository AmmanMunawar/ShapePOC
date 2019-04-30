package MyFirstPackage;

class Shape{
    public void draw(){
        System.out.println("Shape draw function");
    }
}
class Circle extends Shape{
    private int x;
    private int y;
    private int radius;
    public Circle(int x,int y ,int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void draw(){
        System.out.println("Circle Points for X = " +  this.x + "  Circle Points for Y = "
                + this.y +"  Circle = " + this.radius);
    }
}
class Rectangle extends Shape{
    private int x;
    private int y;
    private int width;
    private int height;
    public Rectangle(int x,int y ,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void draw(){
        System.out.println("Rectangle Points for X = " +  this.x + "  Rectangle Points for Y = "
                + this.y +"  Rectangle Points for width = "
                + this.width +"  Rectangle Points for height = " +this.height);
    }
}
//class Pentagone extends Shape{
//    public void draw(){
//        System.out.println("Pentagon draw function");
//    }
//}
public class Main {

    public static void main(String[] args) {
        Circle circle_object = new Circle(1,2,3);
        Rectangle rectangle_object = new Rectangle(2,1,3,2);

//        circle_object.draw();
        Shape shape_object = circle_object;
        shape_object.draw();
        shape_object = rectangle_object;
        shape_object.draw();

    }
}