package Model;

import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Clock {
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    private World world;


    public Clock(World world) {
        this.world = world;

    }

    public void start() {
        timer.start();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            world.updateWorld();
        }
    }
}
