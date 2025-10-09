package seedu.address.model.rank;

/**
 * Contains each of the valid RankTypes
 *
 */
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
