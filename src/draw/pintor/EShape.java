package draw.pintor;


public enum EShape {
  SCRIBBLE{
    @Override
    public String toString(){
      return "Scribble";
    }
  },
  LINE{
    @Override
    public String toString(){
      return "Line";
    }
  },
  OVAL{
    @Override
    public String toString(){
      return "Oval";
    }
  },
  RECT{
    @Override
    public String toString(){
      return "Rectangle";
    }
  };
}
