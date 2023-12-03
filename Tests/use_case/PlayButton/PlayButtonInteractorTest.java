package use_case.PlayButton;

import entity.CurrentFloor;
import entity.MapBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.movement.MovementOutputData;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class PlayButtonInteractorTest {
    int numberOfRooms;
    @BeforeEach
    void setup() throws IOException{
        //Generate initial floor (4 by 4 map)
        CurrentFloor floor = new CurrentFloor(4, 4);
        numberOfRooms = floor.getColumns() * floor.getRows();
    }
    @Test
    void canExplore() throws IOException{
        PlayButtonOutputBoundary playButtonOutputBoundary = new PlayButtonOutputBoundary() {
            @Override
            public void prepareSuccessView(MovementOutputData movementOutputData) {
                //Assert if current room has more than 2 directions
                assert movementOutputData.getDirections().length() > 1;
                //Assert that there are 16 rooms (4 rows and 4 columns)
                assertEquals(numberOfRooms, 16);
            }

            @Override
            public void prepareFailView(String error) {
                fail("Fail not expected");
            }
        };
    }
}
