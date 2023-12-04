package interface_adapter.ItemSelect;

public class ItemSelectState {

    private int numberOfHeal10;

    private int numberOfHeal20;

    private int numberOfHeal45;

    private String itemError;

    ItemSelectState() {
    }

    public int getNumberOfHeal10() { return this.numberOfHeal10;}

    public void setNumberOfHeal10(int num) { this.numberOfHeal10 = num;}

    public int getNumberOfHeal20() { return this.numberOfHeal20;}

    public void setNumberOfHeal20(int num) { this.numberOfHeal20 = num;}

    public int getNumberOfHeal45() { return this.numberOfHeal45;}

    public void setNumberOfHeal45(int num) { this.numberOfHeal45 = num;}

    public String getItemError() { return this.itemError;}

    public void setItemError(String error) { this.itemError = error;}
}
