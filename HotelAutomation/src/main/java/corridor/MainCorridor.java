package corridor;

import equipment.Equipment;
import equipment.Priority;
import equipment.Type;
import controller.Mode;

import java.util.List;

/**
 * Denotes a main corridor
 */
public class MainCorridor extends Corridor {

    public MainCorridor(int id){
        super("MC"+id);
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

        if(mode == Mode.NIGHT){
            setNightModeOn();
        }

    }

    /**
     * Sets the priority of equipments in NIGHT mode
     */
    private void setNightModeOn(){
        //All the lights need to be switched on during night mode in main corridor
        getEquipments().stream()
                .filter(equipment -> equipment.getType() == Type.LIGHT)
                .forEach(equipment -> {
                    equipment.switchOn();
                    equipment.setPriority(Priority.HIGH);
                });
    }
}
