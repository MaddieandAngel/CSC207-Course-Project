package interface_adapter.explore;

import use_case.movement.MovementOutputData;

public class ExploreButtonVisibility {

    private ExploreButtonVisibility(){}

    public static ExploreState setButtonVisibility(ExploreState exploreState, MovementOutputData movementOutputData){

        exploreState.setNorthVisible(movementOutputData.getDirections().contains("N"));
        exploreState.setEastVisible(movementOutputData.getDirections().contains("E"));
        exploreState.setSouthVisible(movementOutputData.getDirections().contains("S"));
        exploreState.setWestVisible(movementOutputData.getDirections().contains("W"));
        exploreState.setSearchVisible(movementOutputData.isSearchable());

        System.out.println(movementOutputData.getDirections()); //TODO: delete later

        return exploreState;
    }
}
