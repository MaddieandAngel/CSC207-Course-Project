package use_case.ItemsButton.HealButton;

public interface HealButtonOutputBoundary {

    void prepareSuccessView(HealButtonOutputData healButtonOutputData);

    void prepareFailView(String error);
}
