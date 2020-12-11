package Controller;

import Vehicle.Application;
import Vehicle.Vehicle;

import javax.swing.*;

public class VehicleController extends JFrame {

    Application application = new Application();

    TurboController turboController = new TurboController();
    PlatformController platformController = new PlatformController();

    public JPanel controlPanel = new JPanel();

    public JPanel gasPanel = new JPanel();
    public JSpinner gasSpinner = new JSpinner();
    public int gasAmount = 0;
    public JLabel gasLabel = new JLabel("Amount of gas");

    public JButton gasButton = new JButton("Gas");
    public JButton brakeButton = new JButton("Brake");
    public JButton turboOnButton = turboController.turboOnButton;
    public JButton turboOffButton = turboController.turboOffButton;
    public JButton liftBedButton = platformController.liftBedButton;
    public JButton lowerBedButton = platformController.lowerBedButton;

    public JButton startButton = new JButton("Start all cars");
    public JButton stopButton = new JButton("Stop all cars");


    /** Calls the <P>gas</P> method for each vehicle once
     *
     * Takes a number between 0 and 100
     * @param amount how hard you press the gas
     */
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : application.getVehicles()
        ) {
            vehicle.gas(gas);
        }
    }

    /** Calls the <P>brake</P> method for each vehicle once
     *
     * Takes a number between 0 and 100
     * @param amount how hard you press the brake
     */
    public void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : application.getVehicles()
        ) {
            vehicle.brake(gas);
        }
    }

    /** Calls the <P>startEngine</P> method for each vehicle
     *
     */
    public void startAllVehicles() {
        for (Vehicle vehicle : application.getVehicles()
        ) {
            vehicle.startEngine();
        }
    }

    /** Calls the <P>stopEngine</P> method for each vehicle
     *
     */
    public void stopAllVehicles() {
        for (Vehicle vehicle : application.getVehicles()
        ) {
            vehicle.stopEngine();
        }
    }
}
