package interface_adapter;

import entity.Deck;
import entity.DeckInterface;

import java.io.IOException;

public interface APIAccessInterface {

    public DeckInterface NewDeck() throws IOException, RuntimeException;

    public void Shuffle(DeckInterface deck) throws IOException, RuntimeException;

    public void DrawCard(DeckInterface deck, String pileName) throws IOException, RuntimeException;

    public void CardPlayed(String deckID, String pileName, String cardCode) throws IOException, RuntimeException;

    public void AddToPile(String deckID, String pileName, String cardCode) throws IOException, RuntimeException;

    public void MovePileToDeck(DeckInterface deck, String pileName) throws IOException, RuntimeException;

    public String[] GetCardsInPile(DeckInterface deck, String pileName) throws IOException, RuntimeException;

    public String GetCardImage(String cardCode);

    public int GetCardValue(String cardCode);

    public char GetCardSuit(String cardCode);
    }
