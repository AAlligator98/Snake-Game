import java.awt.Color;

public class Snake extends Segment {

    public Snake(int x, int y) {
         super(x,y);
    }

    public Color color() {
      return Color.GREEN;
    }

}