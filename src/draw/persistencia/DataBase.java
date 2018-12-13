package draw.persistencia;

import draw.pintor.Shape;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {

  private static DataBase instance = null;

  private DataBase(){
  }

  public static DataBase getInstance() {
    if(instance == null) {
      instance = new DataBase();
    }
    return instance;
  }

  public List<Shape> openFile(String filename) {
    List<Shape> shapes = new ArrayList<>();
    try {
      FileInputStream fis = new FileInputStream(filename);
      ObjectInputStream ois = new ObjectInputStream(fis);
      Shape[] modelShapes = (Shape[])ois.readObject();
      shapes.clear();
      shapes.addAll(Arrays.asList(modelShapes));
      ois.close();
    } catch (IOException e1) {
      System.out.println("Unable to open file: " + filename);
    } catch (ClassNotFoundException e2) {
      System.out.println(e2);
    }
    return shapes;
  }

  public void saveFile(String filename, List<Shape> drawings) {
    try {
      FileOutputStream fos = new FileOutputStream(filename);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(drawings.toArray(new Shape[drawings.size()]));
      oos.close();
      System.out.println("Save drawing to " + filename);
    } catch (IOException e) {
      System.out.println("Unable to write file: " + filename);
    }
  }


}
