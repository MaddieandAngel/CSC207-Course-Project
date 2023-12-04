package interface_adapter.BagInExplore;

import use_case.ExploreBag.ExploreBagInputBoundary;

public class ExploreBagController {
    final ExploreBagInputBoundary exploreBagInteractor;

    public ExploreBagController(ExploreBagInputBoundary exploreBagInputBoundary) {
        this.exploreBagInteractor = exploreBagInputBoundary;
    }

    public void execute(){
        exploreBagInteractor.execute();
    }
}
