package hotel;

import controller.Controller;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class HotelTest {

    @Test
    public void testCreateHotel() {
        Hotel hotel = new Hotel("Taj");
        assertEquals("true", hotel.getName(), "Taj");
    }

    @Test
    public void testCreateHotelWithController() {
        Hotel hotel = new Hotel("Taj");
        Controller controller = new Controller();
        hotel.setController(controller);

        assertNotNull(hotel.getController());
    }

    @Test
    public void testCreateHotelWithFloor() {
        Hotel hotel = new Hotel("Taj");
        Floor floor1 = new Floor(1);
        hotel.addFloor(floor1);

        assertEquals("true", hotel.getFloors().size(), 1);
    }
}
