package Model;

import Vehicle.Vehicle;

public class GasModel {

    void gas(int amount, Vehicle v) {
        double gas = (double) amount/100;
            v.gas(gas);

    }

    void brake(int amount, Vehicle v) {
        double gas = (double) amount/100;
            v.brake(gas);

    }
}
