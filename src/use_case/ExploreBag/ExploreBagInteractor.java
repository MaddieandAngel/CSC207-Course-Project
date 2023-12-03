package use_case.ExploreBag;

public class ExploreBagInteractor implements ExploreBagInputBoundary{
    final ExploreBagOutputBoundary exploreBagPresenter;

    public ExploreBagInteractor(ExploreBagOutputBoundary exploreBagPresenter) {
        this.exploreBagPresenter = exploreBagPresenter;
    }

    @Override
    public void execute() {
        exploreBagPresenter.preparePackageView();
    }
}
