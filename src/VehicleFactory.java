import Vehicle.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class VehicleFactory {

    public static Vehicle createVolvo(double x, double y,String modelName) {
        return new Volvo240(x, y, modelName);
    }

    public static Vehicle createSaab(double x, double y, String modelName) {
        return new Saab95(x,y, modelName);
    }

    public static Vehicle createScania(double x, double y, String modelName) {
        return new  Scania(x,y, modelName);
    }

}
