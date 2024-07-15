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
import project.ui.ConnectionInput;

import java.util.ArrayList;

public class BonusScene extends Scene {

  private BorderPane root;

  private String name1;
  private String name2;
  private String name3;
  private String name4;

  private String c1;
  private String c2;
  private String c3;
  private String c4;

  private ConnectionInput box1;
  private ConnectionInput box2;
  private ConnectionInput box3;
  private ConnectionInput box4;

  private HBox bottomBox;

  private int score;


  public BonusScene(Parent parent, double v, double v1, ArrayList<String> contents, int score) {
    super(parent, v, v1);
    this.score = score;
    root = (BorderPane) parent;
    name1 = contents.get(1);
    name2 = contents.get(6);
    name3 = contents.get(11);
    name4 = contents.get(16);
    c1 = contents.get(2)+","+contents.get(3)+","+contents.get(4)+","+contents.get(5);
    c2 = contents.get(7)+","+contents.get(8)+","+contents.get(9)+","+contents.get(10);
    c3 = contents.get(12)+","+contents.get(13)+","+contents.get(14)+","+contents.get(15);
    c4 = contents.get(17)+","+contents.get(18)+","+contents.get(19)+","+contents.get(20);
    build();
  }

  private void build() {
    root.setStyle("-fx-background-color: lightgrey");
    var back = new BorderPane();
    back.setMaxHeight(root.getHeight() - 50);
    back.setMaxWidth(root.getWidth() - 50);
    back.setStyle("-fx-background-color: white; -fx-background-radius: 30px");
    root.setCenter(back);

    var title = new Label("Give the connections");
    title.setStyle("-fx-text-fill: black; -fx-font-size: 30px; -fx-font-family: Elephant");
    var topBox = new VBox();
    topBox.getChildren().add(title);
    topBox.setAlignment(Pos.CENTER);
    back.setTop(topBox);

    var fillBox = new VBox(10);
    fillBox.setAlignment(Pos.CENTER);
    box1 = new ConnectionInput(name1, c1, "yellow");
    box2 = new ConnectionInput(name2, c2, "green");
    box3 = new ConnectionInput(name3, c3, "lightblue");
    box4 = new ConnectionInput(name4, c4, "purple");
    fillBox.getChildren().addAll(box1, box2, box3, box4);
    back.setCenter(fillBox);

    bottomBox = new HBox(50);
    bottomBox.setAlignment(Pos.CENTER);
    var submitButton = new Button("Submit");
    submitButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px");
    submitButton.setOnMouseEntered(e -> submitButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: lightgrey; -fx-font-size: 10px"));
    submitButton.setOnMouseExited(e -> submitButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px"));
    submitButton.setOnAction(e -> submit());
    bottomBox.getChildren().add(submitButton);
    back.setBottom(bottomBox);

  }

  public static int longestCommonSubsequence(String s1, String s2) {
    int[][] data = new int[s2.length()+1][s1.length()+1];
    for (int i=0; i<=s1.length(); i++) {
      data[0][i] = 0;
    }
    for (int j=0; j<=s2.length(); j++) {
      data[j][0] = 0;
    }
    for (int i=1; i<=s2.length(); i++) {
      for (int j=1; j<=s1.length(); j++) {
        if (s2.charAt(i-1) == (s1.charAt(j-1))) {
          data[i][j] = data[i-1][j-1]+1;
        } else {
          data[i][j] = Math.max(data[i-1][j], data[i][j-1]);
        }
      }
    }
    return data[s2.length()][s1.length()];
  }

  public boolean probabilityCheck(String guess, String ans, int lcs) {
    int l = ans.length();
    double percent = ((float)lcs/l);
    if (percent >= 0.8) {
      return true;
    } else {
      return false;
    }
  }

  public void submit() {
    boolean b1 = box1.revealAnswer(probabilityCheck(box1.getText(), name1, longestCommonSubsequence(name1, box1.getText())));
    boolean b2 = box2.revealAnswer(probabilityCheck(box2.getText(), name2, longestCommonSubsequence(name2, box2.getText())));
    boolean b3 = box3.revealAnswer(probabilityCheck(box3.getText(), name3, longestCommonSubsequence(name3, box3.getText())));
    boolean b4 = box4.revealAnswer(probabilityCheck(box4.getText(), name4, longestCommonSubsequence(name4, box4.getText())));
    if (b1) {
      score += 10;
    }
    if (b2) {
      score += 10;
    }
    if (b3) {
      score += 10;
    }
    if (b4) {
      score += 10;
    }
    bottomBox.getChildren().clear();
    var nextButton = new Button("Next");
    nextButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px");
    nextButton.setOnMouseEntered(e -> nextButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: lightgrey; -fx-font-size: 10px"));
    nextButton.setOnMouseExited(e -> nextButton.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 10px"));
    nextButton.setOnAction(e -> SceneController.swtichToScore(score));
    bottomBox.getChildren().add(nextButton);
  }
}
