package seedu.address.model.appointment;

import java.util.UUID;

public class AppointmentId {
    private final String id;

    public AppointmentId() {
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public AppointmentId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
