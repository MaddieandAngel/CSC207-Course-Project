package interface_adapter.explore;

public class ExploreState {

    private int playerLevel = 1;
    private int floorLevel = 1;
    private int playerHealth = 15;
    private int roomIndex = 0;

    public ExploreState(){}

    public int getRoomIndex() {
        return roomIndex;
    }
    public void setRoomIndex(int newIndex){
        roomIndex = newIndex;
    }

}
