package project.scenes;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.SceneController;

public class TitleScene extends Scene {

  private BorderPane root;
  public TitleScene(Parent parent, int x, int y) {
    super(parent, x, y);
    root = (BorderPane) parent;
    build();
  }

  private void build() {
    root.setStyle("-fx-background-color: lightgrey");
    var back = new BorderPane();
    back.setMaxHeight(root.getHeight()-50);
    back.setMaxWidth(root.getWidth()-50);
    back.setStyle("-fx-background-color: white; -fx-background-radius: 30px");
    root.setCenter(back);

    var title1 = new Label("Custom");
    title1.setStyle("-fx-text-fill: black; -fx-font-size: 30px; -fx-font-family: Elephant");
    var title2 = new Label("Connections");
    title2.setStyle("-fx-text-fill: black; -fx-font-size: 30px; -fx-font-family: Elephant");
    var topBox = new VBox();
    topBox.getChildren().addAll(title1, title2);
    topBox.setAlignment(Pos.CENTER);
    back.setTop(topBox);

    var buttonBox = new VBox(10);
    buttonBox.setAlignment(Pos.CENTER);
    var playButton = new Button("Play Game");
    playButton.setStyle("-fx-background-color: yellow; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 20px");
    playButton.setOnMouseEntered(e -> playButton.setStyle("-fx-background-color: grey; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: white; -fx-font-size: 20px"));
    playButton.setOnMouseExited(e -> playButton.setStyle("-fx-background-color: yellow; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 20px"));
    playButton.setOnAction(e -> SceneController.switchToChoose("lives"));
    playButton.setPrefHeight(75);
    playButton.setPrefWidth(200);
    var timeButton = new Button("Timed Game");
    timeButton.setStyle("-fx-background-color: green; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 20px");
    timeButton.setOnMouseEntered(e -> timeButton.setStyle("-fx-background-color: grey; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: white; -fx-font-size: 20px"));
    timeButton.setOnMouseExited(e -> timeButton.setStyle("-fx-background-color: green; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 20px"));
    timeButton.setOnAction(e -> SceneController.switchToChoose("timer"));
    timeButton.setPrefHeight(75);
    timeButton.setPrefWidth(200);
    var createButton = new Button("Create Game");
    createButton.setStyle("-fx-background-color: lightblue; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 20px");
    createButton.setOnMouseEntered(e -> createButton.setStyle("-fx-background-color: grey; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: white; -fx-font-size: 20px"));
    createButton.setOnMouseExited(e -> createButton.setStyle("-fx-background-color: lightblue; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 20px"));
    createButton.setOnAction(e -> SceneController.switchToCreate());
    createButton.setPrefHeight(75);
    createButton.setPrefWidth(200);
    var quitButton = new Button("Quit Game");
    quitButton.setStyle("-fx-background-color: purple; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 20px");
    quitButton.setOnMouseEntered(e -> quitButton.setStyle("-fx-background-color: grey; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: white; -fx-font-size: 20px"));
    quitButton.setOnMouseExited(e -> quitButton.setStyle("-fx-background-color: purple; -fx-background-radius: 5px; -fx-font-family: Elephant; -fx-text-fill: black; -fx-font-size: 20px"));
    quitButton.setOnAction(e -> System.exit(0));
    quitButton.setPrefHeight(75);
    quitButton.setPrefWidth(200);
    buttonBox.getChildren().addAll(playButton, timeButton, createButton, quitButton);
    back.setCenter(buttonBox);

    var yr1 = new Rectangle(50,50, Color.YELLOW);
    var gr1 = new Rectangle(50,50, Color.GREEN);
    var br1 = new Rectangle(50,50, Color.LIGHTBLUE);
    var pr1 = new Rectangle(50,50, Color.PURPLE);
    var leftBox = new VBox(2);
    leftBox.setAlignment(Pos.TOP_CENTER);
    leftBox.setMaxWidth(50);
    leftBox.setMaxHeight(210);
    leftBox.getChildren().addAll(yr1, gr1, br1, pr1);
    back.setLeft(leftBox);
    var leftMove = new TranslateTransition(Duration.seconds(5), leftBox);
    leftMove.setFromY(-50);
    leftMove.setToY(150);
    leftMove.setCycleCount(2);
    leftMove.setAutoReverse(true);
    leftMove.setOnFinished(e -> leftMove.play());
    leftMove.play();

    var yr2 = new Rectangle(50,50, Color.YELLOW);
    var gr2 = new Rectangle(50,50, Color.GREEN);
    var br2 = new Rectangle(50,50, Color.LIGHTBLUE);
    var pr2 = new Rectangle(50,50, Color.PURPLE);
    var rightBox = new VBox(2);
    rightBox.setAlignment(Pos.TOP_CENTER);
    rightBox.setMaxWidth(50);
    rightBox.setMaxHeight(210);
    rightBox.getChildren().addAll(yr2, gr2, br2, pr2);
    back.setRight(rightBox);
    var rightMove = new TranslateTransition(Duration.seconds(5), rightBox);
    rightMove.setFromY(-50);
    rightMove.setToY(150);
    rightMove.setCycleCount(2);
    rightMove.setAutoReverse(true);
    rightMove.setOnFinished(e -> rightMove.play());
    rightMove.play();
  }


}
