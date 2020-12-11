import Controller.EngineController;
import Controller.GasController;
import Vehicle.*;

public class Application {


    public static void main(String[] args) {

        Volvo240 volvo = new Volvo240(0, 0, "volvo1");
        Volvo240 volvo2 = new Volvo240(0,100,"volvo2");
        //   Vehicle volvo1 = VehicleFactory.createVolvo(0,0,"Volvo1",volvoImage);
        GasController gc = new GasController("test");
        EngineController ec = new EngineController("engine");
        //TurboController tc = new TurboController("turbooo");
        //PlatformController pc = new PlatformController("platform");

        DrawPanel drawPanel = new DrawPanel(800, 560);
        View view = new View("CarSim", drawPanel);
        TextView textView = new TextView("CarText");
        Clock clock = new Clock();

        volvo.addListener(drawPanel);
        volvo2.addListener(drawPanel);

        volvo2.addListener(textView);
        volvo.addListener(textView);

        textView.addVehicle(volvo);
        textView.addVehicle(volvo2);

        drawPanel.addVehicles(volvo);
        drawPanel.addVehicles(volvo2);

        gc.addVehicle(volvo);
        gc.addVehicle(volvo2);

        ec.addVehicle(volvo);
        clock.addVehicle(volvo);
        clock.addVehicle(volvo2);
        clock.start();


    }
}
