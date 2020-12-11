package Controller;

import Vehicle.Application;
import Vehicle.HasPlatform;
import Vehicle.Vehicle;

import javax.swing.*;

public class PlatformController {
    Application application = new Application();
    public JButton liftBedButton = new JButton("Lift Bed");
    public JButton lowerBedButton = new JButton("Lower Bed");

    /** Raises the platformAngle by 60° for all vehicles */
    public void raisePlatformAngle() {
        for(Vehicle vehicle : application.getVehicles()){
            if(vehicle instanceof HasPlatform){
                ((HasPlatform)vehicle).raisePlatformAngle(60);
            }
        }
    }

    /** Lowers the platformAngle by 60° for all vehicles */
    public void lowerPlatformAngle() {
        for(Vehicle vehicle : application.getVehicles()){
            if(vehicle instanceof HasPlatform){
                ((HasPlatform)vehicle).lowerPlatformAngle(60);
            }
        }
    }
}
