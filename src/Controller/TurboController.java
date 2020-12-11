package Controller;

import Vehicle.Application;
import Vehicle.HasTurbo;
import Vehicle.Vehicle;

import javax.swing.*;

public class TurboController {

    Application application = new Application();
    public JButton turboOnButton = new JButton("Turbo on");
    public JButton turboOffButton = new JButton("Turbo off");


    /** Sets turbo On for all vehicles
     *
     */
    public void turboOn() {
        for(Vehicle vehicle : application.getVehicles()){
            if(vehicle instanceof HasTurbo){
                ((HasTurbo) vehicle).setTurboOn();
            }
        }
    }

    /** Sets turbo Off for all vehicles
     *
     */
    public void turboOff() {
        for(Vehicle vehicle : application.getVehicles()){
            if(vehicle instanceof HasTurbo){
                ((HasTurbo) vehicle).setTurboOff();
            }
        }
    }
}
