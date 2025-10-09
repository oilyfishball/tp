package seedu.address.model.appointment;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class AppointmentFlag {
    public static final String MESSAGE_CONSTRAINTS =
            "Flag must be either -c for create, -d for delete or -e for edit.";
    public static final String VALIDATION_REGEX = "c|d|e";
    public final String value;

    /**
     * Create an appointment status
     */
    public AppointmentFlag(String flag) {
        requireNonNull(flag);
        String normalized = flag.toLowerCase();
        checkArgument(isValidFlag(normalized), MESSAGE_CONSTRAINTS);
        this.value = normalized;
    }

    private static boolean isValidFlag(String flag) {
        return flag.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof AppointmentFlag) {
            return ((AppointmentFlag) other).value.equals(this.value);
        }
        return false;
    }
}
