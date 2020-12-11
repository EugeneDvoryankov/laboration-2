import Controller.EngineController;
import Controller.GasController;
import Vehicle.*;

import java.awt.*;
import java.util.ArrayList;

public class Application {

    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {

        Application app = new Application();

        Volvo240 volvo240 = new Volvo240(0, 0, 4, 100, 0, Color.red, "Vehicle.Volvo240", 90);
        Saab95 saab95 = new Saab95(0,100,10,100,0,Color.black, "Vehicle.Saab95",90);
        Scania scania = new Scania(0,200,2,300,0,Color.blue,"Vehicle.Scania", 90);

        app.vehicles.add(volvo240);
        app.vehicles.add(saab95);
        app.vehicles.add(scania);

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
        ec.addVehicle(volvo2);
        clock.addVehicle(volvo);
        clock.addVehicle(volvo2);

        clock.start();


    }
}
