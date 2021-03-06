//@@author Hailinx
package seedu.address.logic.parser.optionparser;

import static seedu.address.logic.parser.TodoCommandParser.PARSE_EXCEPTION_MESSAGE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.TodoCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Deletes all TodoItem from given person.
 */
public class TodoOptionDeleteAll extends CommandOption<TodoCommand> {

    private final Index index;

    public TodoOptionDeleteAll(String optionArgs, Index index) {
        super(optionArgs);
        this.index = index;
    }

    @Override
    public TodoCommand parse() throws ParseException {
        if (!isValidOptionArgs()) {
            throw new ParseException(PARSE_EXCEPTION_MESSAGE);
        }

        return new TodoCommand(TodoCommand.PREFIX_TODO_DELETE_ALL, index, null, null);
    }

    /**
     * No option parameter for this command.
     */
    @Override
    public boolean isValidOptionArgs() {
        return optionArgs.isEmpty();
    }
}
