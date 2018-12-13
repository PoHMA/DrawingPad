package draw.pintor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapeKit {

  private List<Shape> shapes;
  private Shape selectedShape;

  public ShapeKit(){
    shapes = new ArrayList<Shape>();
    selectedShape = null;
  }

  public void add(Shape shape){
    if(shape != null){
      shapes.add(shape);
    }
  }

  public Shape getSelectedShape() {
    return selectedShape;
  }

  private Shape findShape(String name) {
    Shape shape = null;
    boolean encontre = false;
    if (name != null) {
      for (int i = 0; i < shapes.size() && !encontre; i++) {
        shape = shapes.get(i);
        if (name.equals(shape.getName())) {
          encontre = true;
        }
      }
    }
    return shape;
  }

  public Iterator iterator(){
    return shapes.iterator();
  }

  public void clear(){
    shapes.clear();
  }

  public void removeLast(){
    if(shapes.size() > 0){
      shapes.remove(shapes.size()-1);
    }
  }

  public Shape getShape(int i) {
    Shape shape = null;
    if (i >= 0 && i < shapes.size()) {
      shape = shapes.get(i);
    }
    return shape;
  }

  public int getShapeCount() {
    return shapes.size();
  }


  public void setSelectedShape(String nameShape) {
    Shape shape = findShape(nameShape);
    if (shape != null) {
      selectedShape = shape;
    }
  }

}
