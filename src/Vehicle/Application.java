package Vehicle;

import Controller.VehicleController;
import Model.World;
import View.VehicleView;

import java.awt.*;
import java.util.ArrayList;

public class Application {
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public static void main(String[] args) {

        Application app = new Application();


        Volvo240 volvo = new Volvo240(0, 0, 4, 100, 0, Color.red, "Vehicle.Volvo240", 90);
        Saab95 saab95 = new Saab95(0,100,10,100,0, Color.black, "Vehicle.Saab95",90);
        Scania scania = new Scania(0,200,2,300,0,Color.blue,"Vehicle.Scania", 90);

        app.vehicles.add(volvo);
        app.vehicles.add(saab95);
        app.vehicles.add(scania);

        VehicleView view;
        VehicleController vc = new VehicleController();
        World world = new World(app.vehicles);

        view = new VehicleView("CarSim 1.0", vc);


        // Start the timer
        //cc.timer.start();
        world.timer.start();

    }
}
