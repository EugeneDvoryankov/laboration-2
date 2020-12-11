import Observer.Observer;
import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TextView extends JFrame implements Observer {
ArrayList<Vehicle> vehicles = new ArrayList<>();
    JPanel textPanel = new JPanel();
    TextLabel textLabel = new TextLabel();
    public TextView(String title) {
initComponents(title);
    }

    public void initComponents(String title) {

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(textLabel);
        textPanel.setBackground(Color.BLACK);

        this.add(textPanel);
        this.setTitle(title);
        this.setSize(400,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
    public void addTextLabel(JLabel label){
        textPanel.add(label);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void updateView(Vehicle vehicle){
        textLabel.setText(createString(vehicle));
    }

     */

    public void updateView(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
        textLabel.setText(createString());
    }

    public String createString(){

        StringBuilder sb = new StringBuilder();
        for(Vehicle v:vehicles) {
            sb.append("Name: ");
            sb.append(v.getModelName());
            sb.append(" Speed: ");
            sb.append(v.getCurrentSpeed());
            sb.append(" ");
        }
        return sb.toString();
    }
}
