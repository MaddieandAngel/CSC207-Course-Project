package use_case.DrawButton;

public interface DrawButtonOutputBoundary {

    void prepareSuccessView(DrawButtonOutputData drawButtonOutputData);

    void prepareFailView(String error);
}
