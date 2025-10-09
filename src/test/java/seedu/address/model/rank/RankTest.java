package seedu.address.model.rank;

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
    }

}
