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
        boolean success = userItemDataAccessObject.useItem(useItemInputData.potionType, useItemInputData.player);
        if (success){
            useItemPresenter.prepareSuccessView();
        }
        else{
        useItemPresenter.prepareFailView();}


    }
}