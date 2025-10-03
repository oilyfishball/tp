package seedu.address.model.appointment;

import static java.util.Objects.requireNonNull;

/**
 * Represents notes attached to an appointment.
 */
public class AppointmentNote {

    public static final String NO_NOTE = "";

    public final String value;

    public AppointmentNote(String note) {
        requireNonNull(note);
        this.value = note.trim();
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof AppointmentNote
                && value.equals(((AppointmentNote) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public String toString() {
        return value.isEmpty() ? "none" : value;
    }
}
