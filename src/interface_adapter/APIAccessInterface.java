package interface_adapter;

import entity.Deck;
import entity.DeckInterface;

import java.io.IOException;

public interface APIAccessInterface {

    public void Shuffle() throws IOException, RuntimeException;

    public void DrawCard(String pileName) throws IOException, RuntimeException;

    public void CardPlayed(String pileName, String cardCode) throws IOException, RuntimeException;

    public void AddToPile(String pileName, String cardCode) throws IOException, RuntimeException;

    public void MovePileToDeck(String pileName) throws IOException, RuntimeException;

    public String[] GetCardsInPile(String pileName) throws IOException, RuntimeException;

    public String GetCardImage(String cardCode);

    public int GetCardValue(String cardCode);

    public char GetCardSuit(String cardCode);

    public DeckInterface getDeck();
    }
