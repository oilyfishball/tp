package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalPersons.DENTIST_APPT;
import static seedu.address.testutil.TypicalPersons.MEETING_APPT;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.AppointmentDateTime;
import seedu.address.model.appointment.AppointmentFlag;
import seedu.address.model.appointment.AppointmentLength;
import seedu.address.model.appointment.AppointmentLocation;
import seedu.address.model.appointment.AppointmentMessage;
import seedu.address.model.appointment.AppointmentStatus;
import seedu.address.model.appointment.AppointmentType;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.testutil.AppointmentBuilder;
import seedu.address.testutil.PersonBuilder;

/**
 * Failed tests (to be resolved in future versions)
 * Missing tests (Updated at 10/8/2025)
 * time clashes within the same client
 * time clashes between clients
 */
public class LinkAppointmentCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_allFieldsSpecified_success() {
        Person client = new PersonBuilder(ALICE).build();
        AppointmentFlag flag = new AppointmentFlag("c");
        Appointment appt = new AppointmentBuilder()
            .withName(client.getName().toString()).withDateTime("12-10-3099 1430").build();
        LinkAppointmentCommand cmd = new LinkAppointmentCommand(
                flag, client.getName(), appt);
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.addAppointmentWithPerson(appt, client);
        assertCommandSuccess(cmd, model, String.format(
            LinkAppointmentCommand.MESSAGE_SUCCESS, client.getName(),
            Messages.format(appt)), expectedModel);
    }

    @Test
    public void execute_onlyDateTimeSpecified_success() {
        Person client = new PersonBuilder(ALICE).build();
        AppointmentFlag flag = new AppointmentFlag("c");
        Appointment appt = new Appointment(client.getName(),
            new AppointmentDateTime("30-10-2025"), new AppointmentLength(""),
            new AppointmentLocation(""), new AppointmentType(""),
            new AppointmentMessage(""), new AppointmentStatus(AppointmentStatus.PLANNED));
        LinkAppointmentCommand cmd = new LinkAppointmentCommand(
            flag, client.getName(), appt);
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.addAppointmentWithPerson(appt, client);
        assertCommandSuccess(cmd, model, String.format(
            LinkAppointmentCommand.MESSAGE_SUCCESS, client.getName(),
            Messages.format(appt)), expectedModel);
    }

    @Test
    public void execute_notFoundName_failure() {
        AppointmentFlag flag = new AppointmentFlag("c");
        LinkAppointmentCommand cmd = new LinkAppointmentCommand(
            flag, new Name("random name"), MEETING_APPT);
        assertCommandFailure(cmd, model,
            String.format(LinkAppointmentCommand.MESSAGE_NO_SUCH_PERSON, "random name"));
    }

    @Test
    public void execute_clientNotInList_personNotFoundException() {
        Person person = new PersonBuilder().withName("test").build();
        AppointmentFlag flag = new AppointmentFlag("c");
        Appointment appt = new Appointment(
            person.getName(),
            new AppointmentDateTime("26-10-2025 1030"), // different timing
            new AppointmentLength("90"),
            new AppointmentLocation("NTU Library"),
            new AppointmentType("Meeting"),
            new AppointmentMessage("Project discussion"),
            new AppointmentStatus("planned")
        );
        LinkAppointmentCommand cmd = new LinkAppointmentCommand(
            flag, person.getName(), appt);
        assertCommandFailure(cmd, model,
            String.format(LinkAppointmentCommand.MESSAGE_NO_SUCH_PERSON, "test"));
    }

    @Test
    public void execute_duplicateAppointments_duplicateAppointmentException() {
        AppointmentFlag flag = new AppointmentFlag("c");
        Person client = new PersonBuilder(ALICE).build();
        assert !ALICE.getAppointments().isEmpty();
        Appointment firstAliceAppointment = ALICE.getAppointments().get(0);
        LinkAppointmentCommand cmd = new LinkAppointmentCommand(
            flag, client.getName(), firstAliceAppointment);
        assertCommandFailure(cmd, model, LinkAppointmentCommand.MESSAGE_DUPLICATE_APPOINTMENTS);
    }

    @Test
    public void equals() {
        AppointmentFlag flag = new AppointmentFlag("c");
        LinkAppointmentCommand aliceMeeting = new LinkAppointmentCommand(
            flag, ALICE.getName(), MEETING_APPT);
        LinkAppointmentCommand bobMeeting = new LinkAppointmentCommand(
            flag, BOB.getName(), DENTIST_APPT);
        // same object -> returns true
        assertTrue(aliceMeeting.equals(aliceMeeting));
        // same values -> returns true
        LinkAppointmentCommand aliceMeetingCopied = new LinkAppointmentCommand(
            flag, ALICE.getName(), MEETING_APPT);
        assertTrue(aliceMeeting.equals(aliceMeetingCopied));
        // different values -> returns false
        assertFalse(aliceMeeting.equals(bobMeeting));
        // null -> returns false
        assertFalse(aliceMeeting.equals(null));
    }

    @Test
    public void toStringMethod() {
        AppointmentFlag flag = new AppointmentFlag("c");
        LinkAppointmentCommand linkCommand = new LinkAppointmentCommand(
            flag, ALICE.getName(), MEETING_APPT);
        String expected = LinkAppointmentCommand.class.getCanonicalName()
            + "{clientName=" + ALICE.getName() + ", appointment="
            + MEETING_APPT + "}";
        assertEquals(expected, linkCommand.toString());
    }
}
