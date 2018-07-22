package sensor;

import corridor.Corridor;
import hotel.Floor;

/**
 * Created by AAS on 7/12/2018.
 */
public class FireSensor extends Sensor {

    public FireSensor(Floor floor, Corridor corridor){
        super(floor, corridor);
    }

    public void eventDetected(boolean detected){
        this.notifyListener(detected);
    }
}
