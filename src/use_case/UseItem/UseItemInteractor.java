package use_case.UseItem;

public class UseItemInteractor implements UseItemInputBoundary{
    final UseItemDataAccessInterface userItemDataAccessObject;
    final UseItemOutputBoundary useItemPresenter;

    public UseItemInteractor(UseItemDataAccessInterface userItemDataAccessObject, UseItemOutputBoundary useItemPresenter) {
        this.userItemDataAccessObject = userItemDataAccessObject;
        this.useItemPresenter = useItemPresenter;
    }

    @Override
    public void execute(UseItemInputData useItemInputData) {
        userItemDataAccessObject.useItem(useItemInputData.item, useItemInputData.bag, useItemInputData.player);
        useItemPresenter.prepareSuccessView();

    }
}
