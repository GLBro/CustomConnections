package project.scenes;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import project.FieldManager;
import project.SceneController;
import project.game.Creator;

import java.util.ArrayList;

public class CreateScene extends Scene {

  private BorderPane root;
  private FieldManager fieldManager;
  private Label errorMsg;
  private Creator creator;

  public CreateScene(Parent parent, double v, double v1) {
    super(parent, v, v1);
    root = (BorderPane) parent;
    fieldManager = new FieldManager();
    creator = new Creator();
    build();
  }

  public void build() {
    root.setStyle("-fx-background-color: lightgrey");
    var back = new BorderPane();
    back.setMaxHeight(root.getHeight() - 50);
    back.setMaxWidth(root.getWidth() - 50);
    back.setStyle("-fx-background-color: white; -fx-background-radius: 30px");
    root.setCenter(back);

    var title = new Label("Connection Creator");
    title.setStyle("-fx-text-fill: black; -fx-font-size: 30px; -fx-font-family: Elephant");
    var topBox = new VBox();
    topBox.getChildren().add(title);
    topBox.setAlignment(Pos.CENTER);
    back.setTop(topBox);

    var fillBox = new VBox(10);
    fillBox.setAlignment(Pos.TOP_CENTER);
    back.setCenter(fillBox);

    var gameBox = new HBox(5);
    gameBox.setAlignment(Pos.CENTER);
    var gameLabel = new Label("Game name: ");
    gameLabel.setStyle("-fx-text-fill: black; -fx-font-family: 'Arial Black'; -fx-font-size: 10px");
    var gameField = new TextField();
    gameField.setMaxWidth(300);
    gameField.setMaxHeight(20);
    fieldManager.addField(gameField);
    gameBox.getChildren().addAll(gameLabel, gameField);
    fillBox.getChildren().add(gameBox);

    var firstCBox = new HBox(5);
    firstCBox.setAlignment(Pos.CENTER);
    var firstName = new Label("Connection1: ");
    firstName.setStyle("-fx-background-color: yellow; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 10px");
    var firstField = new TextField();
    firstField.setMaxWidth(300);
    firstField.setMaxHeight(20);
    fieldManager.addField(firstField);
    firstCBox.getChildren().addAll(firstName, firstField);
    fillBox.getChildren().add(firstCBox);
    var firstIBox = new HBox(5);
    firstIBox.setAlignment(Pos.CENTER);
    var firstItem = new Label("Items: ");
    firstItem.setStyle("-fx-background-color: yellow; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 10px");
    var c1i1 = new TextField();
    c1i1.setMaxWidth(75);
    c1i1.setMaxHeight(20);
    var c1i2 = new TextField();
    c1i2.setMaxWidth(75);
    c1i2.setMaxHeight(20);
    var c1i3 = new TextField();
    c1i3.setMaxWidth(75);
    c1i3.setMaxHeight(20);
    var c1i4 = new TextField();
    c1i4.setMaxWidth(75);
    c1i4.setMaxHeight(20);
    fieldManager.addField(c1i1);
    fieldManager.addField(c1i2);
    fieldManager.addField(c1i3);
    fieldManager.addField(c1i4);
    firstIBox.getChildren().addAll(firstItem, c1i1, c1i2, c1i3, c1i4);
    fillBox.getChildren().add(firstIBox);

    var secondCBox = new HBox(5);
    secondCBox.setAlignment(Pos.CENTER);
    var secondName = new Label("Connection2: ");
    secondName.setStyle("-fx-background-color: green; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 10px");
    var secondField = new TextField();
    secondField.setMaxWidth(300);
    secondField.setMaxHeight(20);
    fieldManager.addField(secondField);
    secondCBox.getChildren().addAll(secondName, secondField);
    fillBox.getChildren().add(secondCBox);
    var secondIBox = new HBox(5);
    secondIBox.setAlignment(Pos.CENTER);
    var secondItem = new Label("Items: ");
    secondItem.setStyle("-fx-background-color: green; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 10px");
    var c2i1 = new TextField();
    c2i1.setMaxWidth(75);
    c2i1.setMaxHeight(20);
    var c2i2 = new TextField();
    c2i2.setMaxWidth(75);
    c2i2.setMaxHeight(20);
    var c2i3 = new TextField();
    c2i3.setMaxWidth(75);
    c2i3.setMaxHeight(20);
    var c2i4 = new TextField();
    c2i4.setMaxWidth(75);
    c2i4.setMaxHeight(20);
    fieldManager.addField(c2i1);
    fieldManager.addField(c2i2);
    fieldManager.addField(c2i3);
    fieldManager.addField(c2i4);
    secondIBox.getChildren().addAll(secondItem, c2i1, c2i2, c2i3, c2i4);
    fillBox.getChildren().add(secondIBox);

    var thirdCBox = new HBox(5);
    thirdCBox.setAlignment(Pos.CENTER);
    var thirdName = new Label("Connection3: ");
    thirdName.setStyle("-fx-background-color: lightblue; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 10px");
    var thirdField = new TextField();
    thirdField.setMaxWidth(300);
    thirdField.setMaxHeight(20);
    fieldManager.addField(thirdField);
    thirdCBox.getChildren().addAll(thirdName, thirdField);
    fillBox.getChildren().add(thirdCBox);
    var thirdIBox = new HBox(5);
    thirdIBox.setAlignment(Pos.CENTER);
    var thirdItem = new Label("Items: ");
    thirdItem.setStyle("-fx-background-color: lightblue; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 10px");
    var c3i1 = new TextField();
    c3i1.setMaxWidth(75);
    c3i1.setMaxHeight(20);
    var c3i2 = new TextField();
    c3i2.setMaxWidth(75);
    c3i2.setMaxHeight(20);
    var c3i3 = new TextField();
    c3i3.setMaxWidth(75);
    c3i3.setMaxHeight(20);
    var c3i4 = new TextField();
    c3i4.setMaxWidth(75);
    c3i4.setMaxHeight(20);
    fieldManager.addField(c3i1);
    fieldManager.addField(c3i2);
    fieldManager.addField(c3i3);
    fieldManager.addField(c3i4);
    thirdIBox.getChildren().addAll(thirdItem, c3i1, c3i2, c3i3, c3i4);
    fillBox.getChildren().add(thirdIBox);

    var fourthCBox = new HBox(5);
    fourthCBox.setAlignment(Pos.CENTER);
    var fourthName = new Label("Connection4: ");
    fourthName.setStyle("-fx-background-color: purple; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 10px");
    var fourthField = new TextField();
    fourthField.setMaxWidth(300);
    fourthField.setMaxHeight(20);
    fieldManager.addField(fourthField);
    fourthCBox.getChildren().addAll(fourthName, fourthField);
    fillBox.getChildren().add(fourthCBox);
    var fourthIBox = new HBox(5);
    fourthIBox.setAlignment(Pos.CENTER);
    var fourthItem = new Label("Items: ");
    fourthItem.setStyle("-fx-background-color: purple; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 10px");
    var c4i1 = new TextField();
    c4i1.setMaxWidth(75);
    c4i1.setMaxHeight(20);
    var c4i2 = new TextField();
    c4i2.setMaxWidth(75);
    c4i2.setMaxHeight(20);
    var c4i3 = new TextField();
    c4i3.setMaxWidth(75);
    c4i3.setMaxHeight(20);
    var c4i4 = new TextField();
    c4i4.setMaxWidth(75);
    c4i4.setMaxHeight(20);
    fieldManager.addField(c4i1);
    fieldManager.addField(c4i2);
    fieldManager.addField(c4i3);
    fieldManager.addField(c4i4);
    fourthIBox.getChildren().addAll(fourthItem, c4i1, c4i2, c4i3, c4i4);
    fillBox.getChildren().add(fourthIBox);

    var createBox = new VBox(20);
    createBox.setAlignment(Pos.CENTER);
    var submitButton = new Button("Create");
    submitButton.setPrefHeight(50);
    submitButton.setPrefWidth(200);
    submitButton.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 20px");
    submitButton.setOnMouseEntered(e -> submitButton.setStyle("-fx-background-color: grey; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: white; -fx-font-size: 20px"));
    submitButton.setOnMouseExited(e -> submitButton.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 20px"));
    var backButton = new Button("Back");
    backButton.setPrefHeight(25);
    backButton.setPrefWidth(100);
    backButton.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 10px");
    backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: grey; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: white; -fx-font-size: 10px"));
    backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 10px"));
    backButton.setOnAction(e -> SceneController.switchToTitle());
    createBox.getChildren().addAll(submitButton, backButton);
    fillBox.getChildren().add(createBox);

    var errorBox = new HBox();
    errorBox.setAlignment(Pos.CENTER);
    errorMsg = new Label("");
    errorMsg.setStyle("-fx-text-fill: red; -fx-font-family: 'Arial Black'; -fx-font-size: 20px");
    errorBox.getChildren().add(errorMsg);
    fillBox.getChildren().add(errorBox);

    submitButton.setOnAction(e -> {
      ArrayList<String> results = fieldManager.getAll();
      String check = creator.checkCreatable(results);
      if (!check.isEmpty()) {
        displayError(check);
      } else {
        creator.saveGame(results);
        fieldManager.resetAll();
        SceneController.switchToTitle();
      }
    });
  }

  public void displayError(String msg) {
    errorMsg.setText(msg);
  }
}
