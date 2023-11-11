package interface_adapter.explore;

public class ExploreState {

    private int playerLevel = 1;
    private int floorLevel = 1;
    private int playerCurrentHealth = 15;
    private int playerMaxHealth = 15;

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

    public int getFloorLevel(){ return floorLevel; }
    public int getPlayerLevel() {
        return playerLevel;
    }
    public int getPlayerCurrentHealth() {
        return playerCurrentHealth;
    }
    public int getPlayerMaxHealth() {
        return playerMaxHealth;
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

    public void setFloorLevel(int floorLevel){
        this.floorLevel = floorLevel;
    }
    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }
    public void setPlayerCurrentHealth(int playerCurrentHealth) {
        this.playerCurrentHealth = playerCurrentHealth;
    }
    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }
}
