package listener;

/**
 * A listener interface to detect movement and no-movement events.
 */

public interface EventListener {
    //TODO revisit
    void onEventDetected(String sensorId, boolean detected);
}
