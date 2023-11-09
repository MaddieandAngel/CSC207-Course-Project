package interface_adapter;

import entity.Deck;

import java.io.IOException;

public interface APIAccessInterface {

    public Deck NewDeck(boolean jokers) throws IOException;

    public void Shuffle(Deck deck) throws IOException, RuntimeException;

    public void DrawCard(Deck deck, String pileName) throws IOException, RuntimeException;

    public void CardPlayed(String deckID, String pileName, String cardCode);

    public void AddToPile(String pileName, String card);

    public void MoveDiscardPileToDeck(Deck deck);

    public String GetCardImage(String deckID, String pileName, String cardCode);

    public String GetCardValue(String deckID, String pileName, String cardCode);

    public String GetCardSuit(String deckID, String pileName, String cardCode);
    }
