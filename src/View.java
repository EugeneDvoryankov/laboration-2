

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

        private static final int X = 800;
        private static final int Y = 560;


        //DrawPanel drawPanel = new DrawPanel(X, Y-240);
    DrawPanel drawPanel;


        // Constructor
        public View(String framename, DrawPanel drawPanel){
            this.drawPanel = drawPanel;
            initComponents(framename);
        }

        // Sets everything in place and fits everything

        private void initComponents(String title) {
            this.setTitle(title);
            this.setPreferredSize(new Dimension(X,Y));
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

            this.add(drawPanel);

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
    }

