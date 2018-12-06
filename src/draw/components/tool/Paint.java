package draw.components.tool;

import draw.pintor.Shape;
import java.awt.Graphics;

public interface Paint {
    void draw(Graphics g,Shape tool);
}
