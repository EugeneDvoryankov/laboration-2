package Controller;

import Model.World;
import Vehicle.HasTurbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class TurboController {
    ArrayList<HasTurbo> hasTurbos = new ArrayList<>();
    ButtonView buttonView;
    JPanel turboPanel = new JPanel();
    JButton turboOnButton = new JButton("Turbo on");
    JButton turboOffButton = new JButton("Turbo off");
    World world;


    public TurboController(String title, World world){
        this.world = world;
        initComponents(title);
    }

    private void initComponents(String title){
        buttonView = new ButtonView(title);
        turboPanel.setLayout(new GridLayout(2,1));
        turboPanel.add(turboOnButton);
        turboPanel.add(turboOffButton);
        buttonView.add(turboPanel);

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
            }

        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
            }

        });

    }

    private void turboOn() {
    world.turboOn();
    }

    private void turboOff() {
    world.turboOff();
    }

    /*
    private void turboOn() {
        for(HasTurbo h: hasTurbos) {
            h.setTurboOn();
        }
    }

    private void turboOff() {
        for(HasTurbo h: hasTurbos) {
            h.setTurboOff();
        }
    }


    public void addVehicleWithTurbo(HasTurbo h){
        hasTurbos.add(h);
    }

     */
}
