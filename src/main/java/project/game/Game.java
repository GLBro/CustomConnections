package project.game;

import project.ui.ItemButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Game {
  private ArrayList<String> connection1;
  private ArrayList<String> connection2;
  private ArrayList<String> connection3;
  private ArrayList<String> connection4;
  private ArrayList<String> selected;
  private int lives;
  private int score;
  private ArrayList<Set> prevGuesses;

  public Game(ArrayList<String> contents) {
    connection1 = new ArrayList<String>();
    connection2 = new ArrayList<String>();
    connection3 = new ArrayList<String>();
    connection4 = new ArrayList<String>();
    selected = new ArrayList<String>();
    lives = 4;
    score = 20;
    prevGuesses = new ArrayList<Set>();
    for (int i=0; i<contents.size(); i++) {
      if (i>=2 && i<=5) {
        connection1.add(contents.get(i));
      } else if (i>=7 && i<=10) {
        connection2.add(contents.get(i));
      } else if (i>=12 && i<=15) {
        connection3.add(contents.get(i));
      } else if (i>=17 && i<=20) {
        connection4.add(contents.get(i));
      }
    }
  }


  public void addSelection(String s) {
    selected.add(s);
  }

  public void removeSelection(String s) {
    selected.remove(s);
  }

  public boolean allowSelection() {
    if (selected.size() >= 4) {
      return false;
    } else {
      return true;
    }
  }

  public int checkMatches() {
    Set set1 = new HashSet(connection1);
    Set set2 = new HashSet(connection2);
    Set set3 = new HashSet(connection3);
    Set set4 = new HashSet(connection4);
    Set mySet = new HashSet(selected);
    Set oneAway1 = new HashSet(set1);
    oneAway1.retainAll(mySet);
    Set oneAway2 = new HashSet(set2);
    oneAway2.retainAll(mySet);
    Set oneAway3 = new HashSet(set3);
    oneAway3.retainAll(mySet);
    Set oneAway4 = new HashSet(set4);
    oneAway4.retainAll(mySet);
    if (mySet.equals(set1)) {
      return 1;
    } else if (mySet.equals(set2)) {
      return 2;
    } else if (mySet.equals(set3)) {
      return 3;
    } else if (mySet.equals(set4)) {
      return 4;
    } else if (prevGuesses.contains(mySet)) {
      return 6;
    } else if (oneAway1.size()==3 || oneAway2.size()==3 || oneAway3.size()==3 || oneAway4.size()==3) {
      prevGuesses.add(mySet);
      return 5;
    } else {
      prevGuesses.add(mySet);
      return 0;
    }
  }

  public void printSelected() {
    for (String s : selected) {
      System.out.println(s);
    }
    System.out.println("\n");
  }

  public void deselectAll() {
    selected.clear();
  }

  public void increaseScore(int n) {
    score += n;
    if (score < 0) {
      score = 0;
    }
  }

  public void decreaseLives() {
    lives--;
  }

  public boolean fail() {
    if (lives <= 0) {
      return true;
    } else {
      return false;
    }
  }

  public int getLives() {
    return lives;
  }

  public int getScore() {
    return score;
  }

  public int getNumSelected() {
    return selected.size();
  }
}
