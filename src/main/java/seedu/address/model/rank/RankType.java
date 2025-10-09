package seedu.address.model.rank;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.rank.Rank.MESSAGE_CONSTRAINTS;

import seedu.address.logic.parser.exceptions.ParseException;

public enum RankType {
    STABLE,
    VULNERABLE,
    URGENT,
    CRISIS,
    NONE;

    @Override
    public String toString() {
        return this == NONE ? "" : name().toLowerCase();
    }
}
