package seedu.address.model.rank;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Rank in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidRankName(String)}
 *
 * Modified from Tag class
 */
public class Rank {
    public static final String MESSAGE_CONSTRAINTS = "Rank names should be one of the four: "
            + "stable/vulnerable/urgent/crisis";
    public static final String VALIDATION_REGEX = "stable|vulnerable|urgent|crisis";
    public static final String NO_RANK = "";

    public final String rankName;

    /**
     * Constructs a {@code Rank}.
     *
     * @param rankName A valid rank name.
     */
    public Rank(String rankName) {
        String checkRank = rankName.toLowerCase();
        requireNonNull(checkRank);
        checkArgument(isValidRankName(checkRank), MESSAGE_CONSTRAINTS);
        this.rankName = checkRank;
    }

    /**
     * Returns true if a given string is a valid rank name.
     */
    public static boolean isValidRankName(String test) {
        return test.equals(NO_RANK) || test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Rank)) {
            return false;
        }

        Rank otherRank = (Rank) other;
        return rankName.equals(otherRank.rankName);
    }

    @Override
    public int hashCode() {
        return rankName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return rankName;
    }

}
