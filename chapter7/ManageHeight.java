public class ManageHeight{

  
  public static void main(String[] args) {
    
    ManageHeight mh = new ManageHeight();
    mh.setData();
    for( int classNo = 1; classNo <= gradeHeights.length; classNo++) {      
      mh.printHeight(classNo);
      mh.printAverage(classNo);
    }
    
    
    
  }
  
  
  int[][] gradeHeights;
  
  public void setData() {
   gradeHeights = new int[5][];
   gradeHeights[0] = new int[]{170, 180, 173, 175, 177};
   gradeHeights[1] = new int[]{160, 165, 167, 186};
   gradeHeights[2] = new int[]{158, 177, 187, 176};
   gradeHeights[3] = new int[]{173, 182, 181};
   gradeHeights[4] = new int[]{170, 180, 165, 177, 172};
   
  }
  
  
  public void printHeight(int classNo) {
    System.out.println("classNo." + classNo);
    for(int gradeHeight : gradeHeights[classNo-1]) System.out.println(gradeHeight);
  }
  
  
  public void printAverage(int classNo) {
    double average = 0.0;
    double sum = 0.0;
    for(int gradeHeight : gradeHeights[classNo-1]) {
      sum += (double)gradeHeight;
    }
    average = sum / gradeHeights[classNo-1].length;
    System.out.println("classNo." + classNo +"'s average : " + average);
  }
  
  
  
}