package equipment;

import controller.Controller;
import controller.Mode;
import corridor.MainCorridor;
import corridor.SubCorridor;
import hotel.Floor;
import hotel.Hotel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class EquipmentTest {
    @Test
    public void testLightActionOn(){
        Equipment light = new Equipment(Type.LIGHT, 5);
        light.switchOn();
        assertEquals("true", light.getState(), State.ON);
    }

    @Test
    public void testLightActionOff(){
        Equipment light = new Equipment(Type.LIGHT, 5);
        light.switchOff();
        assertEquals("true", light.getState(), State.OFF);
    }

    @Test
    public void testACActionOn(){
        Equipment ac = new Equipment(Type.AC, 10);
        ac.switchOn();
        assertEquals("true", ac.getState(), State.ON);
    }

    @Test
    public void testACActionOff(){
        Equipment ac = new Equipment(Type.AC, 10);
        ac.switchOff();
        assertEquals("true", ac.getState(), State.OFF);
    }

    @Test
    public void testMainCorridorLightsInitialState(){
        Controller controller = new Controller(Mode.NIGHT);
        Hotel hotel = new Hotel();
        hotel.setController(controller);

        Floor floor = new Floor(1);
        MainCorridor mc = new MainCorridor(1);
        floor.addCorridor(mc);
        hotel.addFloor(floor);

        Equipment light1 = new Equipment(Type.LIGHT, 5);
        mc.addEquipment(light1);
        Equipment ac1 = new Equipment(Type.AC, 10);
        mc.addEquipment(ac1);

        controller.initializeController(hotel);
        assertTrue(light1.isOn());
    }

    @Test
    public void testCorridorACsInitialState(){
        Controller controller = new Controller(Mode.NIGHT);
        Hotel hotel = new Hotel();
        hotel.setController(controller);

        Floor floor = new Floor(1);
        MainCorridor mc = new MainCorridor(1);
        floor.addCorridor(mc);
        SubCorridor sc = new SubCorridor(1);
        floor.addCorridor(sc);
        hotel.addFloor(floor);

        Equipment ac1 = new Equipment(Type.AC, 10);
        mc.addEquipment(ac1);
        Equipment ac2 = new Equipment(Type.AC, 10);
        sc.addEquipment(ac2);

        controller.initializeController(hotel);
        assertTrue(ac1.isOn() && ac2.isOn());
    }
}
