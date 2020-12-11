import Observer.Observer;
import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TextView extends JFrame  {
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

    public void addTextLabel(JLabel label){
        textPanel.add(label);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void updateView(Vehicle vehicle){
        textLabel.setText(createString(vehicle));
    }

    public String createString(Vehicle vehicle){
        String s = "<" + vehicle.getModelName() + "> : <" + vehicle.getCurrentSpeed() + ">" + "\n";
        /*
        StringBuilder sb = new StringBuilder();
        for(Vehicle v:vehicles) {
            sb.append("Name: ");
            sb.append(v.getModelName());
            sb.append(" Speed: ");
            sb.append(v.getCurrentSpeed());
            sb.append(System.getProperty("line.separator"));
        }
        */
        return s;
    }
}
