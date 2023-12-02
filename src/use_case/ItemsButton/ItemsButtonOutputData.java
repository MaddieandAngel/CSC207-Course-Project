package use_case.ItemsButton;

public class ItemsButtonOutputData {

    private int numberOfHeal10;

    private int numberOfHeal20;

    private int numberOfHeal45;

    public ItemsButtonOutputData(int numberOfHeal10, int numberOfHeal20, int numberOfHeal45) {
        this.numberOfHeal10 = numberOfHeal10;
        this.numberOfHeal20 = numberOfHeal20;
        this.numberOfHeal45 = numberOfHeal45;
    }

    public int getNumberOfHeal10() { return this.numberOfHeal10;}

    public int getNumberOfHeal20() { return this.numberOfHeal20;}

    public int getNumberOfHeal45() { return this.numberOfHeal45;}
}
