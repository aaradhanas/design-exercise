package controller;

import corridor.MainCorridor;
import corridor.SubCorridor;
import equipment.Equipment;
import equipment.Type;
import hotel.Floor;
import hotel.Hotel;
import org.junit.Test;
import sensor.MovementSensor;
import sensor.Sensor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ControllerTest {

    @Test
    public void testCreateControllerInNightMode(){
        Controller controller = new Controller(Mode.NIGHT);
        assertEquals("true", controller.getMode(), Mode.NIGHT);
    }

    @Test
    public void testCreateControllerInDayMode(){
        Controller controller = new Controller(Mode.DAY);
        assertEquals("true", controller.getMode(), Mode.DAY);
    }

    @Test
    public void testControllerRegistrationToEvents(){
        Controller controller = new Controller(Mode.NIGHT);
        Hotel hotel = new Hotel();
        hotel.setController(controller);

        Floor floor = new Floor(1);
        SubCorridor sc = new SubCorridor(1);
        floor.addCorridor(sc);
        hotel.addFloor(floor);

        Equipment light1 = new Equipment(Type.LIGHT, 5);
        sc.addEquipment(light1);
        Equipment ac1 = new Equipment(Type.AC, 10);
        sc.addEquipment(ac1);

        sc.setSensor(new MovementSensor(floor, sc));

        controller.initializeController(hotel);
        assertTrue(sc.getSensor().getEventListener() instanceof Controller);
    }

    @Test
    public void testCompensatePowerConsumption(){
        Controller controller = new Controller(Mode.NIGHT);
        Hotel hotel = new Hotel();
        hotel.setController(controller);

        Floor floor = new Floor(1);
        MainCorridor mc = new MainCorridor(1);
        floor.addCorridor(mc);
        SubCorridor sc = new SubCorridor(1);
        floor.addCorridor(sc);
        hotel.addFloor(floor);

        Equipment light1 = new Equipment(Type.LIGHT, 5);
        sc.addEquipment(light1);
        Equipment ac1 = new Equipment(Type.AC, 10);
        sc.addEquipment(ac1);

        Equipment light2 = new Equipment(Type.LIGHT, 5);
        mc.addEquipment(light2);
        Equipment ac2 = new Equipment(Type.AC, 10);
        mc.addEquipment(ac2);

        Sensor sensor = new MovementSensor(floor, sc);
        sc.setSensor(sensor);

        controller.initializeController(hotel);

        sc.getSensor().eventDetected(true);
        assertTrue(floor.getPowerConsumption() <= floor.getMaxPowerConsumption());
    }
}
