package Controller;

import javax.swing.*;
import java.awt.*;

public class ButtonView extends JFrame {

    public ButtonView(String title){
        this.setTitle(title);
        this.setSize(400,200);
        this.setLayout(new GridLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
