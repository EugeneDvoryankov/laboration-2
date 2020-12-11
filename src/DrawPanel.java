import Observer.Observer;
import Vehicle.Vehicle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements Observer {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    private int x;
    private int y;
    private BufferedImage image;

    public DrawPanel(int x, int y) {
        initComponents(x, y);
    }

    public void initComponents(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    public void updateView() {
        //x = (int)vehicle.getX();
        //y = (int)vehicle.getY();
        //image = vehicle.getImage();
        repaint();
    }

    public void addVehicles(Vehicle v){
        vehicles.add(v);

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(image,x,y, null);
        for (Vehicle v : vehicles) {
            g.drawImage(v.getImage(), (int) v.getX(), (int) v.getY(), null);
        }
    }
}
