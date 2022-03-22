public class OperatorCompound {
  
  public static void main(String[] args) {
   OperatorCompound oc = new OperatorCompound();
   oc.compound(); 
  }
  
  public void compound() {
   
   int intValue = 10;
   int result = 0;
   result = intValue + 5;
   System.out.println(result);
   result -= 5;
   System.out.println(result);
   result *= 5;
   System.out.println(result);
   result /= 5;
   System.out.println(result);
   result %= 5;
   System.out.println(result);
    
  }
  
  
}