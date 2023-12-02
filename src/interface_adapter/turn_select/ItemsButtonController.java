package interface_adapter.turn_select;

import use_case.ItemsButton.ItemsButtonInputBoundary;

public class ItemsButtonController {

    final ItemsButtonInputBoundary itemsButtonInteractor;

    public ItemsButtonController(ItemsButtonInputBoundary itemsButtonInputBoundary) {
        this.itemsButtonInteractor = itemsButtonInputBoundary;
    }

    public void execute() {
        itemsButtonInteractor.execute();
    }
}
