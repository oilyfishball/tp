package seedu.address.model.rank;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RankTypeTest {

    @Test
    public void isCaseInsensitive() {
        assertTrue(RankType.STABLE.equals(new Rank("stABLe").rankName));
        assertTrue(RankType.CRISIS.equals(new Rank("crIsIs").rankName));
        assertTrue(RankType.URGENT.equals(new Rank("urgenT").rankName));
        assertTrue(RankType.VULNERABLE.equals(new Rank("vUlneraBle").rankName));
    }

    @Test
    public void invalidRankType() {
        assertThrows(IllegalArgumentException.class, () -> Rank.stringToRank("stale"));
        assertThrows(IllegalArgumentException.class, () -> Rank.stringToRank("urgen"));
        assertThrows(IllegalArgumentException.class, () -> Rank.stringToRank("cris"));
        assertThrows(IllegalArgumentException.class, () -> Rank.stringToRank("vul"));

    }
}
