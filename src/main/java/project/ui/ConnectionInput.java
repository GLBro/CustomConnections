package project.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ConnectionInput extends VBox {

  private String answer;

  private TextField field;

  private String items;

  public ConnectionInput(String ans, String items, String colour) {
    answer = ans;
    this.items = items;
    this.setMaxWidth(300);
    this.setMaxHeight(75);
    this.setPrefWidth(300);
    this.setPrefHeight(100);
    this.setAlignment(Pos.CENTER);
    String css = "-fx-background-color: "+colour+"; -fx-background-radius: 5px";
    this.setStyle(css);
    field = new TextField();
    field.setMaxWidth(250);
    field .setMaxHeight(50);
    field.setAlignment(Pos.CENTER);
    var label = new Label(items);
    label.setStyle("-fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 10px");
    this.getChildren().addAll(field, label);
  }

  public boolean revealAnswer(boolean b) {
    String css;
    if (b) {
      css = "-fx-font-family: 'Arial Black'; -fx-text-fill: lightgreen; -fx-font-size: 10px";
    } else {
      css = "-fx-font-family: 'Arial Black'; -fx-text-fill: red; -fx-font-size: 10px";
    }
    this.getChildren().clear();
    var ans = new Label(answer);
    ans.setStyle(css);
    var label = new Label(items);
    label.setStyle("-fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 10px");
    this.getChildren().addAll(ans, label);
    if (b) {
      return true;
    } else {
      return false;
    }
  }

  public String getText() {
    return field.getText();
  }
}
