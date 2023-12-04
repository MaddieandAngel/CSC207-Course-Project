package use_case.movement;

public class MovementOutputData {

    private final String directions;
    private final boolean searchable;

    public MovementOutputData(String directions, boolean searchable){
        this.directions = directions;
        this.searchable = searchable;
    }

    public String getDirections() {
        return directions;
    }
    public boolean isSearchable(){ return searchable;}

}
