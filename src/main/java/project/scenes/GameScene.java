package project.scenes;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import project.SceneController;
import project.game.Game;
import project.ui.ItemButton;
import project.ui.ItemGrid;

import java.util.ArrayList;

public class GameScene extends Scene {

  protected BorderPane root;
  protected ItemGrid grid;

  protected String title;

  protected Game game;

  protected ArrayList<String> contents;

  protected HBox infoBox;

  protected HBox livesBox;

  protected Label infoLabel;

  protected VBox topBox;

  public GameScene(Parent parent, int x, int y, ArrayList<String> contents) {
    super(parent, x, y);
    root = (BorderPane) parent;
    grid = new ItemGrid(contents);
    title = contents.get(0);
    game = new Game(contents);
    this.contents = contents;
    ItemButton.setSelectListener(this::select);
    ItemButton.setDeselectListener(this::deselect);
    ItemButton.setFinishListener(this::finish);
    build();
  }

  private void build() {
    root.setStyle("-fx-background-color: lightgrey");
    var back = new BorderPane();
    back.setMaxHeight(root.getHeight()-50);
    back.setMaxWidth(root.getWidth()-50);
    back.setStyle("-fx-background-color: white; -fx-background-radius: 30px");
    root.setCenter(back);
    back.setCenter(grid);

    var title = new Label(this.title);
    title.setStyle("-fx-text-fill: black; -fx-font-size: 30px; -fx-font-family: Elephant");
    topBox = new VBox(5);
    topBox.getChildren().add(title);
    topBox.setAlignment(Pos.CENTER);
    infoBox = new HBox(30);
    infoBox.setAlignment(Pos.CENTER);
    livesBox = new HBox(5);
    livesBox.setAlignment(Pos.CENTER);
    displayLives();
    infoLabel = new Label();
    infoLabel.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px");
    infoLabel.setPrefWidth(30);
    infoLabel.setPrefWidth(150);
    infoBox.getChildren().addAll(livesBox, infoLabel);
    topBox.getChildren().add(infoBox);
    back.setTop(topBox);

    var bottomBox = new HBox(50);
    bottomBox.setAlignment(Pos.CENTER);
    var shuffleButton = new Button("Shuffle");
    shuffleButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px");
    shuffleButton.setOnMouseEntered(e -> shuffleButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: lightgrey; -fx-font-size: 10px"));
    shuffleButton.setOnMouseExited(e -> shuffleButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px"));
    shuffleButton.setOnAction(e -> grid.randomRefresh());
    var deselectButton = new Button("Deselect All");
    deselectButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px");
    deselectButton.setOnMouseEntered(e -> deselectButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: lightgrey; -fx-font-size: 10px"));
    deselectButton.setOnMouseExited(e -> deselectButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px"));
    deselectButton.setOnAction(e -> {
      grid.setAllDeselected();
      grid.setAllPressable(true);
      game.deselectAll();
    });
    var submitButton = new Button("Submit");
    submitButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px");
    submitButton.setOnMouseEntered(e -> submitButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: lightgrey; -fx-font-size: 10px"));
    submitButton.setOnMouseExited(e -> submitButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px"));
    submitButton.setOnAction(e -> {
      submitButton.setDisable(true);
      var pt = new PauseTransition(Duration.seconds(1));
      pt.setOnFinished(f -> {
        submitButton.setDisable(false);
        if (game.fail()) {
          SceneController.switchToBonus(contents, game.getScore());
        }
      });
      pt.play();
      submit();
    });
    bottomBox.getChildren().addAll(shuffleButton, deselectButton, submitButton);
    back.setBottom(bottomBox);
  }

  public void select(String s) {
    infoLabel.setText("");
    if (!game.allowSelection()) {
      grid.setAllPressable(false);
    } else {
      grid.setAllPressable(true);
      game.addSelection(s);
      if (!game.allowSelection()) {
        grid.setAllPressable(false);
      }
    }
  }

  public void deselect(String s) {
    infoLabel.setText("");
    game.removeSelection(s);
    grid.setAllPressable(true);
  }

  public void submit() {
    infoLabel.setText("");
    int result = game.checkMatches();
    if (game.getNumSelected() < 4) {
      infoLabel.setText("Please select 4");
    } else if (result == 0) {
      for (ItemButton b : grid.getSelected()) {
        b.shake();
      }
      game.increaseScore(-5);
      game.decreaseLives();
      displayLives();
    } else if (result == 1) {
      for (ItemButton b : grid.getSelected()) {
        b.shrink("yellow");
      }
      grid.setAllPressable(true);
      grid.setAllDeselectedNoColour();
      game.deselectAll();
      game.increaseScore(10);
    } else if (result == 2) {
      for (ItemButton b : grid.getSelected()) {
        b.shrink("green");
      }
      grid.setAllPressable(true);
      grid.setAllDeselectedNoColour();
      game.deselectAll();
      game.increaseScore(10);
    } else if (result == 3) {
      for (ItemButton b : grid.getSelected()) {
        b.shrink("lightblue");
      }
      grid.setAllPressable(true);
      grid.setAllDeselectedNoColour();
      game.deselectAll();
      game.increaseScore(10);
    } else if (result == 4) {
      for (ItemButton b : grid.getSelected()) {
        b.shrink("purple");
      }
      grid.setAllPressable(true);
      grid.setAllDeselectedNoColour();
      game.deselectAll();
      game.increaseScore(10);
    } else if (result == 5) {
      infoLabel.setText("One Away");
      for (ItemButton b : grid.getSelected()) {
        b.shake();
      }
      game.increaseScore(-5);
      game.decreaseLives();
      displayLives();
    } else if (result == 6) {
      infoLabel.setText("Already Guessed");
    }
  }

  public void finish() {
    if (grid.checkComplete()) {
      SceneController.switchToBonus(contents, game.getScore());
    }
  }

  public void displayLives() {
    int l = game.getLives();
    livesBox.getChildren().clear();
    for (int i=0; i<l; i++) {
      var circle = new Circle(10, Color.LIGHTGREY);
      livesBox.getChildren().add(circle);
    }
  }

}
