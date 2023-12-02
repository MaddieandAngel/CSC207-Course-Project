package entity;

public class ActivePlayerFactory implements PlayerFactory{
    @Override
    public Player create() {
        return new ActivePlayer();
    }
}
