package draw.providers.drawingpadmanager;

import draw.components.scribble.Scribble;
import draw.providers.toolmanager.ToolManager;
import draw.pintor.Pintor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class DrawingPad {

  private final int WIDTH = 600;
  private final int HEIGHT = 400;
  private Pintor pintor;
  private Scribble scribble;

  public DrawingPad(String title) {
    this.pintor = new Pintor();
    this.scribble = new Scribble(title, pintor);
    addComponents();
    initFrame();
  }

  private void addComponents() {
    ToolManager toolManager = new ToolManager(pintor);
    JComponent toolbar = toolManager.createToolBar();
    this.scribble.getContentPane().add(toolbar, BorderLayout.WEST);
    JMenu menu = toolManager.createToolMenu();
    JMenuBar menuBar = this.scribble.getJMenuBar();
    menuBar.add(menu, 1); // insert at index position 1
  }

  private void initFrame() {
    this.scribble.setSize(WIDTH, HEIGHT);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.scribble.setLocation(screenSize.width/2 - WIDTH/2,
        screenSize.height/2 - HEIGHT/2);
    this.scribble.setVisible(true);
  }


}
