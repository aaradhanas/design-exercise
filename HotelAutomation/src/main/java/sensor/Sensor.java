package sensor;

import corridor.Corridor;
import hotel.Floor;
import listener.EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Denotes a sensor
 */
public class Sensor {

    /*Format: <FloorNumber>-<CorridorId>-<SensorId>
      Example: 1-SC1-123*/
    private String id;

    private EventListener eventListener;

    public Sensor(Floor floor, Corridor corridor) {
        this.id = generateSensorId(floor, corridor);
    }

    public String getId() {
        return id;
    }

    public EventListener getEventListener() {
        return eventListener;
    }

    public void movementDetected(boolean detected){
        this.notifyMovementDetectedListener(detected);
    }

    /*public void noMovementDetected(){
        this.notifyNoMovementDetectedListener();
    }*/

    //TODO Move these register, unregister, notify methods to an interface and implement here
    public void registerListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public void unregisterMovementDetectedListener(EventListener eventListener){
        this.eventListener = null;
    }

    private void notifyMovementDetectedListener(boolean detected){
        //this.listeners.forEach( listener -> listener.onMovementDetected(this.getId(), detected));
        // TODO Possiblity of null pointer
        eventListener.onEventDetected(this.getId(), detected);
    }

   /* private void notifyNoMovementDetectedListener(){
        this.listeners.forEach( listener -> listener.onNoMovementDetected(this.getId()));
    }*/

    private String generateSensorId(Floor floor, Corridor corridor){
        String id = floor.getNumber()+"-"+corridor.getId();
        Random random = new Random();
        id += "-"+ random.nextInt(1000);;
        return id;
    }
}
