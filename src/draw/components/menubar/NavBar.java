package draw.components.menubar;

import draw.components.scribble.ScribbleCanvas;
import draw.components.scribble.Scribble;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class NavBar extends JMenuBar{

  private Scribble scribble;
  private ScribbleCanvas scribbleCanvas;
  private ExitListener exitAction;

  public NavBar(Scribble scribble, ScribbleCanvas scribbleCanvas){
    this.scribble = scribble;
    this.scribbleCanvas = scribbleCanvas;
    createMenu();
  }

  private void createMenu() {
    JMenu menu;
    JMenuItem mi;

    // File menu
    menu = new JMenu("File");
    add(menu);

    mi = new JMenuItem("New");
    menu.add(mi);
    mi.addActionListener(new NewFileListener(scribble));

    mi = new JMenuItem("Open");
    menu.add(mi);
    mi.addActionListener(new OpenFileListener(scribble));

    mi = new JMenuItem("Save");
    menu.add(mi);
    mi.addActionListener(new SaveFileListener(scribble));

    mi = new JMenuItem("Save As");
    menu.add(mi);
    mi.addActionListener(new SaveAsFileListener(scribble));

    menu.add(new JSeparator());

    exitAction = new ExitListener(scribble);
    mi = new JMenuItem("Exit");
    menu.add(mi);
    mi.addActionListener(exitAction);

    // option menu
    menu = new JMenu("Option");
    add(menu);

    mi = new JMenuItem("Color");
    menu.add(mi);
    mi.addActionListener(new ColorListener(scribble,scribbleCanvas));

    // horizontal space
    add(Box.createHorizontalGlue());

    // Help menu
    menu = new JMenu("Help");
    add(menu);

    mi = new JMenuItem("About");
    menu.add(mi);
    mi.addActionListener(new AboutListener());
  }

  public ExitListener getExisListener() {
    return exitAction;
  }

}