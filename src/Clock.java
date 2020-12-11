import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Clock {
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());


    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void start() {
        timer.start();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                /*
                Assuming each image has x(width) = 100, and y(height) = 60.
                The green frame they're in has the dimensions x = 784 X 560 = y.
                I'm really not sure about these numbers, gotten from trial and error.
                 */

                vehicle.move();

                if (isOutOfBoundsDown(vehicle)) {
                    vehicle.setY(500);
                    vehicle.invertDirection();
                } else if (isOutOfBoundsUp(vehicle)) {
                    vehicle.setY(0);
                    vehicle.invertDirection();
                }

                if (isOutOfBoundsRight(vehicle)) {
                    vehicle.setX(684);
                    vehicle.invertDirection();
                } else if (isOutOfBoundsLeft(vehicle)) {
                    vehicle.setX(0);
                    vehicle.invertDirection();
                }

            }

        }

        private boolean isOutOfBoundsLeft(Vehicle car) {
            return car.getX() < 0;
        }

        private boolean isOutOfBoundsRight(Vehicle car) {
            return car.getX() > 684;
        }

        private boolean isOutOfBoundsUp(Vehicle car) {
            return car.getY() < 0;
        }

        private boolean isOutOfBoundsDown(Vehicle car) {
            return car.getY() > 500;
        }
    }

}
