package seedu.address.model.rank;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

//Adapted from TagTest class
public class RankTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Rank(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidRankName = "high";
        assertThrows(IllegalArgumentException.class, () -> new Rank(invalidRankName));
    }

    @Test
    public void isValidRankName() {
        // null rank name
        assertThrows(NullPointerException.class, () -> Rank.isValidRankName(null));
        assertTrue(RankType.NONE.equals(new Rank("").rankName));
        assertTrue(RankType.NONE.equals(new Rank("    ").rankName));
    }

    @Test
    public void isCaseInsensitive() {
        assertTrue(Rank.isValidRankName("cRiSis"));
        assertTrue(Rank.isValidRankName("StaBLe"));
        assertTrue(Rank.isValidRankName("vuLNerabLE"));
        assertTrue(Rank.isValidRankName("UrgeNT"));
    }
}
