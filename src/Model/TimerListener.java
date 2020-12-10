package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
    private World world;
    public void actionPerformed(ActionEvent e) {
       world.update();
    }
}