package Vehicle;

import Vehicle.HasTurbo;
import Vehicle.Turbo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Represents a Vehicle.Saab95 car.
 * It has the following attributes:
 * A boolean representing that Vehicle.Saab95's turbo is On or Off.
 * The class also have following methods:
 * setTurboOn(), setTurboOff(), isTurboOn() and speedFactor()
 */
public class Saab95 extends Car implements HasTurbo {
private Turbo turbo = new Turbo();
private BufferedImage saabImage;

    public Saab95(double x, double y, String modelName) {
        super(x,y,4,100,0,Color.cyan, modelName, 90);
        stopEngine();
        try {

            saabImage = ImageIO.read(this.getClass().getResourceAsStream("pics/Saab95.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Saab95(double x, double y,int nrDoors, double enginePower, double currentSpeed,
                  Color color, String modelName, int directionAngle){
        super(x,y, nrDoors, enginePower, currentSpeed, color, modelName,directionAngle);
        setTurboOff();
        stopEngine();
    }

    public Saab95(int nrDoors, double enginePower, double currentSpeed,
                  Color color, String modelName){
        super(0,0, nrDoors, enginePower, currentSpeed, color, modelName,0);
        setTurboOff();
        stopEngine();
    }

    @Override
    public BufferedImage getImage() {
        return saabImage;
    }
    /**
     * Sets turboOn true.
     */
    public void setTurboOn(){
	    turbo.setTurboOn();
    }

    /**
     *  Sets turboOn false.
     */
    public void setTurboOff(){
	    turbo.setTurboOff();
    }

    /**
     * @return a boolean representing turboOn is true or false.
     */
    public boolean isTurboOn() {
        return turbo.isTurboOn();
    }

    /**
     * @return a double representing speedFactor
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(isTurboOn()) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
