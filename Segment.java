
public class Segment{ //every point on the grid is a segment which can be turned into something else like an apple or a part of the snake
  
  private int xCoord;
  private int yCoord;

  public int getXCoord(){
    return xCoord; 
  }
  public int getYCoord(){
    return yCoord; 
  }

  public void incrementX(int input){
    xCoord += input; 
  }
  public void incrementY(int input){
    yCoord += input; 
  }
  
  public Segment(int x, int y){
    xCoord = x;
    yCoord = y;
  }
}

