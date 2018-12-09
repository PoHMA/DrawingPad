package draw.providers.canvasmanager;

import draw.components.scribble.ScribbleCanvas;
import draw.components.paint.Paint;
import draw.persistencia.DataBase;
import draw.pintor.Pintor;
import draw.pintor.IObserver;
import draw.pintor.Shape;
import java.awt.Graphics;
import java.awt.Point;

public class DrawingCanvas implements IObserver {

  private Pintor pintor;
  private EventClick eventClick;
  private EventDrag eventDrag;
  private ScribbleCanvas scribbleCanvas;
  private DataBase dataBase = DataBase.getInstance();

  public DrawingCanvas(Pintor pintor){
    eventClick = new EventClick(this);
    eventDrag = new EventDrag(this);
    this.pintor = pintor;
    scribbleCanvas = new ScribbleCanvas();
    initComponent();
  }

  private void initComponent() {
    scribbleCanvas.addMouseListener(eventClick);
    scribbleCanvas.addMouseMotionListener(eventDrag);
    this.pintor.addObserver(this);
  }

  public ScribbleCanvas getComponent(){
    return scribbleCanvas;
  }

  void startDrawing(Point p) {
    this.pintor.startShape(p);
  }

  void addPointToShape(Point p) {
    this.pintor.addPointToShape(p);
  }

  void endShape(Point p) {
    this.pintor.endShape(p);
  }

  @Override
  public void drawing(Shape tool) {
    Paint paint = dataBase.getPaint(tool);
    paint.paintDrag(scribbleCanvas, tool);
  }

  @Override
  public void update() {
    Graphics g = scribbleCanvas.getGraphics();
    g.setPaintMode();
    scribbleCanvas.repaint();
  }


}
