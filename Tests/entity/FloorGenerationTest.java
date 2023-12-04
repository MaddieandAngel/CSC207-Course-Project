package entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Random;

public class FloorGenerationTest {

    Floor floor;
    ArrayList<Room> map;
    Random randomizer = new Random();
    int columns = -1;

    @BeforeEach
    void createFloor(){
        columns = randomizer.nextInt(4,7);
        int rows = randomizer.nextInt(4,7);

        CurrentFloorFactory currentFloorFactory = new CurrentFloorFactory();
        MapBuilderInterface mapBuilderInterface = new MapBuilder(columns, rows);

        floor = currentFloorFactory.create(columns, rows, mapBuilderInterface);
        map = floor.getMap();
    }

    @Test
    public void testRoomsProperlyConnectedEastWest(){
        createFloor();

        for (int room = 0; room < map.size() - 1; room++){
            assert map.get(room).isHasEast() == map.get(room + 1).isHasWest();
        }
    }

    @Test
    public void testRoomsProperlyConnectedNorthSouth(){
        createFloor();

        for (int room = 0; room < map.size() - columns; room++){
            assert map.get(room).isHasSouth() == map.get(room + columns).isHasNorth();
        }
    }

    @Test
    public void testStairsAssignedToFloor(){
        createFloor();

        int stairsRoomCount = 0;
        int roomCounter = 0;

        while (roomCounter < map.size()){
            if (map.get(roomCounter).isHasStairs()){
                stairsRoomCount++;
            }
            roomCounter++;
        }
        assert stairsRoomCount == 1;
    }

    @Test
    public void testStairsConnectedToStart(){
        createFloor();
        int stairsRoom = -1;

        //Find stairs room
        int roomCounter = 0;
        while (stairsRoom == -1 && roomCounter < map.size()){
            if(map.get(roomCounter).isHasStairs()){
                stairsRoom = roomCounter;
            }
            roomCounter++;
        }
        assert stairsRoom != -1;

        ArrayList<Integer> connectedRooms = getConnectedRooms(map, stairsRoom, new ArrayList<>());
        assert connectedRooms.contains(floor.getCurrentRoom());
    }

    //Private method copied from MapBuilder:
    private ArrayList<Integer> getConnectedRooms(ArrayList<Room> map, int roomToCheck,
                                                 ArrayList<Integer> connectedRooms){
        connectedRooms.add(roomToCheck);
        ArrayList<Integer> neighbours = new ArrayList<>();
        if (map.get(roomToCheck).isHasNorth()){
            neighbours.add(roomToCheck - columns);
        }
        if (map.get(roomToCheck).isHasEast()){
            neighbours.add(roomToCheck + 1);
        }
        if (map.get(roomToCheck).isHasSouth()){
            neighbours.add(roomToCheck + columns);
        }
        if (map.get(roomToCheck).isHasWest()){
            neighbours.add(roomToCheck - 1);
        }

        for (Integer neighbour : neighbours) {
            if (!connectedRooms.contains(neighbour)) {
                connectedRooms.addAll(getConnectedRooms(map, neighbour, connectedRooms));
            }
        }
        return connectedRooms;
    }

}
