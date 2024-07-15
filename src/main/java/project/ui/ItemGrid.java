package project.ui;

import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.Random;

public class ItemGrid extends FlowPane {

  private ArrayList<ItemButton> buttons;

  public ItemGrid(ArrayList<String> contents) {
    buttons = new ArrayList<ItemButton>();
    this.setMaxWidth(320);
    this.setMaxHeight(320);
    this.setHgap(5);
    this.setVgap(5);
    for (int i=0; i<21; i++) {
      if (!(i==0 | i==1 | i==6 | i==11 | i==16)) {
        var button = new ItemButton(contents.get(i));
        buttons.add(button);
      }
    }
    buttons = shuffle(buttons);
    this.getChildren().addAll(buttons);
    ItemButton.setRemoveListener(this::removeItem);
  }


  public ArrayList<ItemButton> shuffle(ArrayList<ItemButton> list) {
    ArrayList<ItemButton> newList = new ArrayList<ItemButton>();
    for (int i=list.size()-1; i>=1; i--) {
      Random random = new Random();
      int randNum = random.nextInt(i);
      newList.add(list.get(randNum));
      list.remove(list.get(randNum));
    }
    newList.add(list.get(0));
    return newList;
  }

  public void randomRefresh() {
    this.getChildren().clear();
    buttons = shuffle(buttons);
    this.getChildren().addAll(buttons);
  }

  public void refresh() {
    this.getChildren().clear();
    this.getChildren().addAll(buttons);
  }

  public void removeItem(ItemButton i) {
    buttons.remove(i);
    this.getChildren().remove(i);
    refresh();
  }

  public ArrayList<ItemButton> getSelected() {
    ArrayList<ItemButton> out = new ArrayList<ItemButton>();
    for (ItemButton button : buttons) {
      if (button.checkSelected()) {
        out.add(button);
      }
    }
    return out;
  }

  public void setAllPressable(boolean b) {
    for (ItemButton button : buttons) {
      button.setPressable(b);
    }
  }

  public void setAllDeselected() {
    for (ItemButton button : buttons) {
      button.setSelected(false);
    }
  }

  public void setAllDeselectedNoColour() {
    for (ItemButton button : buttons) {
      button.setSelectedNoColour(false);
    }
  }

  public boolean checkComplete() {
    if (buttons.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
}
