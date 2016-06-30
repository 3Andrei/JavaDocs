package ro.teamnet.zerotohero.oop.graphicshape;


import static java.lang.Math.PI;

/**
 * Created by Nicolescu on 30.06.2016.
 */
public class Circle extends Shape{
    private int xPos;
    private int yPos;
    private int radius;

    public Circle(){
        this.xPos=100;
        this.yPos=100;
        this.radius=10;
    }

    public Circle(int xPos){
        this.xPos=xPos;
        this.yPos=100;
        this.radius=10;
    }
    public Circle(int xPos, int yPos){
        this.xPos=xPos;
        this.yPos=yPos;
        this.radius=10;
    }

    public Circle(int xPos, int yPos, int radius){
        this.xPos=xPos;
        this.yPos=yPos;
        this.radius=radius;
    }


    @Override
    public double area(){
        return radius*radius*PI;
    }
    @Override
    public String toString(){
        return "center=("+xPos+","+yPos+") and radius= "+radius;
    }

    public void fillColour(){
        System.out.println("Circle color is: " +this.color+
                "");
    }
    public void fillColour(int color){
        this.color=color;
        System.out.println("The circle color is now: "+ color);
    }
    public void fillColour(float saturation){
        this.saturation=saturation;
        System.out.println("The circle saturation is now: "+ saturation);
    }

}
