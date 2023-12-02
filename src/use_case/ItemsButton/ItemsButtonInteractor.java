package use_case.ItemsButton;

public class ItemsButtonInteractor implements ItemsButtonInputBoundary {

    final ItemsButtonOutputBoundary itemsButtonPresenter;

    final ItemsButtonDataAccessInterface itemsButtonDataAccessInterface;

    public ItemsButtonInteractor(ItemsButtonOutputBoundary itemsButtonPresenter, ItemsButtonDataAccessInterface itemsButtonDataAccessInterface) {
        this.itemsButtonPresenter = itemsButtonPresenter;
        this.itemsButtonDataAccessInterface = itemsButtonDataAccessInterface;
    }

    @Override
    public void execute() {
        int numberOfHeal10 = itemsButtonDataAccessInterface.getPlayer().getBag().numOfHeal10();
        int numberOfHeal20 = itemsButtonDataAccessInterface.getPlayer().getBag().numOfHeal20();
        int numberOfHeal45 = itemsButtonDataAccessInterface.getPlayer().getBag().numOfHeal45();

        ItemsButtonOutputData itemsButtonOutputData = new ItemsButtonOutputData(numberOfHeal10, numberOfHeal20, numberOfHeal45);

        itemsButtonPresenter.prepareSuccessView(itemsButtonOutputData);
    }
}
