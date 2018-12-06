package draw.pintor;

import java.util.ArrayList;
import java.util.List;

public class Notificador {

  private  List<IObserver> observers;

  Notificador(){
      observers = new ArrayList<>();
  }

  public void addObserver(IObserver observer){
    observers.add(observer);
  }

  void notifyDrawing(Shape tool){
    for(IObserver o: observers){
      o.drawing(tool);
    }
  }

}
