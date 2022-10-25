package tracko.logic.commands;

import static java.util.Objects.requireNonNull;

import tracko.model.Model;

/**
 * Clears trackO Order list.
 */
public class ClearOrdersCommand extends Command {

    public static final String COMMAND_WORD = "clearo";
    public static final String MESSAGE_SUCCESS = "TrackO orders have been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.clearOrdersList();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
