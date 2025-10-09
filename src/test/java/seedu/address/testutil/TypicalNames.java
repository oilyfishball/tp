package seedu.address.testutil;

import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;

/**
 * A utility class containing a list of {@code Index} objects to be used in tests.
 */
public class TypicalNames {
    public static final Name NAME_ALICE_PAULINE;
    public static final Name NAME_BENSON_MEIER;
    public static final Name NAME_CARL_KURZ;
    public static final Name NAME_DOES_NOT_EXIST;

    static {
        try {
            NAME_ALICE_PAULINE = ParserUtil.parseName("Alice Pauline");
            NAME_BENSON_MEIER = ParserUtil.parseName("Benson Meier");
            NAME_CARL_KURZ = ParserUtil.parseName("Carl Kurz");
            NAME_DOES_NOT_EXIST = ParserUtil.parseName("Nonexistent Name");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
