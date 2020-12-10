package Model;

import Vehicle.HasPlatform;
import Vehicle.HasTurbo;
import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class World implements IWorld{

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<HasTurbo> hasTurbo = new ArrayList<>();
    ArrayList<HasPlatform> hasPlatform = new ArrayList<>();
    private DrawPanel drawPanel;
    private final int delay = 50;

    public Timer timer = new Timer(delay, new TimerListener());

    public World(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public World(ArrayList<Vehicle> vehicles, ArrayList<HasTurbo> hasTurbo, ArrayList<HasPlatform> hasPlatform) {
        this.vehicles = vehicles;
        this.hasTurbo = hasTurbo;
        this.hasPlatform = hasPlatform;
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                    vehicle.move();

                    if (isOutOfBoundsDown(vehicle)) {
                        //frame.drawPanel.moveit(x, 500);
                        vehicle.setY(500);
                        vehicle.invertDirection();
                    } else if (isOutOfBoundsUp(vehicle)) {
                        //frame.drawPanel.moveit(x, 0);
                        vehicle.setY(0);
                        vehicle.invertDirection();
                    }

                    if (isOutOfBoundsRight(vehicle)) {
                        //frame.drawPanel.moveit(684, y);
                        vehicle.setX(684);
                        vehicle.invertDirection();
                    } else if (isOutOfBoundsLeft(vehicle)) {
                        //frame.drawPanel.moveit(0, y);
                        vehicle.setX(0);
                        vehicle.invertDirection();
                    }

                    drawPanel.repaint();
            }
        }
    }


    /** Gets the list of vehicles
     *
     * @return the list of Vehicles
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /** Checks whether the x coordinate of a vehicle is less than zero pixels.
     *
     * @param vehicle
     * @return true if the x coordinate of a vehicle is less than zero, otherwise false
     */
    public boolean isOutOfBoundsLeft(Vehicle vehicle) {
        return vehicle.getX() < 0;
    }

    /** Checks whether the x coordinate of a vehicle is greater than 684 pixels.
     *
     * @param vehicle
     * @return true if the x coordinate of a vehicle is greater than 684 pixels, otherwise false
     */
    public boolean isOutOfBoundsRight(Vehicle vehicle) {
        return vehicle.getX() > 684;
    }

    /** Checks whether the y coordinate of a vehicle is less than 0 pixels.
     *
     * @param vehicle
     * @return true if the y coordinate of a vehicle is less than zero, otherwise false
     */
    public boolean isOutOfBoundsUp(Vehicle vehicle) {
        return vehicle.getY() < 0;
    }

    /** Checks whether the y coordinate of a vehicle is greater than 500 pixels.
     *
     * @param vehicle
     * @return true if the y coordinate of a vehicle is greater than 500 pixels, otherwise false
     */
    public boolean isOutOfBoundsDown(Vehicle vehicle) {
        return vehicle.getY() > 500;
    }

    /** Calls the <P>gas</P> method for each vehicle once
     *
     * Takes a number between 0 and 100
     * @param amount how hard you press the gas
     */
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
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
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.brake(gas);
        }
    }

    /** Calls the <P>startEngine</P> method for each vehicle
     *
     */
    public void startAllVehicles() {
        for(Vehicle vehicle: vehicles) {
            vehicle.startEngine();
        }
    }

    /** Calls the <P>stopEngine</P> method for each vehicle
     *
     */
    public void stopAllVehicles() {
        for(Vehicle vehicle: vehicles) {
            vehicle.stopEngine();
        }
    }
}
