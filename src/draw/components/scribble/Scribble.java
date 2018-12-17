
package draw.components.scribble;

import draw.components.menubar.ExitListener;
import draw.managercomponents.canvasmanager.DrawingCanvas;
import draw.persistencia.DataBase;
import draw.managercomponents.menumanager.MenuManager;
import draw.pintor.Dibujo;
import draw.pintor.implementations.Pintor;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;

public class Scribble extends JFrame {

  private ScribbleCanvas canvas;
  private Pintor pintor;
  private String currentFilename = null;
  private ExitListener exitAction;
  private MenuManager menuManager;
  private DrawingCanvas drawingCanvas;
  private ListenerWindowAdapter windowAdapter;
  private DataBase dataBase = DataBase.getInstance();

  public Scribble(String title, Pintor pintor) {
    super(title);
    this.pintor = pintor;
    drawingCanvas = new DrawingCanvas(pintor);
    windowAdapter = new ListenerWindowAdapter(this);
    initComponents();
    setTemplate();
  }

  private void initComponents() {
    canvas = drawingCanvas.getComponent();
    menuManager = new MenuManager(this, pintor, drawingCanvas);
  }

  private void setTemplate(){
    getContentPane().setLayout(new BorderLayout());
    exitAction = menuManager.getComponent().getExisListener();
    setJMenuBar(menuManager.getComponent());
    getContentPane().add(canvas, BorderLayout.CENTER);
    addWindowListener(windowAdapter);
  }

  public void newFile() {
    currentFilename = null; 
    this.pintor.clear();
    canvas.repaint();
    setTitle("Scribble Pad");
  }

   public void openFile(String filename) {
    currentFilename = filename;
    List<Dibujo> drawing = dataBase.openFile(filename);
    this.pintor.clear();
    for(Dibujo s: drawing){
      this.pintor.addDrawing(s);
    }
    canvas.repaint();
    setTitle("Scribble Pad [" + currentFilename + "]");
  }

   public void saveFile() {
    if (currentFilename == null) {
      currentFilename = "Untitled"; 
    }
    dataBase.saveFile(currentFilename, this.pintor.getDrawingArea().getDrawings());
    setTitle("Scribble Pad [" + currentFilename + "]");
  }

  public void saveFileAs(String filename) {
    currentFilename = filename; 
    dataBase.saveFile(filename, this.pintor.getDrawingArea().getDrawings());
    setTitle("Scribble Pad [" + currentFilename + "]");
  }

  ExitListener getExitListener() {
    return exitAction;
  }

}
