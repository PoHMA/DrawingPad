package draw.persistencia;

import draw.components.tool.LinePaint;
import draw.components.tool.OvalPaint;
import draw.components.tool.Paint;
import draw.components.tool.RectanglePaint;
import draw.components.tool.StrokePaint;
import draw.pintor.LineShape;
import draw.pintor.OvalShape;
import draw.pintor.RectangleShape;
import draw.pintor.Shape;
import draw.pintor.Stroke;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {

  private List<Shape> shapes ;
  private static DataBase instance = null;

  private DataBase(){
    shapes = new ArrayList<Shape>();
  }

  public static DataBase getInstance() {
    if(instance == null) {
      instance = new DataBase();
    }
    return instance;
  }

  public void addShape(Shape shape) {
    shapes.add(shape);
  }

  public List<Shape> getShapes() {
    return shapes;
  }

  public void openFile(String filename) {
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
  }

  public void saveFile(String filename) {
    try {
      FileOutputStream fos = new FileOutputStream(filename);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(shapes.toArray(new Shape[shapes.size()]));
      oos.close();
      System.out.println("Save drawing to " + filename);
    } catch (IOException e) {
      System.out.println("Unable to write file: " + filename);
    }
  }

  public void limpiar() {
    shapes.clear();
  }

  public Paint getPaint(Shape tool){
    Paint paint = null;
    if(tool instanceof LineShape){
      paint = new LinePaint();
    }
    if(tool instanceof OvalShape){
      paint = new OvalPaint();
    }
    if(tool instanceof RectangleShape){
      paint = new RectanglePaint();
    }
    if(tool instanceof Stroke){
      paint = new StrokePaint();
    }
    return paint;
  }

}
