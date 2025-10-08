package seedu.address.model.appointment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppointmentMessageTest {
    @Test
    public void equals() {
        // Message must be trimmed
        AppointmentMessage msg = new AppointmentMessage("This is the message.");
        AppointmentMessage msgTrimmed = new AppointmentMessage(" This is the message.   ");
        assertTrue(msg.equals(msgTrimmed));
        AppointmentMessage wrongMsg = new AppointmentMessage(" This is not the message.   ");
        assertFalse(msg.equals(wrongMsg));
    }

    @Test
    public void toStringMethod() {
        assertTrue(new AppointmentMessage("   ").toString().equals(""));
        assertTrue(new AppointmentMessage("  XYZ ").toString().equals("XYZ"));
    }
}
