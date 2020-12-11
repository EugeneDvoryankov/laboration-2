import Controller.EngineController;
import Controller.GasController;
import Model.Clock;
import Model.World;
import Vehicle.*;

public class Application {


    public static void main(String[] args) {

        Volvo240 volvo = new Volvo240(0, 0, "volvo1");
        Volvo240 volvo2 = new Volvo240(0, 100, "volvo2");
        //   Vehicle volvo1 = VehicleFactory.createVolvo(0,0,"Volvo1",volvoImage);
        GasController gc = new GasController("test");
        EngineController ec = new EngineController("engine");
        //TurboController tc = new TurboController("turbooo");
        //PlatformController pc = new PlatformController("platform");

        CollectionVehicles vehicles = new CollectionVehicles();

        DrawPanel drawPanel = new DrawPanel(800, 560);
        View view = new View("CarSim", drawPanel);
        //TextView textView = new TextView("CarText");

        World world = new World();
        Clock clock = new Clock(world);

        world.addVehicle(volvo);
        world.addVehicle(volvo2);

        world.addListener(drawPanel);

        //gc.addVehicle(volvo);
        //gc.addVehicle(volvo2);

        clock.start();


    }
}
