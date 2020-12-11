package Vehicle;

import notInUse.DrawPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Represents a Vehicle.Volvo240 car.
 * It has the following attributes:
 * a final static double representing the trimFactor
 * The class also have following methods:
 * speedFactor()
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;
    private BufferedImage volvoImage;

    public Volvo240(double x, double y,String modelName) {
        super(x,y,4,100,0,Color.cyan, modelName, 90);
        stopEngine();
        try {

            volvoImage = ImageIO.read(this.getClass().getResourceAsStream("pics/Volvo240.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Volvo240(double x, double y, int nrDoors, double enginePower, double currentSpeed,
                    Color color, String modelName, int directionAngle, BufferedImage image){
        super(x,y, nrDoors, enginePower, currentSpeed, color, modelName,directionAngle, image);
        stopEngine();
    }


    public Volvo240(int nrDoors, double enginePower, double currentSpeed,
                    Color color, String modelName){
        super(0,0, nrDoors, enginePower, currentSpeed, color, modelName,0);
        stopEngine();
    }

    /** Returns a speedFactor based on Volvo's enginePower and trimFactor.
     * @return a speedFactor
     * */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public BufferedImage getImage() {
        return volvoImage;
    }
}
