package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.UseItems.UseItemsViewModel;

public class PackageView extends JPanel implements ActionListener, PropertyChangeListener{
    private final UseItemsViewModel useItemsViewModel;
    private final JButton useItem;
    private final JButton dropItem;

    public PackageView(UseItemsViewModel useItemsViewModel, JButton dropItem) {

        JPanel buttons = new JPanel();


        this.useItemsViewModel = useItemsViewModel;
        this.useItem = new JButton(useItemsViewModel.USE_ITEM);

        this.dropItem = new JButton(useItemsViewModel.DROP_ITEM);
        buttons.add(useItem);

        useItem.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(useItem)) {


                        }
                    }

                }
        );
        dropItem.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dropItem)) {


                        }
                    }

                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
