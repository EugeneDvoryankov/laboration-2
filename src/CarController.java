import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(4, 100, 0, Color.red,"Volvo240" ));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.cars.get(0).turnRight(90); //Turns the car right

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                /*
                Assuming each image has x(width) = 100, and y(height) = 60.
                The green frame they're in has the dimensions x = 784 X 560 = y.
                I'm really not sure about these numbers, gotten from trial and error.
                 */

                car.move();
                // int x = (int) Math.round(car.getPosition().getX());
                // int y = (int) Math.round(car.getPosition().getY());
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());


                frame.drawPanel.moveit(x, y);


                if(car.getY() > 500) {
                    frame.drawPanel.moveit(x, 500);
                    car.invertDirection();
                } else if(car.getY() < 0) {
                    frame.drawPanel.moveit(x, 0);
                    car.invertDirection();
                }

                if(car.getX() > 684) {
                    frame.drawPanel.moveit(684, y);
                    car.invertDirection();
                } else if(car.getX() < 0) {
                    frame.drawPanel.moveit(0,y);
                    car.invertDirection();
                }


                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(gas);
        }
    }
}
