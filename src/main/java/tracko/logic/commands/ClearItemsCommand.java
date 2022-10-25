package tracko.logic.commands;

import static java.util.Objects.requireNonNull;

import tracko.model.Model;

/**
 * Clears trackO Inventory list.
 */
public class ClearItemsCommand extends Command {

    public static final String COMMAND_WORD = "cleari";
    public static final String MESSAGE_SUCCESS = "TrackO items have been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.clearItemsList();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
