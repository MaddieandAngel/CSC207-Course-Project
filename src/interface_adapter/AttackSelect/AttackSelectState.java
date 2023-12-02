package interface_adapter.AttackSelect;

public class AttackSelectState {

    private String[] playerHand;

    private String card1Image;

    private String card2Image;

    private String card3Image;

    private String card4Image;

    private String card5Image;

    AttackSelectState() {
    }

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
}
