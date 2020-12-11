package Observer;

import Vehicle.Vehicle;

import java.util.ArrayList;

public interface Observer {
   //void updateView(Vehicle vehicle);
   void updateView(ArrayList<Vehicle> vehicles);
}
