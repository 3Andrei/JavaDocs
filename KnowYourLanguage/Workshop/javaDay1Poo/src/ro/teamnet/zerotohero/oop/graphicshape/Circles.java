package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Nicolescu on 30.06.2016.
 */
public class Circles {

    public double getAreaPub(){
        Circle circle=new Circle();
        return circle.area();
    }


    public void getAreaDef(){
        Circle circle=new Circle();
        circle.fillColour();
        circle.fillColour(4);
        circle.fillColour(5.6f);
    }
}
