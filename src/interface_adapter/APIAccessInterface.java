package interface_adapter;

import entity.Deck;

import java.io.IOException;

public interface APIAccessInterface {

    public Deck NewDeck(boolean jokers) throws IOException;

    public void Shuffle(String deckID);

    public void DrawCard(String deckID, String pileName);

    public void AddToPile(String pileName, String card);

    public String GetCardImage(String deckID, String pileName, String cardCode);

    public String GetCardValue(String deckID, String pileName, String cardCode);

    public String GetCardSuit(String deckID, String pileName, String cardCode);
    }
