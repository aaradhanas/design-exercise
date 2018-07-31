package corridor;

import equipment.Equipment;
import equipment.Priority;
import equipment.Type;
import controller.Mode;

import java.util.List;

/**
 * Denotes a sub corridor
 */
public class SubCorridor extends Corridor {

    public SubCorridor(int id){
        super("SC"+id);
    }

    /**
     * Sets the default state of equipments based on the mode.
     * @param mode
     */
    @Override
    public void setDefaultState(Mode mode) {
        //By default, all ACs are switched ON, all the time
        getEquipments().stream()
                .filter(equipment -> equipment.getType() == Type.AC)
                .forEach(equipment -> equipment.switchOn());

        if(mode == Mode.NIGHT) {
            setNightModeOn();
        }
    }

    /**
     * Sets the priority of equipments in NIGHT mode
     */
    private void setNightModeOn(){
        getEquipments().stream()
                .filter(equipment -> equipment.getType() == Type.LIGHT)
                .forEach(equipment -> equipment.setPriority(Priority.HIGH));
    }
}
