package Controller;

import Model.World;
import Vehicle.Vehicle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GasController {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ButtonView buttonView;
    JPanel gasSpinnerPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    World world;


    public GasController(String title, World world) {
        this.world = world;
        initComponents(title);
    }


    private void initComponents(String title) {
        buttonView = new ButtonView(title);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasSpinnerPanel.setLayout(new BorderLayout());
        gasSpinnerPanel.add(gasLabel, BorderLayout.CENTER);
        gasSpinnerPanel.add(gasSpinner, BorderLayout.PAGE_END);

        buttonView.add(gasSpinnerPanel);
        gasPanel.setLayout(new GridLayout(2, 1));

        gasPanel.add(gasButton, 0);
        gasPanel.add(brakeButton, 1);
        buttonView.add(gasPanel);


        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }

        });
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(gasAmount);
            }

        });

    }

    void gas(int amount) {
        world.gas(amount);
    }

    void brake(int amount) {
        world.brake(amount);
    }

    /*
    void gas(int amount) {
        double gas = (double) amount/100;
        for (Vehicle v : vehicles) {
            v.gas(gas);
        }
    }

    void brake(int amount) {
        double gas = (double) amount/100;
        for (Vehicle v : vehicles) {
            v.brake(gas);
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);


    }

     */
}
