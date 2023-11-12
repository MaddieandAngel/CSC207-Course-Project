package use_case.UseItem;

public class UseItemInputData implements UseItemInputBoundary{
    final UseItemOutputBoundary useItemPresenter;
    public UseItemInputData(UseItemOutputBoundary useItemPresenter){
        this.useItemPresenter = useItemPresenter;
    }
    @Override
    public void execute(){

    }
}
