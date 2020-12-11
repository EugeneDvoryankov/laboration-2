package Model;

import Vehicle.Vehicle;
import Vehicle.HasTurbo;

import java.util.ArrayList;

public class HasTurboModel {
    ArrayList<HasTurbo> hasTurboList = new ArrayList<>();

    public void turboOn(HasTurbo h) {
            h.setTurboOn();
    }

    public void turboOff(HasTurbo h) {
        h.setTurboOff();
    }


    /*
    private void turboOn() {
        for(Saab95 s: saabs) {
            s.setTurboOn();
        }
    }

    private void turboOff() {
        for(Saab95 s: saabs) {
            s.setTurboOff();
        }
    }

     */
}
