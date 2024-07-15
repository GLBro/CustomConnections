package project.ui;

import javafx.scene.control.Button;
import project.SceneController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameButton extends Button {

  private String name;

  public GameButton(String name) {
    this.name = name;
    this.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 5px; -fx-text-fill: black; -fx-font-family: 'Arial Black'; -fx-font-size: 20px");
    this.setText(name);
    this.setPrefWidth(200);
    this.setPrefHeight(75);
    this.setOnAction(e -> SceneController.switchToGame(getGameInfo()));
    this.setOnMouseEntered(e -> this.setStyle("-fx-background-color: grey; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: white; -fx-font-size: 20px"));
    this.setOnMouseExited(e -> this.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 5px; -fx-font-family: 'Arial Black'; -fx-text-fill: black; -fx-font-size: 20px"));
  }

  public ArrayList<String> getGameInfo() {
    File file = new File("src/main/resources/games.txt");
    ArrayList<String> data = new ArrayList<String>();
    String line = "";
    boolean read = false;
    try {
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        line = scanner.nextLine();
        if (line.equals("@"+name)) {
          read = true;
        }
        if (line.isBlank()) {
          read = false;
        }
        if (read) {
          data.addAll(adder(line));
        }
      }
    } catch (IOException e) {
      System.out.println("failure");
    }
    return data;
  }

  public ArrayList<String> adder(String s) {
    ArrayList<String> out = new ArrayList<String>();
    if (s.contains("@")) {
      out.add(s.substring(1));
      return out;
    } else if (s.contains(",")) {
      String[] a = s.split(",");
      out.add(a[0]);
      out.add(a[1]);
      out.add(a[2]);
      out.add(a[3]);
      return out;
    } else {
      out.add(s);
      return out;
    }
  }
}
