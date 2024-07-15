package project.scenes;

import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.SceneController;
import project.ui.ItemButton;

import java.util.ArrayList;

public class TimerScene extends GameScene{

  private boolean ended;
  public TimerScene(Parent parent, int x, int y, ArrayList<String> contents) {
    super(parent, x, y, contents);
    ended = false;
    topBox.getChildren().clear();
    var title = new Label(this.title);
    title.setStyle("-fx-text-fill: black; -fx-font-size: 30px; -fx-font-family: Elephant");
    topBox.getChildren().add(title);
    game.increaseScore(-20);
    var timer = new Rectangle(300, 20);
    var sT = new ScaleTransition(Duration.seconds(120), timer);
    sT.setByX(-1);
    var fT = new FillTransition(Duration.seconds(120), timer, Color.GAINSBORO, Color.BLACK);
    sT.setOnFinished(e -> {
      ended = true;
      finish();
    });
    topBox.getChildren().add(timer);
    sT.play();
    fT.play();
  }

  @Override
  public void submit() {
    int result = game.checkMatches();
    if (result == 0 || result == 5 || result == 6) {
      for (ItemButton b : grid.getSelected()) {
        b.shake();
      }
    } else if (result == 1) {
      for (ItemButton b : grid.getSelected()) {
        b.shrink("yellow");
      }
      grid.setAllPressable(true);
      grid.setAllDeselectedNoColour();
      game.deselectAll();
      game.increaseScore(25);
    } else if (result == 2) {
      for (ItemButton b : grid.getSelected()) {
        b.shrink("green");
      }
      grid.setAllPressable(true);
      grid.setAllDeselectedNoColour();
      game.deselectAll();
      game.increaseScore(25);
    } else if (result == 3) {
      for (ItemButton b : grid.getSelected()) {
        b.shrink("lightblue");
      }
      grid.setAllPressable(true);
      grid.setAllDeselectedNoColour();
      game.deselectAll();
      game.increaseScore(25);
    } else if (result == 4) {
      for (ItemButton b : grid.getSelected()) {
        b.shrink("purple");
      }
      grid.setAllPressable(true);
      grid.setAllDeselectedNoColour();
      game.deselectAll();
      game.increaseScore(25);
    }
  }

  @Override
  public void finish() {
    if (grid.checkComplete() || ended) {
      SceneController.swtichToScore(game.getScore());
    }
  }
}
