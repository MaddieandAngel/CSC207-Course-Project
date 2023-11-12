package use_case.UseItem;
import entity.BagAndItems.Item;

public class UseItemInputData{
    final Item item;
    public UseItemInputData(Item item){
        this.item = item;

    }
    Item getItem(){return item;}
}
