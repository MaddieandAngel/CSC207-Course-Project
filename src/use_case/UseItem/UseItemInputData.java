package use_case.UseItem;
import entity.ActivePlayer;
import entity.BagAndItems.Bag;
import entity.Player;

public class UseItemInputData{
    final int potionType;
    public UseItemInputData(int num){
        this.potionType = num;
    }
   int getPotionType(){return potionType;}
}
