package tracko.logic.commands;

import static tracko.logic.commands.CommandTestUtil.assertCommandSuccess;
import static tracko.testutil.TypicalOrders.getTrackOWithTypicalOrders;

import org.junit.jupiter.api.Test;

import tracko.model.Model;
import tracko.model.ModelManager;
import tracko.model.UserPrefs;

public class ClearItemsCommandTest {
    @Test
    public void execute_emptyTrackO_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearItemsCommand(), model, ClearItemsCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyTrackO_success() {
        Model model = new ModelManager(getTrackOWithTypicalOrders(), new UserPrefs());
        Model expectedModel = new ModelManager(getTrackOWithTypicalOrders(), new UserPrefs());
        expectedModel.clearItemsList();

        assertCommandSuccess(new ClearItemsCommand(), model, ClearItemsCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
