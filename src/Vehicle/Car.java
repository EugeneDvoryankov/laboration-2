package Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class Car extends Vehicle {

    public Car(double x, double y, int nrDoors, double enginePower, double currentSpeed,
               Color color, String modelName, int directionAngle, BufferedImage image){
        super(x, y, nrDoors, enginePower, currentSpeed, color, modelName, directionAngle, image);
    }

public Car(double x, double y, int nrDoors, double enginePower, double currentSpeed,
           Color color, String modelName, int directionAngle){
    super(x, y, nrDoors, enginePower, currentSpeed, color, modelName, directionAngle);
}



}
