package Controller;

import Vehicle.HasPlatform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlatformController {
    ArrayList<HasPlatform> hasPlatformList = new ArrayList<>();
    ButtonView buttonView;
    JPanel platformPanel = new JPanel();
    JButton liftBedButton = new JButton("Lift flatbed");
    JButton lowerBedButton = new JButton("Lower flatbed");

    public PlatformController(String title) {
        initComponents(title);
    }

        private void initComponents(String title) {
        buttonView = new ButtonView(title);
        platformPanel.setLayout(new GridLayout(2,1));
        platformPanel.add(liftBedButton);
        platformPanel.add(lowerBedButton);
        buttonView.add(platformPanel);

            liftBedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    liftBed();
                }

            });
            lowerBedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lowerBed();
                }

            });
        }

    private void liftBed() {
        for(HasPlatform p: hasPlatformList) {
            p.raisePlatformAngle(60);
        }
    }

    private void lowerBed() {
        for(HasPlatform p: hasPlatformList) {
            p.lowerPlatformAngle(60);
        }
    }

    public void addVehicleWithPlatform(HasPlatform p) {
        hasPlatformList.add(p);
    }
}
