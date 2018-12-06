package draw.components.scribble;

import draw.components.menubar.ExitListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScribbleWindowAdapter extends WindowAdapter {
  private final Scribble frame;

  ScribbleWindowAdapter(Scribble f) {
    frame = f;
  }

  @Override
  public final void windowClosing(final WindowEvent e) {
    ExitListener exitListener = frame.getExitListener();
    if (exitListener != null) {
      exitListener.actionPerformed(new ActionEvent(frame, 0, null));
    }
  }

}
