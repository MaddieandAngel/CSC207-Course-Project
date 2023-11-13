package entity;

public class CurrentFloorFactory implements FloorFactory{
    @Override
    public Floor create(int num_columns, int num_rows) {
        return new CurrentFloor(num_columns, num_rows);
    }
}
