package project.scenes;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import project.SceneController;

public class ScoreScene extends Scene {

  private BorderPane root;

  private int score;
  public ScoreScene(Parent parent, double v, double v1, int score) {
    super(parent, v, v1);
    root = (BorderPane) parent;
    this.score = score;
    build();
  }

  public void build() {
    root.setStyle("-fx-background-color: lightgrey");
    var back = new BorderPane();
    back.setMaxHeight(root.getHeight()-50);
    back.setMaxWidth(root.getWidth()-50);
    back.setStyle("-fx-background-color: white; -fx-background-radius: 30px");
    root.setCenter(back);

    var title = new Label("Results");
    title.setStyle("-fx-text-fill: black; -fx-font-size: 30px; -fx-font-family: Elephant");
    var topBox = new VBox();
    topBox.getChildren().add(title);
    topBox.setAlignment(Pos.CENTER);
    back.setTop(topBox);
    var scoreLabel = new Label(Integer.toString(score)+"%");
    scoreLabel.setPrefWidth(500);
    scoreLabel.setStyle("-fx-font-family: Elephant; -fx-font-size: 140px; -fx-text-fill: black");
    var scoreBox = new VBox();
    scoreBox.setAlignment(Pos.CENTER);
    scoreBox.getChildren().add(scoreLabel);
    back.setCenter(scoreBox);
    var endButton = new Button("Back to Title");
    endButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px");
    endButton.setOnMouseEntered(e -> endButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: lightgrey; -fx-font-size: 10px"));
    endButton.setOnMouseExited(e -> endButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px"));
    endButton.setOnAction(e -> SceneController.switchToTitle());
    var bottomBox = new HBox();
    bottomBox.setAlignment(Pos.CENTER);
    bottomBox.getChildren().add(endButton);
    back.setBottom(bottomBox);
  }
}
