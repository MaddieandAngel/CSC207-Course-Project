package interface_adapter.AttackSelect;

import interface_adapter.ViewManagerModel;
import use_case.AttackButton.CardButton.CardButtonOutputBoundary;
import use_case.AttackButton.CardButton.CardButtonOutputData;
import view.in_battle.BattleResultView;

public class CardButtonPresenter implements CardButtonOutputBoundary {

    private final BattleResultViewModel battleResultViewModel;

    private final ViewManagerModel viewManagerModel;

    public CardButtonPresenter(BattleResultView battleResultView, ViewManagerModel viewManagerModel) {
        this.battleResultView = battleResultView;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(CardButtonOutputData cardButtonOutputData) {

        BattleResultState state;
        this.battleResultViewModel.setState(state);
        battleResultViewModel.firePropertyChanged();

        viewManagerModel.firePropertyChanged();
    }


}
