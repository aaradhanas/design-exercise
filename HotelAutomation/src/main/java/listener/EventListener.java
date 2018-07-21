package listener;

/**
 * A listener interface to detect movement and no-movement events.
 */

public interface EventListener {
    void onEventDetected(String sensorId, boolean detected);
}
