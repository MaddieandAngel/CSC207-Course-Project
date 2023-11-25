package interface_adapter;

import entity.Deck;

import java.io.IOException;

public interface APIAccessInterface {

    public Deck NewDeck() throws IOException, RuntimeException;

    public void Shuffle(Deck deck) throws IOException, RuntimeException;

    public void DrawCard(Deck deck, String pileName) throws IOException, RuntimeException;

    public void CardPlayed(String deckID, String pileName, String cardCode) throws IOException, RuntimeException;

    public void AddToPile(String deckID, String pileName, String cardCode) throws IOException, RuntimeException;

    public void MovePileToDeck(Deck deck, String pileName) throws IOException, RuntimeException;

    public String[] GetCardsInPile(Deck deck, String pileName) throws IOException, RuntimeException;

    public String GetCardImage(String cardCode);

    public int GetCardValue(String cardCode);

    public char GetCardSuit(String cardCode);
    }
