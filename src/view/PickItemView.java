package view;

import entity.ActivePlayer;
import entity.BagAndItems.*;
import interface_adapter.DropToPick.DropToPickController;
import interface_adapter.PickUpItem.PickUpItemController;
import interface_adapter.PickUpItem.PickUpItemState;
import interface_adapter.PickUpItem.PickUpItemViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.Random;

public class PickItemView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Pick up item";
    private final PickUpItemViewModel pickUpItemViewModel;
    private final PickUpItemController pickUpItemController;
    private final DropToPickController dropToPickController;
    private final ActivePlayer player;
    private final JButton PickUpItem;
    private final JButton DropAnItem;
    private final JButton Back;
    private final Item item;


    public PickItemView(PickUpItemViewModel pickUpItemViewModel, PickUpItemController pickUpItemController, DropToPickController dropToPickController, ActivePlayer player) {
        this.pickUpItemViewModel = pickUpItemViewModel;
        this.pickUpItemController = pickUpItemController;
        this.dropToPickController = dropToPickController;
        this.player = player;

        PickUpItemState pickUpItemState = pickUpItemViewModel.getState();
        item = pickUpItemState.getItem();
        this.PickUpItem = new JButton(pickUpItemViewModel.PICK);
        this.DropAnItem = new JButton(pickUpItemViewModel.DROP_FROM_BAG);
        this.Back = new JButton(pickUpItemViewModel.BACK);

            JPanel buttons = new JPanel();

            buttons.add(PickUpItem);
            buttons.add(DropAnItem);
            buttons.add(Back);
        //JLabel ItemInfo = new JLabel("You found a " + item.getName() + "! Do you want to pick it up?");
        JLabel Notice = new JLabel("*If your bag is full, you have to drop an item in order to pick up a new one(click Drop From Bag)");
        JLabel title = new JLabel(pickUpItemViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
        //this.add(ItemInfo);
        this.add(Notice);
        DropAnItem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(DropAnItem)){
                            dropToPickController.execute(player);
                        }

                    }
                }
        );
        Back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(Back)){
                            pickUpItemController.back();
                        }

                    }
                }
        );
        PickUpItem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(PickUpItem)){
                            pickUpItemController.execute(player,item);
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
