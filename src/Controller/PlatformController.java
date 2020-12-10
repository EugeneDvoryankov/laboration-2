package Controller;

import Vehicle.HasPlatform;

import java.util.ArrayList;

public class PlatformController {
    private ArrayList<HasPlatform> hasPlatformList = new ArrayList<>();

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

    /** Adds a Vehicle to List */
    public void addVehicle(){
        for (HasPlatform hasPlatform: hasPlatformList) {
            hasPlatformList.add(hasPlatform);
        }
    }
}
