public class Conversion{
    //converts from grid coords to xy coords
  public static int fromGridx(int x, int y) {
    return (x+y)%9;
  }
  public static int fromGridy(int x, int y){
    if(x+y > 9) {
      x++;
    }
    return x;
  } 
  
  //converts from xy coords to grid coords
  public static int toGridx(int x, int y) {
    if(x-y < 0) {
      y--;
    }
    return y;
  } 
  
  public static int toGridy(int x, int y) {
    int temp = x-y;
    if (temp < 0) {
      return temp + 10;
    }
    return temp;
  }
  
}