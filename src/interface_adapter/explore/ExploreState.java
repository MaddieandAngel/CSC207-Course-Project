package interface_adapter.explore;

public class ExploreState {

    private int playerLevel = 1;
    private int floorLevel = 1;
    private int playerHealth = 15;

    private boolean NorthVisible = true;
    private boolean EastVisible = true;
    private boolean SouthVisible = true;
    private boolean WestVisible = true;
    private boolean SearchVisible = true;

    public ExploreState(){}


    public boolean isNorthVisible() {
        return NorthVisible;
    }
    public boolean isEastVisible() {
        return EastVisible;
    }
    public boolean isSouthVisible() {
        return SouthVisible;
    }
    public boolean isWestVisible() {
        return WestVisible;
    }
    public boolean isSearchVisible() {
        return SearchVisible;
    }

    public void setNorthVisible(boolean northVisible) {
        NorthVisible = northVisible;
    }
    public void setEastVisible(boolean eastVisible) {
        EastVisible = eastVisible;
    }
    public void setSouthVisible(boolean southVisible) {
        SouthVisible = southVisible;
    }
    public void setWestVisible(boolean westVisible) {
        WestVisible = westVisible;
    }
    public void setSearchVisible(boolean searchVisible) {
        SearchVisible = searchVisible;
    }
}
