package Model;
import Vehicle.*;
import Model.*;

import java.util.ArrayList;
import java.util.List;

public class World implements IWorld{
    private ArrayList<Vehicle> vehicles;

    public World(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /** Updates the drawPanel based on vehicles movement
     * Assuming each image has x(width) = 100, and y(height) = 60.
     * The green frame they're in has the dimensions x = 684 X 500 = y.
     *
     */
    public void update(){
        for (Vehicle vehicle : vehicles) {
                /*
                Assuming each image has x(width) = 100, and y(height) = 60.
                The green frame they're in has the dimensions x = 784 X 560 = y.
                I'm really not sure about these numbers, gotten from trial and error.
                 */

            vehicle.move();
            // int x = (int) Math.round(vehicle.getX());
            //int y = (int) Math.round(vehicle.getY());


            //frame.drawPanel.moveit(x, y);


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


            // repaint() calls the paintComponent method of the panel
            //world.update();
            frame.drawPanel.repaint();
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
    private boolean isOutOfBoundsLeft(Vehicle vehicle) {
        return vehicle.getX() < 0;
    }

    /** Checks whether the x coordinate of a vehicle is greater than 684 pixels.
     *
     * @param vehicle
     * @return true if the x coordinate of a vehicle is greater than 684 pixels, otherwise false
     */
    private boolean isOutOfBoundsRight(Vehicle vehicle) {
        return vehicle.getX() > 684;
    }

    /** Checks whether the y coordinate of a vehicle is less than 0 pixels.
     *
     * @param vehicle
     * @return true if the y coordinate of a vehicle is less than zero, otherwise false
     */
    private boolean isOutOfBoundsUp(Vehicle vehicle) {
        return vehicle.getY() < 0;
    }

    /** Checks whether the y coordinate of a vehicle is greater than 500 pixels.
     *
     * @param vehicle
     * @return true if the y coordinate of a vehicle is greater than 500 pixels, otherwise false
     */
    private boolean isOutOfBoundsDown(Vehicle vehicle) {
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
    void brake(int amount) {
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
