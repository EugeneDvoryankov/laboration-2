package notInUse.oldModel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Vehicle.*;
import java.util.List;
import java.awt.*;
/**This panel represent the animated part of the view with the car images.
*/
public class DrawPanel extends JPanel {

    private IWorld world; // interface for world
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());



    List<Vehicle> vehicles;

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a singel cars position



    // TODO: Make this genereal for all cars



    // Initializes the panel and reads the images
    //notInUse.DrawPanel List<Vehicle<
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "Vehicle.pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: Vehicle.pics -> MOVE *.jpg to Vehicle.pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Vehicle/pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Vehicle/pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Vehicle/pics/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }




    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, (int)vehicles.get(0).getX(), (int)vehicles.get(0).getY(), null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, (int)vehicles.get(1).getX(), (int)vehicles.get(1).getY(), null);
        g.drawImage(scaniaImage, (int)vehicles.get(2).getX(), (int)vehicles.get(2).getY(), null);
    }
}
