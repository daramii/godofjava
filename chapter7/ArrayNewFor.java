public class ArrayNewFor{
  
  public static void main(String[] args) {
    
    
    ArrayNewFor array = new ArrayNewFor();
    array.newFor();
    
    int [][]twoDim = {{1,2,3},{4,5,6}};
    
    for(int[] tmp1: twoDim) {
      for(int tmp2 : tmp1) {
        System.out.print(tmp2 + " ");
      }
    }
    
  }
  
  public void newFor() {
    int [] oneDim = new int[] {1,2,3,4,5,6,7,8,9,10};
    
    for(int temp : oneDim) {
      System.out.print(temp + " ");
    }
  }
}