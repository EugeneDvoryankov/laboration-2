import Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
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