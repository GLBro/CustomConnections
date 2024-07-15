package project;

import javafx.scene.control.TextField;

import java.util.ArrayList;

public class FieldManager {

  private ArrayList<TextField> fields;

  public FieldManager() {
    fields = new ArrayList<TextField>();
  }

  public String getField(int i) {
    return fields.get(i).getText();
  }

  public ArrayList<String> getAll() {
    ArrayList<String> texts = new ArrayList<String>();
    for (TextField field : fields) {
      texts.add(field.getText());
    }
    return texts;
  }

  public void addField(TextField f) {
    fields.add(f);
  }

  public void resetAll() {
    for (TextField field : fields) {
      field.clear();
    }
  }
}
