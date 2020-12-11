package Vehicle;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    List<EventListeners> listeners = new ArrayList<EventListeners>();

    public void addListener(){}

    public void removeListener(){}

    public void notifyListener(String modelName, double currentSpeed){
        for(EventListeners l : listeners){
            l.update(modelName, currentSpeed);
        }
    }

}
