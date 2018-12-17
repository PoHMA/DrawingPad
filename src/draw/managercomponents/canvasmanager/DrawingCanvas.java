package draw.managercomponents.canvasmanager;

import draw.components.scribble.ScribbleCanvas;
import draw.localcache.Backup;
import draw.pintor.Dibujo;
import draw.pintor.implementations.DrawingArea;
import draw.pintor.implementations.Pintor;
import draw.pintor.interfaces.Edge;
import java.awt.Point;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

public class DrawingCanvas {

  private Pintor pintor;
  private Backup backup;
  private EventClick eventClick;
  private EventDrag eventDrag;
  private ScribbleCanvas scribbleCanvas;
  private List<Point> points;
  private Point start;
  private Point next;
  private Dibujo upDibujo;

  public DrawingCanvas(Pintor pintor){
    this.pintor = pintor;
    eventClick = new EventClick(this);
    eventDrag = new EventDrag(this);
    scribbleCanvas = new ScribbleCanvas(pintor);
    start = new Point();
    next = new Point();
    upDibujo = null;
    backup = new Backup(this.pintor.getDrawingArea());
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

    if(this.pintor.getDrawingArea().isSelectedDibujo(start))
       upDibujo = this.pintor.getDrawingArea().removeDibujo(start);
    scribbleCanvas.drawing(this.pintor.getSelectedShape(), new DrawingArea(start, next) );
  }

  void addPointToShape(Point p){
    points.add(p);
    if(!this.pintor.estaPintando()){
      scribbleCanvas.drawing(this.pintor.getSelectedShape(), new DrawingArea(start, next) );
      scribbleCanvas.drawing(this.pintor.getSelectedShape(), new DrawingArea(start, p));
    }else{
      scribbleCanvas.paintPoint(next,p, this.pintor.getColor());
    }
    next.x = p.x;
    next.y = p.y;
  }

  void endShape(Point end){
    Dibujo dibujo;
    DrawingArea drawingArea;
    drawingArea = new DrawingArea(new Point(start.x, start.y),new Point(end.x, end.y));

    if (!this.pintor.getDrawingArea().isSelectedDibujo(end) && !(this.pintor.getSelectedShape() instanceof Edge) ){
      points.add(end);
      if(upDibujo != null)
        this.pintor.getDrawingArea().addDibujo(upDibujo);
      if(this.pintor.estaPintando() ){
        this.pintor.drawPoints(points);
      }else{
        this.pintor.drawShape(drawingArea);
        backup.generateBackup(this.pintor.getDrawingArea());
      }
    }else if( upDibujo != null && this.pintor.getDrawingArea().isSelectedDibujo(end)
        && (this.pintor.getSelectedShape() instanceof Edge) ){
      dibujo = this.pintor.getDrawingArea().removeDibujo(end);
      this.pintor.getDrawingArea().addDibujo(dibujo);
      drawingArea.addDibujo(upDibujo);
      drawingArea.addDibujo(dibujo);
      this.pintor.drawShape(drawingArea);
      this.pintor.getDrawingArea().addDibujo(upDibujo);
      backup.generateBackup(this.pintor.getDrawingArea());
    }else{
      this.pintor.getDrawingArea().addDibujo(upDibujo);
    }

    upDibujo = null;
    scribbleCanvas.repaint();
  }

  void setUpDibujo(Point end) {
    if(upDibujo != null){
      upDibujo = this.scribbleCanvas.modifyDrawing(upDibujo);
      this.pintor.getDrawingArea().addDibujo(upDibujo);
      this.backup.generateBackup(this.pintor.getDrawingArea());
    }
    upDibujo = null;
    this.scribbleCanvas.repaint();
  }

  public ScribbleCanvas getComponent(){
    return scribbleCanvas;
  }


  public void undo() {
    DrawingArea drawingArea = this.backup.getLastBackup();
    this.pintor.setDrawingArea(drawingArea);
    this.scribbleCanvas.repaint();
  }

}
