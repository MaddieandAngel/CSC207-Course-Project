package view;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.BagAndItems.*;
import entity.Player;
import interface_adapter.DropToPick.DropToPickController;
import interface_adapter.PickUpItem.PickUpItemController;
import interface_adapter.PickUpItem.PickUpItemState;
import interface_adapter.PickUpItem.PickUpItemViewModel;

import javax.swing.*;
import javax.swing.border.Border;
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
    private final Player player;
    private final JButton PickUpItem;
    private final JButton DropAnItem;
    private final JButton Back;
    private Item item;
    private JLabel itemFind;


    public PickItemView(PickUpItemViewModel pickUpItemViewModel, PickUpItemController pickUpItemController, DropToPickController dropToPickController, InBattleDataAccessObject inBattleDataAccessObject) {
        this.pickUpItemViewModel = pickUpItemViewModel;
        this.pickUpItemController = pickUpItemController;
        this.dropToPickController = dropToPickController;
        this.player = inBattleDataAccessObject.getPlayer();


        this.PickUpItem = new JButton(pickUpItemViewModel.PICK);
        this.DropAnItem = new JButton(pickUpItemViewModel.DROP_FROM_BAG);
        this.Back = new JButton(pickUpItemViewModel.BACK);

            JPanel buttons = new JPanel();

            buttons.add(PickUpItem);
            buttons.add(DropAnItem);
            buttons.add(Back);

        JLabel Notice = new JLabel("*If your bag is full, you have to drop an item in order to pick up a new one(click Drop From Bag)");
        JLabel title = new JLabel(pickUpItemViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Color bg = Color.getHSBColor(0, 0, 0.1F);
        this.setBackground(bg);
        buttons.setBackground(bg);
        buttons.setLayout(new GridLayout(3, 1, 0, 5));
        PickUpItem.setBackground(bg);
        DropAnItem.setBackground(bg);
        Back.setBackground(bg);
        Border buttonBorders = BorderFactory.createLineBorder(Color.white, 3);
        PickUpItem.setBorder(buttonBorders);
        DropAnItem.setBorder(buttonBorders);
        Back.setBorder(buttonBorders);

        Color text = Color.getHSBColor(0, 0, 0.9F);
        PickUpItem.setForeground(text);
        DropAnItem.setForeground(text);
        Back.setForeground(text);
        Notice.setForeground(text);
        title.setForeground(text);

        PickUpItem.setFont(new Font("Verdana", Font.PLAIN, 18));
        DropAnItem.setFont(new Font("Verdana", Font.PLAIN, 18));
        Back.setFont(new Font("Verdana", Font.PLAIN, 18));

        this.add(title);
        this.add(buttons);
        this.add(Notice);
        DropAnItem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(DropAnItem)){
                            dropToPickController.execute(inBattleDataAccessObject);
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
                            item = pickUpItemViewModel.getState().getItem();
                            pickUpItemController.execute(inBattleDataAccessObject,item);
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
