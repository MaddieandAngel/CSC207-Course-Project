package interface_adapter.TitleScreen;

public class TitleScreenState {
    private String playError = null;
    private String instructionError = null;

    public TitleScreenState(TitleScreenState copy){
        playError = copy.playError;
        instructionError = copy.instructionError;
    }
    public TitleScreenState(){}

    public String getPlayError(){
        return playError;
    }

    public String getInstructionError(){
        return instructionError;
    }

    public void setPlayError(String playError){
        this.playError = playError;
    }

    public void setInstructionError(String instructionError){
        this.instructionError = instructionError;
    }
}
