package use_case.ReturnToTitleButton;

public class ReturnToTitleInteractor implements ReturnToTitleInputBoundary{
    final ReturnToTitleOutputBoundary returnToTitlePresenter;

    public ReturnToTitleInteractor(ReturnToTitleOutputBoundary returnToTitlePresenter) {
        this.returnToTitlePresenter = returnToTitlePresenter;
    }

    @Override
    public void execute() {
        returnToTitlePresenter.prepareSuccessView();
    }
}
