package project.game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Creator {

  public String checkCreatable(ArrayList<String> answers) {
    for (int i=0; i<answers.size(); i++) {
      if (i==0 || i==1 || i==6 || i==11 || i==16) {
        if (answers.get(i).length() > 25) {
          return "Names are too long";
        }
      } else {
        if (answers.get(i).length() > 15) {
          return "Answers are too long";
        }
      }
      if (answers.get(i).contains("@") || answers.get(i).contains("\\") || answers.get(i).contains("/") || answers.get(i).contains("{") || answers.get(i).contains("}") || answers.get(i).contains("[") || answers.get(i).contains("]") || answers.get(i).contains(",")) {
        return "Invalid symbols are used";
      }
      if (answers.get(i).isBlank()) {
        return "There is an empty field";
      }
    }
    ArrayList<String> games = getGameNames();
    for (String game : games) {
     if (answers.get(0).equals(game)) {
       return "Game name already exists";
     }
    }
    return "";
  }

  public ArrayList<String> getGameNames() {
    ArrayList<String> list = new ArrayList<String>();
    File gameFile = new File("src/main/resources/games.txt");
    try {
      Scanner scanner = new Scanner(gameFile);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.contains("@")) {
          list.add(line.substring(1));
        }
      }
    } catch (IOException e) {
      return new ArrayList<String>();
    }
    return list;
  }

  public void saveGame(ArrayList<String> answers) {
    String append = "@"+answers.get(0)+"\n"+answers.get(1)+"\n"+answers.get(2)+","+answers.get(3)+","+answers.get(4)+","+answers.get(5)+"\n"+answers.get(6)+"\n"+answers.get(7)+","+answers.get(8)+","+answers.get(9)+","+answers.get(10)+"\n"+answers.get(11)+"\n"+answers.get(12)+","+answers.get(13)+","+answers.get(14)+","+answers.get(15)+"\n"+answers.get(16)+"\n"+answers.get(17)+","+answers.get(18)+","+answers.get(19)+","+answers.get(20)+"\n{}\n[]\n\n";
    try {
      FileWriter file = new FileWriter("src/main/resources/games.txt", true);
      BufferedWriter writer = new BufferedWriter(file);
      writer.write(append);
      writer.close();
    } catch (IOException e) {
      System.out.println("failure");
    }
  }
}
