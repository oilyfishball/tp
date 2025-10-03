package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.person.Name;

/**
 * Creates an appointment and links it directly to a client (person).
 */
public class LinkAppointmentCommand extends Command {

    public static final String COMMAND_WORD = "link";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Links a new appointment to a client. "
            + "Parameters: "
            + "/n CLIENT_NAME "
            + "/appt DATE [TIME] "
            + "[/len MINUTES] "
            + "[/loc LOCATION] "
            + "[/type TYPE] "
            + "[/note NOTES] "
            + "[/status planned|confirmed|completed|cancelled]\n"
            + "Example: " + COMMAND_WORD + " "
            + "/n Alex Wu "
            + "/appt 12-10-2025 1430 "
            + "/len 90 "
            + "/loc Bukit Merah FSC "
            + "/type home-visit "
            + "/note Bring consent form "
            + "/status planned";

    public static final String MESSAGE_SUCCESS = "New appointment linked: %1$s";

    private final Name clientName;
    private final Appointment appointment;

    public LinkAppointmentCommand(Name clientName, Appointment appointment) {
        requireNonNull(clientName);
        requireNonNull(appointment);
        this.clientName = clientName;
        this.appointment = appointment;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // For now just return a success message (link logic to be implemented in Model later).
        return new CommandResult(String.format(MESSAGE_SUCCESS,
                clientName + " at " + appointment.toString()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof LinkAppointmentCommand)) {
            return false;
        }
        LinkAppointmentCommand otherCmd = (LinkAppointmentCommand) other;
        return clientName.fullName.equalsIgnoreCase(otherCmd.clientName.fullName)
                && appointment.equals(otherCmd.appointment);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("clientName", clientName)
                .add("appointment", appointment)
                .toString();
    }
}
