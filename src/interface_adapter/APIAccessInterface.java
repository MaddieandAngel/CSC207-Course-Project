package interface_adapter;

import entity.DeckInterface;

import java.io.IOException;

public interface APIAccessInterface {

    void Shuffle() throws IOException, RuntimeException;

    void DrawCard(String pileName) throws IOException, RuntimeException;

    void CardPlayed(String pileName, String cardCode) throws IOException, RuntimeException;

    void AddToPile(String pileName, String cardCode) throws IOException, RuntimeException;

    void MovePileToDeck(String pileName) throws IOException, RuntimeException;

    String[] GetCardsInPile(String pileName) throws IOException, RuntimeException;

    String GetCardImage(String cardCode);

    int GetCardValue(String cardCode);

    char GetCardSuit(String cardCode);

    DeckInterface getDeck();
    }
