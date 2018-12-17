package draw.pintor.implementations;

import draw.pintor.Dibujo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapeList {

  private List<Dibujo> dibujos;
  private Dibujo selectedDibujo;

  public ShapeList(){
    dibujos = new ArrayList<Dibujo>();
    selectedDibujo = null;
  }

  public void add(Dibujo dibujo){
    if(dibujo != null){
      dibujos.add(dibujo);
    }
  }

  Dibujo getSelectedDibujo() {
    return selectedDibujo;
  }

  private Dibujo findShape(String name) {
    Dibujo dibujo = null;
    boolean encontre = false;
    if (name != null) {
      for (int i = 0; i < dibujos.size() && !encontre; i++) {
        dibujo = dibujos.get(i);
        if (name.equals(dibujo.getName())) {
          encontre = true;
        }
      }
    }
    return dibujo;
  }

  public Iterator iterator(){
    return dibujos.iterator();
  }

  public void removeLast(){
    if(dibujos.size() > 0){
      dibujos.remove(dibujos.size()-1);
    }
  }

  public Dibujo getShape(int i) {
    Dibujo dibujo = null;
    if (i >= 0 && i < dibujos.size()) {
      dibujo = dibujos.get(i);
    }
    return dibujo;
  }

  public int getShapeCount() {
    return dibujos.size();
  }

  public void setSelectedDibujo(String nameShape) {
    Dibujo dibujo = findShape(nameShape);
    if (dibujo != null) {
      selectedDibujo = dibujo;
    }
  }

}
