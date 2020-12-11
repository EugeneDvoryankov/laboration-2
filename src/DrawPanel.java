import Observer.Observer;
import Vehicle.*;

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
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;


    public DrawPanel(int x, int y) {
        initComponents(x, y);
    }

    private void initComponents(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        try {
            // You can remove the "Vehicle.pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Vehicle.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: Vehicle.pics -> MOVE *.jpg to Vehicle.pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(notInUse.DrawPanel.class.getResourceAsStream("pics1/Volvo240.jpg"));
            saabImage = ImageIO.read(notInUse.DrawPanel.class.getResourceAsStream("pics1/Saab95.jpg"));
            scaniaImage = ImageIO.read(notInUse.DrawPanel.class.getResourceAsStream("pics1/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateView(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
        repaint();
    }

    /*
    public void addVehicles(Vehicle v){
        vehicles.add(v);
    }

     */

    public BufferedImage getVehicleImage(Vehicle v) {
        if(v instanceof Volvo240) {
            return volvoImage;
        } else if (v instanceof Saab95) {
            return saabImage;
        } else if(v instanceof Scania) {
            return scaniaImage;
        }
        return null;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(image,x,y, null);
        for (Vehicle v : vehicles) {
            try {
                g.drawImage(getVehicleImage(v), (int) v.getX(), (int) v.getY(), null);
            } catch(NullPointerException e) {
            }
        }
    }

}
