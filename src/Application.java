import Controller.EngineController;
import Controller.GasController;
import Controller.TurboController;
import Model.Clock;
import Model.World;
import Vehicle.*;

public class Application {


    public static void main(String[] args) {

        Volvo240 volvo = new Volvo240(0, 0, "volvo1");
        Volvo240 volvo2 = new Volvo240(0, 100, "volvo2");
        //   Vehicle volvo1 = VehicleFactory.createVolvo(0,0,"Volvo1",volvoImage);

        //EngineController ec = new EngineController("engine");

        //PlatformController pc = new PlatformController("platform");

        CollectionVehicles vehicles = new CollectionVehicles();

        DrawPanel drawPanel = new DrawPanel(800, 560);
        View view = new View("CarSim", drawPanel);
        TextView textView = new TextView("CarText");

        World world = new World();
        Clock clock = new Clock(world);

        GasController gc = new GasController("test", world);
        TurboController tc = new TurboController("turbooo", world);

        //world.addVehicle(volvo);
        //world.addVehicle(volvo2);


        world.addVehicle(VehicleFactory.createVolvo(0,0,"VOLVO"));
        world.addVehicle(VehicleFactory.createSaab(0,100,"SAAB"));
        world.addVehicle(VehicleFactory.createScania(0,200,"SCANIA"));
        world.addListener(drawPanel);
        world.addListener(textView);

        clock.start();


    }
}
