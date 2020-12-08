package Model;
import Vehicle.*;

import java.util.ArrayList;

public class HasTurboModel implements VehicleAttribute{
ArrayList<HasTurbo> hasTurboList;
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

}
