package interface_adapter.TitleScreen;

import entity.Deck;

import java.io.IOException;

public interface CreateDeckDataAccessInterface {
    Deck NewDeck() throws IOException, RuntimeException;
}
