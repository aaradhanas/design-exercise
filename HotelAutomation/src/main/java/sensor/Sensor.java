package sensor;

import corridor.Corridor;
import hotel.Floor;
import listener.EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Denotes a sensor
 */
public abstract class Sensor {

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

    public abstract void eventDetected(boolean detected);

    //TODO Move these register, unregister, notify methods to an interface and implement here
    public void registerListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public void unregisterListener(){
        this.eventListener = null;
    }

    protected void notifyListener(boolean detected){
        Optional.of(eventListener)
                .ifPresent( eventListener -> eventListener.onEventDetected(this.getId(), detected));
    }

    private String generateSensorId(Floor floor, Corridor corridor){
        String id = floor.getNumber()+"-"+corridor.getId();
        Random random = new Random();
        id += "-"+ random.nextInt(1000);;
        return id;
    }
}
