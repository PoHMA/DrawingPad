package draw.managercomponents.canvasmanager;

import draw.components.scribble.ScribbleCanvas;
import draw.pintor.DrawingArea;
import draw.pintor.Pintor;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class DrawingCanvas {

  private Pintor pintor;
  private EventClick eventClick;
  private EventDrag eventDrag;
  private ScribbleCanvas scribbleCanvas;
  private List<Point> points;
  private Point start;
  private Point next;

  public DrawingCanvas(Pintor pintor){
    eventClick = new EventClick(this);
    eventDrag = new EventDrag(this);
    this.pintor = pintor;
    scribbleCanvas = new ScribbleCanvas(pintor);
    start = new Point();
    next = new Point();
    initComponent();
  }

  private void initComponent() {
    scribbleCanvas.addMouseListener(eventClick);
    scribbleCanvas.addMouseMotionListener(eventDrag);
  }

  void startShape(Point p){
    points = new ArrayList<>();
    start.x = p.x;
    start.y = p.y;
    next.x = p.x;
    next.y = p.y;
    points.add(p);
  }

  void addPointToShape(Point p){
    points.add(p);
    if(!this.pintor.estaPintando()){
      scribbleCanvas.drawing(this.pintor.getSelectedShape(), start, next);
      scribbleCanvas.drawing(this.pintor.getSelectedShape(), start, p);
    }else{
      scribbleCanvas.paintPoint(next,p);
    }
    next.x = p.x;
    next.y = p.y;
  }

  void endShape(Point end){
    DrawingArea drawingArea;
    points.add(end);
    if(this.pintor.estaPintando() ){
      this.pintor.paint(points);
    }else{
      points = new ArrayList<>();
      points.add(new Point(start.x, start.y));
      points.add(new Point(end.x, end.y));
      drawingArea = new DrawingArea(points);
      this.pintor.drawShape(drawingArea);
    }
    scribbleCanvas.repaint();
  }

  public ScribbleCanvas getComponent(){
    return scribbleCanvas;
  }

}
