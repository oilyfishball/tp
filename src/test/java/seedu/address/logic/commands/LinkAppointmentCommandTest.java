package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalPersons.DENTIST_APPT;
import static seedu.address.testutil.TypicalPersons.MEETING_APPT;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class LinkAppointmentCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        LinkAppointmentCommand aliceMeeting = new LinkAppointmentCommand(
            ALICE.getName(), MEETING_APPT);
        LinkAppointmentCommand bobMeeting = new LinkAppointmentCommand(
            BOB.getName(), DENTIST_APPT);
        // same object -> returns true
        assertTrue(aliceMeeting.equals(aliceMeeting));
        // same values -> returns true
        LinkAppointmentCommand aliceMeetingCopied = new LinkAppointmentCommand(ALICE.getName(),
            MEETING_APPT);
        assertTrue(aliceMeeting.equals(aliceMeetingCopied));
        // different values -> returns false
        assertFalse(aliceMeeting.equals(bobMeeting));
        // null -> returns false
        assertFalse(aliceMeeting.equals(null));
    }

    @Test
    public void toStringMethod() {
        LinkAppointmentCommand linkCommand = new LinkAppointmentCommand(ALICE.getName(),
            MEETING_APPT);
        String expected = LinkAppointmentCommand.class.getCanonicalName()
            + "{clientName=" + ALICE.getName() + ", appointment="
            + MEETING_APPT + "}";
        assertEquals(expected, linkCommand.toString());
    }
}
