package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreDataAccessInterface;
import interface_adapter.explore.ExploreViewModel;
import interface_adapter.stairs.*;
import use_case.stairs.*;
import view.StairsView;

public class StairsUseCaseFactory {

    private StairsUseCaseFactory(){}

    public static StairsView create(ViewManagerModel viewManagerModel, ExploreViewModel exploreViewModel,
                                    StairsViewModel stairsViewModel, StairsDataAccessInterface stairsDataAccessObject,
                                    ExploreDataAccessInterface exploreDataAccessObject){

        NextFloorController nextFloorController = createNextFloorUseCase(viewManagerModel, exploreViewModel, stairsDataAccessObject);
        StayOnFloorController stayOnFloorController = createStayOnFloorUseCase(viewManagerModel, exploreViewModel,
                exploreDataAccessObject);

        return new StairsView(nextFloorController, stayOnFloorController, stairsViewModel);
    }

    private static NextFloorController createNextFloorUseCase(ViewManagerModel viewManagerModel, ExploreViewModel exploreViewModel,
                                                              StairsDataAccessInterface stairsDataAccessObject){

        NextFloorOutputBoundary nextFloorOutputBoundary = new NextFloorPresenter(viewManagerModel, exploreViewModel);
        NextFloorInputBoundary nextFloorInteractor = new NextFloorInteractor(stairsDataAccessObject, nextFloorOutputBoundary);

        return new NextFloorController(nextFloorInteractor);
    }
    private static StayOnFloorController createStayOnFloorUseCase(ViewManagerModel viewManagerModel, ExploreViewModel exploreViewModel,
                                                                  ExploreDataAccessInterface exploreDataAccessObject){

        StayOnFloorOutputBoundary stayOnFloorOutputBoundary = new StayOnFloorPresenter(viewManagerModel, exploreViewModel);
        StayOnFloorInputBoundary stayOnFloorInteractor = new StayOnFloorInteractor(exploreDataAccessObject, stayOnFloorOutputBoundary);

        return new StayOnFloorController(stayOnFloorInteractor);
    }
}
