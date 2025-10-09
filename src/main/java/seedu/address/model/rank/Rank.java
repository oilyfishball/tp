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
    public final RankType rankName;

    /**
     * Constructs a {@code Rank}.
     *
     * @param rankName A valid rank name.
     */
    public Rank(String rankName) {
        requireNonNull(rankName);
        checkArgument(isValidRankName(rankName), MESSAGE_CONSTRAINTS);
        this.rankName = stringToRank(rankName.trim().toLowerCase());
    }

    /**
     * Returns a RankType from a string, ignoring case.
     */
    public static RankType stringToRank(String input) {
        switch (input) {
        case "stable":
            return RankType.STABLE;
        case "vulnerable":
            return RankType.VULNERABLE;
        case "urgent":
            return RankType.URGENT;
        case "crisis":
            return RankType.CRISIS;
        case "":
            return RankType.NONE;
        default:
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
    }

    /**
     * Returns true if a given string is a valid rank name.
     */
    public static boolean isValidRankName(String test) {
        String trimmedTest = test.trim().toLowerCase();
        return trimmedTest.isEmpty()
                || trimmedTest.equals("stable")
                || trimmedTest.equals("vulnerable")
                || trimmedTest.equals("urgent")
                || trimmedTest.equals("crisis");
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
        return rankName.toString();
    }

}
