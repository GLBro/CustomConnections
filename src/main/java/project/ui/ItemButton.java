package project.ui;

import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import project.listeners.DeselectListener;
import project.listeners.FinishListener;
import project.listeners.RemoveListener;
import project.listeners.SelectListener;

public class ItemButton extends Button {

  private String name;

  private boolean selected;

  private static RemoveListener removeListener;

  private static SelectListener selectListener;

  private static DeselectListener deselectListener;

  private static FinishListener finishListener;

  private boolean pressable;

  public ItemButton(String name) {
    this.name = name;
    selected = false;
    pressable = true;
    this.setText(this.name);
    this.setPrefHeight(75);
    this.setPrefWidth(75);
    this.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 7px");
    this.setOnMouseEntered(e -> hoveredOver());
    this.setOnMouseExited(e -> notHoveredOver());
    this.setOnAction(e -> pressed());
  }

  public void hoveredOver() {
    if (selected) {
      this.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: lightgrey; -fx-font-size: 7px");
    } else {
      this.setStyle("-fx-background-color: lightgrey; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 7px");
    }
  }

  public void notHoveredOver() {
    if (selected) {
      this.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 7px");
    } else {
      this.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 7px");
    }
  }

  public void pressed() {
    if (pressable || selected) {
      selected = !selected;
      if (selected) {
        selectListener.select(name);
        this.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: lightgrey; -fx-font-size: 7px");
      } else {
        deselectListener.deselect(name);
        this.setStyle("-fx-background-color: lightgrey; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 7px");
      }
    }
  }


  public boolean checkSelected() {
    return selected;
  }

  public void shake() {
    var rt1 = new RotateTransition(Duration.seconds(0.15), this);
    rt1.setFromAngle(0);
    rt1.setByAngle(-10);
    var rt2 = new RotateTransition(Duration.seconds(0.3), this);
    rt2.setFromAngle(-10);
    rt2.setByAngle(20);
    var rt3 = new RotateTransition(Duration.seconds(0.15), this);
    rt3.setFromAngle(10);
    rt3.setByAngle(-10);
    rt1.setOnFinished(e -> rt2.play());
    rt2.setOnFinished(e -> rt3.play());
    rt1.play();
  }

  public void shrink(String colour) {
    String css = "-fx-background-color: "+colour+"; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 7px";
    this.setStyle(css);
    var st1 = new ScaleTransition(Duration.seconds(0.25), this);
    st1.setByX(0.1);
    st1.setByY(0.1);
    var st2 = new ScaleTransition(Duration.seconds(0.5), this);
    st2.setByX(-1.1);
    st2.setByY(-1.1);
    st1.setOnFinished(e -> st2.play());
    st2.setOnFinished(e -> {
      removeListener.remove(this);
      finishListener.finish();
    });
    st1.play();
  }

  public static void setRemoveListener(RemoveListener listener) {
    removeListener = listener;
  }

  public static void setSelectListener(SelectListener listener) {
    selectListener = listener;
  }

  public static void setDeselectListener(DeselectListener listener) {
    deselectListener = listener;
  }

  public static void setFinishListener(FinishListener listener) {
    finishListener = listener;
  }

  public void setPressable(boolean b) {
    pressable = b;
  }

  public void setSelected(boolean b) {
    selected = b;
    if (!selected) {
      this.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 7px");
    }
  }

  public void setSelectedNoColour(boolean b) {
    selected = b;
  }
}
