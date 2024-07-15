package project;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import project.scenes.*;

import java.util.ArrayList;

public class SceneController {

  public static Stage stage;

  public static void setStage(Stage s) {
    stage = s;
  }

  public static void switchToTitle() {
    Scene s = new TitleScene(new BorderPane(), 500, 500);
    stage.setScene(s);
    stage.show();
  }

  public static void switchToGame(ArrayList<String> contents) {
    Scene s = new GameScene(new BorderPane(), 500, 500, contents);
    stage.setScene(s);
    stage.show();
  }

  public static void switchToCreate() {
    Scene s = new CreateScene(new BorderPane(), 500, 500);
    stage.setScene(s);
    stage.show();
  }

  public static void switchToChoose(String type) {
    Scene s = new ChooseScene(new BorderPane(), 500, 500, type);
    stage.setScene(s);
    stage.show();
  }

  public static void switchToBonus(ArrayList<String> contents, int score) {
    Scene s = new BonusScene(new BorderPane(), 500, 500, contents, score);
    stage.setScene(s);
    stage.show();
  }

  public static void swtichToScore(int score) {
    Scene s = new ScoreScene(new BorderPane(), 500, 500, score);
    stage.setScene(s);
    stage.show();
  }

  public static void switchToTimer(ArrayList<String> contents) {
    Scene s = new TimerScene(new BorderPane(), 500, 500, contents);
    stage.setScene(s);
    stage.show();
  }
}
