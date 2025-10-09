package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Deletes a person identified using it's displayed index from the address book.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the person identified by the name used in the displayed person list.\n"
            + "Parameters: NAME \n"
            + "Example: " + COMMAND_WORD + " John Doe"
            + "Note: The name is case insensitive.";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Deleted Person: %1$s";

    //    TODO: delete line below
    //    private final Index targetIndex;
    private final String targetName;

    // TODO: delete constructor below
//    public DeleteCommand(Index targetIndex) {
//        this.targetIndex = targetIndex;
//    }

    public DeleteCommand(String nameToDelete) {
        this.targetName = nameToDelete;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        // get person from nameQuery - i.e. get person from lastShownList whose name matches nameToDelete
        List<Person> matchedPersons = lastShownList.stream()
                .filter(person -> person.getName().fullName.equalsIgnoreCase(targetName))
                .toList();
        if (matchedPersons.isEmpty()) {
            // TODO: change to MESSAGE_INVALID_PERSON_DISPLAYED_NAME
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        if (matchedPersons.size() > 1) {
            throw new CommandException(Messages.MESSAGE_MULTIPLE_PERSONS_FOUND_NAME);
        }

        Person personToDelete = matchedPersons.get(0);
        // TODO: delete lines below
//        if (targetIndex.getZeroBased() >= lastShownList.size()) {
//            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
//        }

        // TODO: delete line below
//        Person personToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deletePerson(personToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, Messages.format(personToDelete)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteCommand otherDeleteCommand)) {
            return false;
        }

        return targetName.equalsIgnoreCase(otherDeleteCommand.targetName);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetName", targetName)
                .toString();
    }
}
