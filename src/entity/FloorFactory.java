package entity;

public interface FloorFactory {
    Floor create(int columns, int rows, MapBuilderInterface mapBuilder);
}
