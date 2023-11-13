package interface_adapter.UseItems;
import use_case.UseItem.UseItemOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class UseItemsPresenter implements UseItemOutputBoundary{
    @Override
    public void prepareSuccessView() {
        JOptionPane.showMessageDialog(null, "successfully used the item");
        //back to package view(maybe).
    }
    @Override
    public void prepareFailView(){
        JOptionPane.showMessageDialog(null, "no item to use");
    }
}
