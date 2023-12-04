package use_case.PlayButton;

import data_access.APIAccess;
import data_access.ExploreDataAccessObject;
import entity.*;
import interface_adapter.APIAccessInterface;
import interface_adapter.stairs.StairsDataAccessInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.DefendButton.DefendButtonInputBoundary;
import use_case.DefendButton.DefendButtonInteractor;
import use_case.movement.MovementOutputData;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayButtonInteractorTest {
    StairsDataAccessInterface dataAccessObject;
    int numberOfRooms;
    String directions;

    APIAccessInterface api;
    @BeforeEach
    void setup() throws IOException{
        api = new APIAccess();
        dataAccessObject = new ExploreDataAccessObject(new CurrentFloorFactory(), new MapBuilderFactory());
        //Generate initial floor (4 by 4 map)
        CurrentFloor floor = new CurrentFloor(4, 4, null, 0);
        numberOfRooms = floor.getColumns() * floor.getRows();
        directions = dataAccessObject.MoveToNextFloor(4,4);
    }
    @Test
    void canExplore() throws IOException{
        PlayButtonOutputBoundary playButtonOutputBoundary = new PlayButtonOutputBoundary() {
            @Override
            public void prepareSuccessView(MovementOutputData movementOutputData) {
                //Assert if current room has more than 2 directions
                assert directions.length() > 1;
                //Assert that there are 16 rooms (4 rows and 4 columns)
                assertEquals(numberOfRooms, 16);
            }

        };
        PlayButtonInputBoundary interactor = new PlayButtonInteractor(playButtonOutputBoundary, dataAccessObject, api);
        interactor.execute();
    }
}
