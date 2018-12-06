
package draw.pintor;

import java.awt.Point;

public interface Tool {

   String getName();

   void startShape(Point p);
   void addPointToShape(Point p);
   void endShape(Point p);
   Shape getShape();

}
