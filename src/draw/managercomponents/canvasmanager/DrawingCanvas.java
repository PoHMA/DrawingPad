package draw.managercomponents.canvasmanager;

import draw.components.scribble.ScribbleCanvas;
import draw.components.tool.Paint;
import draw.persistencia.DataBase;
import draw.pintor.Pintor;
import draw.pintor.IObserver;
import draw.pintor.LineShape;
import draw.pintor.Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class DrawingCanvas implements IObserver {

  private Pintor pintor;
  private EventClick eventClick;
  private EventDrag eventDrag;
  private ScribbleCanvas drawingCanvas;
  private DataBase dataBase = DataBase.getInstance();

  public DrawingCanvas(Pintor pintor){
    eventClick = new EventClick(this);
    eventDrag = new EventDrag(this);
    this.pintor = pintor;
    drawingCanvas = new ScribbleCanvas();
    initComponent();
  }

  private void initComponent() {
    drawingCanvas.addMouseListener(eventClick);
    drawingCanvas.addMouseMotionListener(eventDrag);
    this.pintor.addObserver(this);
  }


  public ScribbleCanvas getComponent(){
    return drawingCanvas;
  }

  void startDrawing(Point p) {
    this.pintor.startShape(p);
  }

  void addPointToShape(Point p) {
    this.pintor.addPointToShape(p);
  }

  void endShape(Point p) {
    this.pintor.endShape(p);
    Shape tool = this.pintor.getTool().getShape();
    drawingCanvas.addShape(new LineShape(tool.getXStart(), tool.getYStart(), tool.getXEnd(), tool.getYEnd()));
    Graphics g = drawingCanvas.getGraphics();
    g.setPaintMode();
    drawingCanvas.repaint();
  }

  @Override
  public void drawing(Shape tool) {
    Graphics g = drawingCanvas.getGraphics();
    g.setXORMode(Color.darkGray);
    g.setColor(Color.lightGray);
    Paint paint = dataBase.getPaint(tool);
    paint.draw(g,tool);
  }


}
