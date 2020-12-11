package View;

import Controller.PlatformController;
import Controller.TurboController;
import Controller.VehicleController;
import Model.DrawPanel;
import Vehicle.Application;
import Vehicle.EventListeners;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleView extends JFrame implements EventListeners {
        private static final int X = 800;
        private static final int Y = 800;


        Application app;

        // The controller member
        VehicleController vc;

        TurboController turboController;
        PlatformController platformController;

        DrawPanel drawPanel = new DrawPanel(X, Y-240);

        public VehicleView (String framename, VehicleController vc){
            this.vc = vc;
            initComponents(framename);
        }

        // Sets everything in place and fits everything
        // TODO: Take a good look and make sure you understand how these methods and components work
        private void initComponents(String title) {

            this.setTitle(title);
            this.setPreferredSize(new Dimension(X,Y));
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

            this.add(drawPanel);



            SpinnerModel spinnerModel =
                    new SpinnerNumberModel(0, //initial value
                            0, //min
                            100, //max
                            1);//step
            vc.gasSpinner = new JSpinner(spinnerModel);
            vc.gasSpinner.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    vc.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
                }
            });

            vc.gasPanel.setLayout(new BorderLayout());
            vc.gasPanel.add(vc.gasLabel, BorderLayout.PAGE_START);
            vc.gasPanel.add(vc.gasSpinner, BorderLayout.PAGE_END);

            this.add(vc.gasPanel);

            vc.controlPanel.setLayout(new GridLayout(2,4));

            vc.controlPanel.add(vc.gasButton, 0);
            vc.controlPanel.add(vc.turboOnButton, 1);
            vc.controlPanel.add(vc.liftBedButton, 2);
            vc.controlPanel.add(vc.brakeButton, 3);
            vc.controlPanel.add(vc.turboOffButton, 4);
            vc.controlPanel.add(vc.lowerBedButton, 5);
            vc.controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
            this.add(vc.controlPanel);
            vc.controlPanel.setBackground(Color.CYAN);


            vc.startButton.setBackground(Color.blue);
            vc.startButton.setForeground(Color.green);
            vc.startButton.setPreferredSize(new Dimension(X/5-15,200));
            this.add(vc.startButton);


            vc.stopButton.setBackground(Color.red);
            vc.stopButton.setForeground(Color.black);
            vc.stopButton.setPreferredSize(new Dimension(X/5-15,200));
            this.add(vc.stopButton);

            // This actionListener is for the gas button only
            vc.gasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    vc.gas(vc.gasAmount);
                }

            });
            vc.brakeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    vc.brake(vc.gasAmount);
                }

            });

            vc.turboOnButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    turboController.turboOn();
                }

            });

            vc.turboOffButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    turboController.turboOff();
                }

            });
            vc.liftBedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    platformController.raisePlatformAngle();
                }

            });
            vc.lowerBedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    platformController.lowerPlatformAngle();
                }

            });

            vc.startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    vc.startAllVehicles();
                }

            });
            vc.stopButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    vc.stopAllVehicles();
                }

            });



            //
            // Make the frame pack all it's components by respecting the sizes if possible.
            this.pack();

            // Get the computer screen resolution
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            // Center the frame
            this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
            // Make the frame visible
            this.setVisible(true);
            // Make sure the frame exits when "x" is pressed
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    @Override
    public void update(String modelName, double currentSpeed){
        String s = "<" + modelName + "> : <" + currentSpeed + ">";
    }
}
