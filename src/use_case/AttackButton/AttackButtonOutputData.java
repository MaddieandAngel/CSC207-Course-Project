package use_case.AttackButton;

public class AttackButtonOutputData {

    private String[] hand;

    String card1Image;

    String card2Image;

    String card3Image;

    String card4Image;

    String card5Image;

    public AttackButtonOutputData(String[] hand, String card1Image, String card2Image,
                                  String card3Image, String card4Image, String card5Image) {
        this.hand = hand;
        this.card1Image = card1Image;
        this.card2Image = card2Image;
        this.card3Image = card3Image;
        this.card4Image = card4Image;
        this.card5Image = card5Image;
    }

    public void setHand(String[] newHand) {
        this.hand = newHand;
    }

    public String[] getHand() {
        return this.hand;
    }

    public String getCard1Image() { return this.card1Image;}

    public String getCard2Image() { return this.card2Image;}

    public String getCard3Image() { return this.card3Image;}

    public String getCard4Image() { return this.card4Image;}

    public String getCard5Image() { return this.card5Image;}

}
