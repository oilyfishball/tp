package seedu.address.model.appointment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppointmentStatusTest {
    @Test
    public void isValidStatus() {
        assertTrue(AppointmentStatus.isValidStatus("planned"));
        assertTrue(AppointmentStatus.isValidStatus("confirmed"));
        assertTrue(AppointmentStatus.isValidStatus("completed"));
        assertTrue(AppointmentStatus.isValidStatus("cancelled"));
        assertFalse(AppointmentStatus.isValidStatus("others"));
        assertFalse(AppointmentStatus.isValidStatus(""));
    }
}
