package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by Nicolescu on 30.06.2016.
 */
public class RunApp {
    public static void main(String[] args) {
        Circles circles = new Circles();
        double area = circles.getAreaPub();
        System.out.println("The default circle area is: " + area);
        circles.getAreaDef();
       Canvas canvas=new Canvas();
        //canvas.getArea();
        Shape circle=new Circle(10);
        System.out.println("Circle area is: "+circle.area());
        ShapeBehaviour square=new Square(10);
        System.out.println("Squarae area is: "+square.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

    }


}
