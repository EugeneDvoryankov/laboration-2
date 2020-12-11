package Controller;

import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EngineController {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ButtonView buttonView;
    JPanel enginePanel = new JPanel();
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");



    public EngineController(String title) {
        initComponents(title);

    }

    private void initComponents(String title) {
        //frame = new JFrame("Controller.EngineController");
        buttonView = new ButtonView(title);

        enginePanel.setLayout(new GridLayout(2,1));
        enginePanel.add(startButton);
        enginePanel.add(stopButton);
        //frame.add(enginePanel);
        buttonView.add(enginePanel);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAllVehicles();
            }

        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAllVehicles();
            }

        });
       /* frame.setLayout(new GridLayout());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        */
    }


    private void startAllVehicles() {
        for(Vehicle v:vehicles) {
            v.startEngine();
        }

    }

    private void stopAllVehicles() {
        for(Vehicle v:vehicles) {
            v.stopEngine();
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }


}
