package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import seedu.address.testutil.PersonBuilder;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

public class PersonQueryTest {

    @Test
    public void equals() {
        PersonQuery aliceQuery = new PersonQuery();
        PersonQuery bobQuery = new PersonQuery();

        // comparing empty queries -> returns true
        assertTrue(aliceQuery.equals(bobQuery));

        // same values -> returns true
        aliceQuery.setAddress(ALICE.getAddress());
        bobQuery.setAddress(ALICE.getAddress());
        assertTrue(aliceQuery.equals(bobQuery));

        // same object -> returns true
        assertTrue(bobQuery.equals(bobQuery));

        // null -> returns false
        assertFalse(aliceQuery.equals(null));

        // different type -> returns false
        assertFalse(aliceQuery.equals(5));

        // different name -> returns false
        aliceQuery = (new PersonQuery());
        aliceQuery.setName(ALICE.getName());
        bobQuery = new PersonQuery();
        bobQuery.setName(BOB.getName());
        assertFalse(aliceQuery.equals(bobQuery));

        // different phone -> returns false
        aliceQuery = (new PersonQuery());
        aliceQuery.setPhone(ALICE.getPhone());
        bobQuery = new PersonQuery();
        bobQuery.setPhone(BOB.getPhone());
        assertFalse(aliceQuery.equals(bobQuery));

        // different email -> returns false
        aliceQuery = (new PersonQuery());
        aliceQuery.setEmail(ALICE.getEmail());
        bobQuery = new PersonQuery();
        bobQuery.setEmail(BOB.getEmail());
        assertFalse(aliceQuery.equals(bobQuery));

        // different address -> returns false
        aliceQuery = (new PersonQuery());
        aliceQuery.setAddress(ALICE.getAddress());
        bobQuery = new PersonQuery();
        bobQuery.setAddress(BOB.getAddress());
        assertFalse(aliceQuery.equals(bobQuery));

        // different tags -> returns false
        aliceQuery = (new PersonQuery());
        aliceQuery.setTags(ALICE.getTags());
        bobQuery = new PersonQuery();
        bobQuery.setTags(BOB.getTags());
        assertFalse(aliceQuery.equals(bobQuery));
    }
}
