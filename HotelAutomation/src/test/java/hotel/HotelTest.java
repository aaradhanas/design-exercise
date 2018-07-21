package hotel;

import controller.Controller;
import controller.Mode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HotelTest {

    @Test
    public void testCreateHotel() {
        Hotel hotel = new Hotel("Taj");
        assertEquals("true", hotel.getName(), "Taj");
    }

    @Test
    public void testCreateHotelWithController() {
        Hotel hotel = new Hotel("Taj");
        Controller controller = new Controller(Mode.NIGHT);
        hotel.setController(controller);

        assertEquals("true", hotel.getController().getMode(), Mode.NIGHT);
    }

    @Test
    public void testCreateHotelWithFloor() {
        Hotel hotel = new Hotel("Taj");
        Floor floor1 = new Floor(1);
        hotel.addFloor(floor1);

        assertEquals("true", hotel.getFloors().size(), 1);
    }
}
