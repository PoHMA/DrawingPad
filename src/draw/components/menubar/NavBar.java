package draw.components.menubar;

import draw.components.scribble.Scribble;
import draw.managercomponents.menumanager.EventColor;
import draw.managercomponents.menumanager.MenuManager;
import draw.pintor.implementations.Pintor;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class NavBar extends JMenuBar{

  private Scribble scribble;
  private ExitListener exitAction;
  private MenuManager menuManager;

  public NavBar(Scribble scribble, MenuManager menuManager){
    this.scribble = scribble;
    this.menuManager = menuManager;
    createMenu();
  }

  private void createMenu() {
    JMenu menu;
    JMenuItem mi;

    createFileMenu();
    createEditMenu();

    // option menu
    menu = new JMenu("Option");
    add(menu);

    mi = new JMenuItem("Color");
    menu.add(mi);
    mi.addActionListener(new EventColor(menuManager));

    // horizontal space
    add(Box.createHorizontalGlue());

    // Help menu
    menu = new JMenu("Help");
    add(menu);

    mi = new JMenuItem("About");
    menu.add(mi);
    mi.addActionListener(new AboutListener());
  }

  private void createFileMenu(){
    JMenuItem mi;
    JMenu menu = new JMenu("File");

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

    add(menu);
  }

  public void createEditMenu(){
    JMenuItem mi;

    JMenu menu = new JMenu("Edit");

    mi = new JMenuItem("Undo");
    menu.add(mi);
    mi.addActionListener( event -> menuManager.undoItem() );

    add(menu);

  }

  public ExitListener getExisListener() {
    return exitAction;
  }

}
