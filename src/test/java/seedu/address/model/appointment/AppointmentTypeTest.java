package seedu.address.model.appointment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppointmentTypeTest {
    @Test
    public void equals() {
        AppointmentType type = new AppointmentType("health");
        // same object -> true
        assertTrue(type.equals(type));
        // same name -> true
        AppointmentType anotherType = new AppointmentType("health");
        assertTrue(type.equals(anotherType));
        // different name -> false
        AppointmentType differentType = new AppointmentType("tech");
        assertFalse(type.equals(differentType));
    }
}
