package entity.BagAndItems;

import entity.ActivePlayer;

import java.util.ArrayList;
import java.util.Objects;

public class Package implements Bag {
    private final ArrayList<Item> heal10;
    private final ArrayList<Item> heal20;
    private final ArrayList<Item> heal45;
    private final ArrayList<Item> revive;
    private int MaxItems;
    private int level;
    public Package(){
        this.heal10 = new ArrayList<>();
        this.heal20 = new ArrayList<>();
        this.heal45 = new ArrayList<>();
        this.revive = new ArrayList<>();
        this.MaxItems = 5;
        this.level = 0;
    }
    @Override
    public boolean isFull(){
        return numOfItemsTotal() >= MaxItems;
    }
    @Override
    public boolean addItem(Item newItem){
        if (isFull()){
            return false;
        }
        else if (Objects.equals(newItem.getName(), "HealingPotion(10%)")){
            heal10.add(newItem);
            return true;
        }
        else if (Objects.equals(newItem.getName(), "HealingPotion(20%)")){
            heal20.add(newItem);
            return true;
        }
        else if (Objects.equals(newItem.getName(), "HealingPotion(45%)")){
            heal45.add(newItem);
            return true;
        }
        revive.add(newItem);
        return true;
    }
    @Override
    public void levelUpBag(){
        level = level + 1;
        MaxItems = MaxItems + 2;
    }
    @Override
    public boolean useItem(int ItemType, ActivePlayer player){
        if (ItemType == 10){
            if (heal10.isEmpty()){
                return false;
            }
            Item item = heal10.get(0);
            dropItem(10);
            item.heal(player);
            return true;
        }
        else if (ItemType == 20){
            if (heal20.isEmpty()){
                return false;
            }
            Item item = heal20.get(0);
            dropItem(20);
            item.heal(player);
            return true;
        }
        if (heal45.isEmpty()){
            return false;
        }
        Item item = heal45.get(0);
        dropItem(45);
        item.heal(player);
        return true;
        }


    @Override
    public boolean dropItem(int potionType){
        if (potionType == 10){
            if (heal10.isEmpty()){
                return false;
            }
            heal10.remove(0);
            return true;
        }
        else if (potionType == 20){
            if (heal20.isEmpty()){
                return false;
            }
            heal20.remove(0);
            return true;
        }
        else if (potionType == 45){
            if (heal45.isEmpty()){
                return false;
            }
            heal45.remove(0);
            return true;
        }
        if (revive.isEmpty()){
            return false;
        }
        revive.remove(0);
        return true;
    }
    @Override
    public int numOfItemsTotal(){
        return heal10.size()+heal20.size()+heal45.size()+revive.size();
    }

    @Override
    public int numOfHeal10() {
        return heal10.size();
    }

    @Override
    public int numOfHeal20() {
        return heal20.size();
    }

    @Override
    public int numOfHeal45() {
        return heal45.size();
    }

    @Override
    public int numOfRevive() {
        return revive.size();
    }
}
