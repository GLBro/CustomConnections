package project.scenes;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import project.SceneController;
import project.game.Creator;
import project.ui.GameButton;
import project.ui.TimerButton;

import java.util.ArrayList;

public class ChooseScene extends Scene {

  private BorderPane root;

  private Creator creator;

  private String type;

  public ChooseScene(Parent parent, double v, double v1, String type) {
    super(parent, v, v1);
    root = (BorderPane) parent;
    creator = new Creator();
    this.type = type;
    build();
  }

  private void build() {
    root.setStyle("-fx-background-color: lightgrey");
    var back = new BorderPane();
    back.setMaxHeight(root.getHeight()-50);
    back.setMaxWidth(root.getWidth()-50);
    back.setStyle("-fx-background-color: white; -fx-background-radius: 30px");
    root.setCenter(back);

    var title = new Label("Choose a game");
    title.setStyle("-fx-text-fill: black; -fx-font-size: 30px; -fx-font-family: Elephant");
    var topBox = new VBox();
    topBox.getChildren().add(title);
    topBox.setAlignment(Pos.CENTER);
    back.setTop(topBox);

    var fillBox = new VBox(10);
    fillBox.setAlignment(Pos.CENTER);
    fillBox.setMaxHeight(400);
    fillBox.setMaxWidth(220);

    var scroller = new ScrollPane();
    scroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    scroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    scroller.setContent(fillBox);
    scroller.setMaxHeight(400);
    scroller.setMaxWidth(220);
    back.setCenter(scroller);

    ArrayList<String> names = creator.getGameNames();
    for (String name : names) {
      Button gb;
      if (type == "lives") {
        gb = new GameButton(name);
      } else {
        gb = new TimerButton(name);
      }
      fillBox.getChildren().add(gb);
    }

    var backBox = new HBox();
    backBox.setAlignment(Pos.CENTER);
    var backButton = new Button("Back");
    backButton.setPrefHeight(25);
    backButton.setPrefWidth(100);
    backButton.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 10px");
    backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: grey; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: white; -fx-font-size: 10px"));
    backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 10px"));
    backButton.setOnAction(e -> SceneController.switchToTitle());
    backBox.getChildren().add(backButton);
    back.setBottom(backBox);

    var yr1 = new Rectangle(50,50, Color.YELLOW);
    var gr1 = new Rectangle(50,50, Color.GREEN);
    var br1 = new Rectangle(50,50, Color.LIGHTBLUE);
    var pr1 = new Rectangle(50,50, Color.PURPLE);
    var yr2 = new Rectangle(50,50, Color.YELLOW);
    var gr2 = new Rectangle(50,50, Color.GREEN);
    var br2 = new Rectangle(50,50, Color.LIGHTBLUE);
    var pr2 = new Rectangle(50,50, Color.PURPLE);
    var leftBox = new VBox(2);
    leftBox.setAlignment(Pos.TOP_CENTER);
    leftBox.setMaxWidth(50);
    leftBox.setMaxHeight(210);
    leftBox.getChildren().addAll(yr1, gr1, br1, pr1, yr2, gr2, br2, pr2);
    back.setLeft(leftBox);

    var yr3 = new Rectangle(50,50, Color.YELLOW);
    var gr3 = new Rectangle(50,50, Color.GREEN);
    var br3 = new Rectangle(50,50, Color.LIGHTBLUE);
    var pr3 = new Rectangle(50,50, Color.PURPLE);
    var yr4 = new Rectangle(50,50, Color.YELLOW);
    var gr4 = new Rectangle(50,50, Color.GREEN);
    var br4 = new Rectangle(50,50, Color.LIGHTBLUE);
    var pr4 = new Rectangle(50,50, Color.PURPLE);
    var rightBox = new VBox(2);
    rightBox.setAlignment(Pos.TOP_CENTER);
    rightBox.setMaxWidth(50);
    rightBox.setMaxHeight(210);
    rightBox.getChildren().addAll(yr3, gr3, br3, pr3, yr4, gr4, br4, pr4);
    back.setRight(rightBox);
  }
}
