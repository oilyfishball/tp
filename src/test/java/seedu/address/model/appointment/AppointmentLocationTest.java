package seedu.address.model.appointment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppointmentLocationTest {
    @Test
    public void isValidLocation() {
        // Empty location -> true
        assertTrue(AppointmentLocation.isValidLocation(""));
        // Location name must not contain special characters (e.g. <>)
        assertFalse(AppointmentLocation.isValidLocation("Tiong Bahru <Market>"));
        // Typical locations
        assertTrue(AppointmentLocation.isValidLocation("123 Main St., #04-56"));
    }

    @Test
    public void equals() {
        AppointmentLocation first = new AppointmentLocation("123 Main St.");
        AppointmentLocation second = new AppointmentLocation("St. 123 Main ");
        AppointmentLocation third = new AppointmentLocation("123 Main St.");
        assertTrue(first.equals(first));
        assertTrue(first.equals(third));
        assertFalse(second.equals(third));
    }

    @Test
    public void toStringMethod() {
        AppointmentLocation first = new AppointmentLocation("");
        AppointmentLocation second = new AppointmentLocation("123 Main St.");
        assertTrue(first.toString().equals(""));
        assertTrue(second.toString().equals("123 Main St."));
    }
}
