package draw.localcache;

import draw.pintor.Dibujo;
import draw.pintor.implementations.DrawingArea;
import java.awt.Point;
import java.util.Stack;

public class Backup {
  private Stack<DrawingArea> backups;
  private DrawingArea actual;

  public Backup(DrawingArea drawingArea){
    backups = new Stack<>();
    this.actual = generateClon(drawingArea);
  }

  public void generateBackup(DrawingArea drawingArea){
    if(drawingArea != null){
      backups.push(actual);
      actual = generateClon(drawingArea);
    }
  }

  public DrawingArea getLastBackup(){
    DrawingArea drawingArea;
    if(!backups.empty()){
      drawingArea = backups.pop();
      actual = generateClon(drawingArea);
    }else{
      drawingArea = actual;
    }
    return drawingArea;
  }

  private DrawingArea generateClon(DrawingArea drawingArea){
    Point start = drawingArea.getPointStart();
    Point end = drawingArea.getPointEnd();
    DrawingArea clonDrawingArea = new DrawingArea(new Point(start.x,start.y), new Point(end.x,end.y));
    for (Dibujo d: drawingArea.getDrawings())
      clonDrawingArea.addDibujo(d);
    return clonDrawingArea;
  }

}
