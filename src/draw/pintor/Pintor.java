package draw.pintor;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Pintor {

  private ShapeKit shapes;
  private Color color;
  private List<Shape> drawings;
  private boolean pintando;

  public Pintor(){
    pintando = false;
    color = Color.BLACK;
    shapes = new ShapeKit();
    drawings = new ArrayList<Shape>();
    init();
  }

  public void addDrawing(Shape shape){
    drawings.add(shape);
  }

  private void init() {
    shapes.add(new Stroke());
    shapes.add(new LineShape());
    shapes.add(new OvalShape());
    shapes.add(new RectangleShape());
    shapes.setSelectedShape(EShape.LINE.toString());
  }

  public void paint(List<Point> points){
    if(pintando){
      Shape shape = new Stroke(points);
      shape.setColor(color);
      drawings.add(shape);
    }
  }

  public void drawShape(DrawingArea drawingArea) {
    if(!pintando){
      Shape shape = shapes.getSelectedShape();
      shape = shape.draw(drawingArea);
      shape.setColor(color);
      drawings.add(shape);
    }
  }

  public Color getColor() {
    return color;
  }

  public void changeColor(Color color){
    this.color = color;
  }

  public List<Shape> getDrawings(){
    return this.drawings;
  }

  public ShapeKit getShapes(){
    return this.shapes;
  }

  public void selectedShape(String nameShape) {
    pintando = nameShape.equals(EShape.SCRIBBLE.toString());
    this.shapes.setSelectedShape(nameShape);
  }

  public Shape getSelectedShape() {
    return this.shapes.getSelectedShape();
  }

  public void clear() {
    this.shapes.clear();
  }

  public boolean estaPintando(){
    return pintando;
  }

}
