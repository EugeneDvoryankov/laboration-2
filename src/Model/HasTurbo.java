package Model;

public class HasTurbo implements VehicleAttribute{

    /** Sets turbo On for all vehicles
     *
     */
    public void turboOn() {
        for (Vehicle vehicle : vehicles) {
            vehicle.setTurboOn();
        }
    }

    /** Sets turbo Off for all vehicles
     *
     */
    public void turboOff() {
        for (Vehicle vehicle : vehicles) {
            vehicle.setTurboOff();
        }
    }

}
