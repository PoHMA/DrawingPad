package draw.pintor.implementations;


import draw.library.Utils;
import draw.pintor.Dibujo;
import java.awt.Point;

public class RhombusDibujo extends Dibujo {

  private LineShape l1;
  private LineShape l2;
  private LineShape l3;
  private LineShape l4;

  RhombusDibujo(){
    l1 = new LineShape();
    l2 = new LineShape();
    l3 = new LineShape();
    l4 = new LineShape();
  }

  @Override
  public String getName() {
    return EShape.RHOMBUS.toString();
  }

  @Override
  public void draw(DrawingArea drawingArea) {
    Point start = drawingArea.getPointStart();
    Point end = drawingArea.getPointEnd();
    int x2 = end.x;
    int y2 = end.y;
    double alfa = Math.atan2(end.y - start.y, end.x- start.x);
    int xa1 = (int) (x2 - Utils.TAM_ARROW * Math.cos(alfa + 1));
    int ya1 = (int) (y2 - Utils.TAM_ARROW * Math.sin(alfa + 1));
    int xa2 = (int) (x2 - Utils.TAM_ARROW * Math.cos(alfa - 1));
    int ya2 = (int) (y2 - Utils.TAM_ARROW * Math.sin(alfa - 1));
    int xa3 = (int) (x2 - Utils.TAM_ARROW * Math.cos(alfa));
    int ya3 = (int) (y2 - Utils.TAM_ARROW * Math.sin(alfa));

    l1 = new LineShape(new Point(xa1, ya1), new Point(x2, y2));
    l2 = new LineShape(new Point(xa2, ya2), new Point(x2, y2));
    l3 = new LineShape(new Point(xa1, ya1), new Point(xa3, ya3));
    l4 = new LineShape(new Point(xa2, ya2), new Point(xa3, ya3));
  }

  @Override
  public boolean isSelected(Point p) {
    return false;
  }

  public LineShape getL1(){
    return l1;
  }

  public LineShape getL2(){
    return l2;
  }

  public LineShape getL3(){
    return l3;
  }

  public LineShape getL4(){
    return l4;
  }

}
