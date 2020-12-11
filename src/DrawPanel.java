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
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    public DrawPanel(int x, int y) {
        initComponents(x, y);
    }

    public void initComponents(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        try {
            volvoImage = ImageIO.read(notInUse.DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(notInUse.DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(notInUse.DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateView(Vehicle vehicle) {
        //x = (int)vehicle.getX();
        //y = (int)vehicle.getY();
        //image = vehicle.getImage();
        repaint();
    }

    public void addVehicles(Vehicle v){
        vehicles.add(v);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, (int)vehicles.get(0).getX(), (int)vehicles.get(0).getY(), null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, (int)vehicles.get(1).getX(), (int)vehicles.get(1).getY(), null);
        g.drawImage(scaniaImage, (int)vehicles.get(2).getX(), (int)vehicles.get(2).getY(), null);
    }
}
