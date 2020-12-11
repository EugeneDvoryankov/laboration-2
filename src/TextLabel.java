import Observer.Observer;
import Vehicle.Vehicle;

import javax.swing.*;

import static java.lang.System.out;

import java.awt.*;
import java.util.ArrayList;

public class TextLabel extends JLabel  {

    public TextLabel(){
        this.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.setForeground(Color.WHITE);
    }
    public void updateView(Vehicle vehicle) {
        this.setText("Name:" + vehicle.getModelName() + "  Speed: " + vehicle.getCurrentSpeed());
    }
}
