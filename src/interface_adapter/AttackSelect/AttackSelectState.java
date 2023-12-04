package interface_adapter.AttackSelect;

public class AttackSelectState {

    private String[] playerHand;

    private String card1Image;

    private String card2Image;

    private String card3Image;

    private String card4Image;

    private String card5Image;

    private boolean has1Card;

    private boolean has2Cards;

    private boolean has3Cards;

    private boolean has4Cards;

    private boolean has5Cards;

    AttackSelectState() {}

    public String[] getHand() {
        return this.playerHand;
    }

    public void setPlayerHand(String[] hand) { this.playerHand = hand; }

    public String getCard1Image() { return this.card1Image;}

    public void setCard1Image(String url) { this.card1Image = url;}

    public String getCard2Image() { return this.card2Image;}

    public void setCard2Image(String url) { this.card2Image = url;}

    public String getCard3Image() { return this.card3Image;}

    public void setCard3Image(String url) { this.card3Image = url;}

    public String getCard4Image() { return this.card4Image;}

    public void setCard4Image(String url) { this.card4Image = url;}

    public String getCard5Image() { return this.card5Image;}

    public void setCard5Image(String url) { this.card5Image = url;}

    public boolean getHas1Card() { return this.has1Card;}

    public void setHas1Card(boolean value) { this.has1Card = value;}

    public boolean getHas2Cards() { return this.has2Cards;}

    public void setHas2Cards(boolean value) { this.has2Cards = value;}

    public boolean getHas3Cards() { return this.has3Cards;}

    public void setHas3Cards(boolean value) { this.has3Cards = value;}

    public boolean getHas4Cards() { return this.has4Cards;}

    public void setHas4Cards(boolean value) { this.has4Cards = value;}

    public boolean getHas5Cards() { return this.has5Cards;}

    public void setHas5Cards(boolean value) { this.has5Cards = value;}
}
