package interface_adapter.ItemSelect;

import use_case.ItemsButton.HealButton.HealButtonInputBoundary;
import use_case.ItemsButton.HealButton.HealButtonInputData;

import java.io.IOException;

public class HealButtonController {

    HealButtonInputBoundary healButtonInteractor;

    public HealButtonController(HealButtonInputBoundary healButtonInteractor) {
        this.healButtonInteractor = healButtonInteractor;
    }

    public void execute(int itemType) throws IOException {
        HealButtonInputData healButtonInputData = new HealButtonInputData(itemType);
        healButtonInteractor.execute(healButtonInputData);
    }
}
