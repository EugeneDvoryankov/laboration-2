package Controller;

import Vehicle.Application;
import Vehicle.Vehicle;

import javax.swing.*;

public class VehicleController extends JFrame {

        Application application;

        private static final int X = 800;
        private static final int Y = 800;

        JPanel controlPanel = new JPanel();
        JPanel gasPanel = new JPanel();
        JSpinner gasSpinner = new JSpinner();
        int gasAmount = 0;
        JLabel gasLabel = new JLabel("Amount of gas");
        JButton gasButton = new JButton("Gas");
        JButton brakeButton = new JButton("Brake");


        JButton startButton = new JButton("Start all cars");
        JButton stopButton = new JButton("Stop all cars");


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

    /** Adds a Vehicle to List */
    public void addVehicle(){
        for (Vehicle vehicle : application.getVehicles()
        ) {
            application.getVehicles().add(vehicle);
        }
    }

}
