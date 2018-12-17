package draw.pintor.implementations;

import draw.pintor.Dibujo;
import java.awt.Color;
import java.awt.Point;
import java.util.List;

public class Pintor {

  private ShapeList shapes;
  private Color color;
  private boolean drawPoint;
  private DrawingArea drawings;

  public Pintor(){
    drawings = new DrawingArea(new Point(0,0), new Point(0,0));
    drawPoint = true;
    color = Color.BLACK;
    shapes = new ShapeList();
    init();
  }

  public void addDrawing(Dibujo dibujo){
    drawings.addDibujo(dibujo);
  }

  private void init() {
    shapes.add(new Stroke());
    shapes.add(new LineShape());
    shapes.add(new OvalDibujo());
    shapes.add(new RectangleDibujo());
    shapes.add(new Inheritance());
    shapes.add(new ClassDrawing());
    shapes.setSelectedDibujo(EShape.SCRIBBLE.toString());
  }

  public void drawPoints(List<Point> points){
    if(drawPoint){
      Dibujo dibujo = new Stroke(points);
      dibujo.setColor(color);
      drawings.addDibujo(dibujo);
    }
  }

  public void drawShape(DrawingArea drawingArea)  {
    if(!drawPoint){
      Dibujo dibujo = shapes.getSelectedDibujo();
      dibujo.draw(drawingArea);
      dibujo.setColor(color);
      try {
        drawings.addDibujo(dibujo.clone());
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
    }
  }

  public Color getColor() {
    return color;
  }

  public void changeColor(Color color){
    this.color = color;
  }

  public DrawingArea getDrawingArea(){
    return this.drawings;
  }

  public ShapeList getShapes(){
    return this.shapes;
  }

  public void selectedShape(String nameShape) {
    drawPoint = nameShape.equals(EShape.SCRIBBLE.toString());
    this.shapes.setSelectedDibujo(nameShape);
  }

  public Dibujo getSelectedShape() {
    return this.shapes.getSelectedDibujo();
  }

  public void clear() {
    this.drawings.newDrawingArea();
  }

  public boolean estaPintando(){
    return drawPoint;
  }

  public void setDrawingArea(DrawingArea newDrawingArea){
    if(newDrawingArea != null){
      this.drawings = newDrawingArea;
    }
  }

}
