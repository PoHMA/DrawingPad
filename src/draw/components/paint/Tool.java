
package draw.components.paint;

import draw.pintor.Dibujo;
import java.awt.Point;

public interface Tool {

   void startShape(Point p);
   void addPointToShape(Point p);
   void endShape(Point p);
   Dibujo buildShape();

}
