package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalOptions.OPTION_ADDRESS;
import static seedu.address.testutil.TypicalOptions.OPTION_EMAIL;
import static seedu.address.testutil.TypicalOptions.OPTION_NAME;
import static seedu.address.testutil.TypicalOptions.OPTION_PHONE;
import static seedu.address.testutil.TypicalOptions.OPTION_TAG;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.exceptions.NoPersonFoundException;

/**
 * Contains integration tests (interaction with the Model) and unit tests for SortCommand.
 */
public class SortCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_sortListByName() throws NoPersonFoundException {
        ModelManager expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.sortPerson(OPTION_NAME);

        SortCommand sortByName = prepareCommand(OPTION_NAME);
        assertCommandSuccess(sortByName, model, SortCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_sortListByPhone() throws NoPersonFoundException {
        ModelManager expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.sortPerson(OPTION_PHONE);

        SortCommand sortByName = prepareCommand(OPTION_PHONE);
        assertCommandSuccess(sortByName, model, SortCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_sortListByEmail() throws NoPersonFoundException {
        ModelManager expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.sortPerson(OPTION_EMAIL);

        SortCommand sortByName = prepareCommand(OPTION_EMAIL);
        assertCommandSuccess(sortByName, model, SortCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_sortListByAddress() throws NoPersonFoundException {
        ModelManager expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.sortPerson(OPTION_ADDRESS);

        SortCommand sortByName = prepareCommand(OPTION_ADDRESS);
        assertCommandSuccess(sortByName, model, SortCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_sortListByTag() throws NoPersonFoundException {
        ModelManager expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.sortPerson(OPTION_TAG);

        SortCommand sortByName = prepareCommand(OPTION_TAG);
        assertCommandSuccess(sortByName, model, SortCommand.MESSAGE_SUCCESS, expectedModel);
    }

    /**
     * Returns a {@code SortCommand} with the parameter {@code option}.
     */
    private SortCommand prepareCommand(String option) {
        SortCommand sortCommand = new SortCommand(option);
        sortCommand.setData(model, new CommandHistory(), new UndoRedoStack());
        return sortCommand;
    }
}