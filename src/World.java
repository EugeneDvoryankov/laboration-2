import Observer.Observer;
import Vehicle.Vehicle;

import java.util.ArrayList;

public class World {

    private ArrayList<Vehicle> vehicles= new ArrayList<>();
    //private CollectionVehicles vehicles;
    private ArrayList<Observer> listeners = new ArrayList<>();

    public World(){


    }

    //public World(CollectionVehicles vehicles){
     //   this.vehicles = vehicles;

    //}

    private void startAllVehicles() {
        for(Vehicle v:vehicles) {
            v.startEngine();
        }
    }


    public void notifyView(){
        for(Observer o: listeners) {
            o.updateView(vehicles);
        }
    }

    public void addListener(Observer o){
        listeners.add(o);
    }

    public void removeListener(Observer o) {
        listeners.remove(o);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void createVolvo(){


    }

    public void createSaab(){

    }

    public void createScania(){

    }
    public void updateWorld() {
        for (Vehicle vehicle : vehicles) {
                /*
                Assuming each image has x(width) = 100, and y(height) = 60.
                The green frame they're in has the dimensions x = 784 X 560 = y.
                I'm really not sure about these numbers, gotten from trial and error.
                 */

            vehicle.move();

            if (isOutOfBoundsDown(vehicle)) {
                vehicle.setY(500);
                vehicle.invertDirection();
            } else if (isOutOfBoundsUp(vehicle)) {
                vehicle.setY(0);
                vehicle.invertDirection();
            }

            if (isOutOfBoundsRight(vehicle)) {
                vehicle.setX(684);
                vehicle.invertDirection();
            } else if (isOutOfBoundsLeft(vehicle)) {
                vehicle.setX(0);
                vehicle.invertDirection();
            }
        }
        notifyView();
    }

    private boolean isOutOfBoundsLeft(Vehicle car) {
        return car.getX() < 0;
    }

    private boolean isOutOfBoundsRight(Vehicle car) {
        return car.getX() > 684;
    }

    private boolean isOutOfBoundsUp(Vehicle car) {
        return car.getY() < 0;
    }

    private boolean isOutOfBoundsDown(Vehicle car) {
        return car.getY() > 500;
    }




}
