package seedu.address.model.appointment;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Name;

/**
 * Represents an Appointment in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Appointment {

    private final Name clientName;
    private final AppointmentDateTime dateTime;
    private final AppointmentLength length;
    private final AppointmentLocation location;
    private final AppointmentType type;
    private final AppointmentNote note;
    private final AppointmentStatus status;

    /**
     * Every field must be present and not null.
     */
    public Appointment(Name clientName,
                       AppointmentDateTime dateTime,
                       AppointmentLength length,
                       AppointmentLocation location,
                       AppointmentType type,
                       AppointmentNote note,
                       AppointmentStatus status) {
        requireAllNonNull(clientName, dateTime, length, location, type, note, status);
        this.clientName = clientName;
        this.dateTime = dateTime;
        this.length = length;
        this.location = location;
        this.type = type;
        this.note = note;
        this.status = status;
    }

    public Name getClientName() {
        return clientName;
    }

    public AppointmentDateTime getDateTime() {
        return dateTime;
    }

    public AppointmentLength getLength() {
        return length;
    }

    public AppointmentLocation getLocation() {
        return location;
    }

    public AppointmentType getType() {
        return type;
    }

    public AppointmentNote getNote() {
        return note;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    /**
     * Returns true if both appointments have the same client and date/time.
     * This defines a weaker notion of equality between two appointments.
     */
    public boolean isSameAppointment(Appointment other) {
        if (other == this) {
            return true;
        }

        return other != null
                && other.getClientName().equals(getClientName())
                && other.getDateTime().equals(getDateTime());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Appointment)) {
            return false;
        }

        Appointment otherAppointment = (Appointment) other;
        return dateTime.equals(otherAppointment.dateTime)
                && length.equals(otherAppointment.length)
                && location.equals(otherAppointment.location)
                && type.equals(otherAppointment.type)
                && note.equals(otherAppointment.note)
                && status.equals(otherAppointment.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, length, location, type, note, status);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("dateTime", dateTime)
                .add("length", length)
                .add("location", location)
                .add("type", type)
                .add("note", note)
                .add("status", status)
                .toString();
    }
}
