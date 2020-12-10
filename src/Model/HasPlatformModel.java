package Model;
import Vehicle.*;

import javax.swing.*;
import java.util.ArrayList;

public class HasPlatformModel implements VehicleAttribute{
    ArrayList<HasPlatform> hasPlatformList;
    JButton liftBedButton = new JButton("Vehicle.Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JPanel platformPanel = new JPanel();

    /** Raises the platformAngle by 60° for all vehicles */
    public void raisePlatformAngle() {
        for (HasPlatform hasPlatform: hasPlatformList) {
            hasPlatform.raisePlatformAngle(60);
        }
    }

    /** Lowers the platformAngle by 60° for all vehicles */
    public void lowerPlatformAngle() {
        for (HasPlatform hasPlatform: hasPlatformList) {
            hasPlatform.lowerPlatformAngle(60);
        }
    }
}
