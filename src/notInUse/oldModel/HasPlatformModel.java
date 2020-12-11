package notInUse.oldModel;
import Vehicle.*;
import java.util.ArrayList;

public class HasPlatformModel implements VehicleAttribute{
    ArrayList<HasPlatform> hasPlatformList;

    /** Raises the platformAngle by 60° for all vehicles
     *
     */
    public void raisePlatformAngle() {
        for (HasPlatform hasPlatform: hasPlatformList) {
            hasPlatform.raisePlatformAngle(60);
        }
    }

    /** Lowers the platformAngle by 60° for all vehicles
     *
     */
    public void lowerPlatformAngle() {
        for (HasPlatform hasPlatform: hasPlatformList) {
            hasPlatform.lowerPlatformAngle(60);
        }
    }
}
