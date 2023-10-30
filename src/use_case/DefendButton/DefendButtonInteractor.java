package use_case.DefendButton;

public class DefendButtonInteractor implements  DefendButtonInputBoundary{
    final DefendButtonOutputBoundary defendPresenter;

    public DefendButtonInteractor(DefendButtonOutputBoundary defendPresenter) {
        this.defendPresenter = defendPresenter;
    }

    public void execute(){
        defendPresenter.prepareDefendFailView();
        defendPresenter.prepareDefendSuccessView();
    }
}
