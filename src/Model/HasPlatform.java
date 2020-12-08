package Model;

public class HasPlatform implements VehicleAttribute{

    /** Raises the platformAngle by 60° for all vehicles
     *
     */
    public void raisePlatformAngle() {
        for (Vehicle vehicle : vehicles) {
            vehicle.raisePlatformAngle(60);
        }
    }

    /** Lowers the platformAngle by 60° for all vehicles
     *
     */
    public void lowerPlatformAngle() {
        for (Vehicle vehicle : vehicles) {
            vehicle.lowerPlatformAngle(60);
        }
    }
}
