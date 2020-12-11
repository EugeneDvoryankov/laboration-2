package Model;

import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class World implements IWorld{

    ArrayList<Vehicle> vehicles = new ArrayList<>();

    private final int delay = 50;

    public Timer timer = new Timer(delay, new TimerListener());

    public World(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
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

}
