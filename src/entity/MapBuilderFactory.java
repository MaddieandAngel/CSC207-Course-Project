package entity;

public class MapBuilderFactory implements MapBuilderInterfaceFactory{
    @Override
    public MapBuilderInterface create(int columns, int rows) {
        return new MapBuilder(columns, rows);
    }
}
