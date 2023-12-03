package use_case.DropItem;

import use_case.UseItem.UseItemInputData;

public interface DropItemInputBoundary {
    void execute(DropItemInputData dropItemInputData);
    void back();
}
