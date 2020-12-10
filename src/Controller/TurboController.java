package Controller;

import Vehicle.Application;
import Vehicle.HasTurbo;

import javax.swing.*;
import java.util.ArrayList;

public class TurboController {
    Application application;

    private ArrayList<HasTurbo> hasTurboList = new ArrayList<>();
    JButton turboOnButton = new JButton("Saab Vehicle.Turbo on");
    JButton turboOffButton = new JButton("Saab Vehicle.Turbo off");
    JPanel turboPanel = new JPanel();

    /** Sets turbo On for all vehicles
     *
     */
    public void turboOn() {
        for (HasTurbo hasTurboModel : hasTurboList ) {
            hasTurboModel.setTurboOn();
        }
    }

    /** Sets turbo Off for all vehicles
     *
     */
    public void turboOff() {
        for (HasTurbo hasTurboModel : hasTurboList ) {
            hasTurboModel.setTurboOff();
        }
    }

    /** Adds a Vehicle to List */
    public void addVehicle(){
        for (HasTurbo hasTurboModel : hasTurboList ) {
            hasTurboList.add(hasTurboModel);
        }
    }

}
