public class PrimitiveTypes {
 
 
 public static void main(String[] args) {
   
   PrimitiveTypes types = new PrimitiveTypes();
   types.checkByte();
   types.checkChar();
   types.checkBoolean();
  } 
  
  
  public void checkByte() {
    
    byte byteMin = -128; //byte의 최솟값
    byte byteMax = 127; //byte 최댓값
    System.out.println("byteMin=" + byteMin);
    System.out.println("byteMax=" + byteMax);
    byteMin = (byte)(byteMin - 1); //-129 ?
    byteMax = (byte)(byteMax + 1); //128 ?
    System.out.println("byteMin - 1=" + byteMin); //127 (1000_0000 - 1 = 0111_1111 = 127)
    System.out.println("byteMax + 1=" + byteMax); //-128 (0111_1111 + 1 = 1000_0000 = -128)
  }
  
  public void checkOtherTypes() {
    short shortMax = 32767;
    int intMax = 2147483647;
    long longMax = 9223372036854775807L; //L을 안붙여주면, int로 인식한다.int 숫자 범위가 벗어나서 에러남.
  }
  
  public void checkChar() {
    char charMin='\u0000';
    char charMax='\uffff';
    System.out.println("charMin=["+charMin+"]");
    System.out.println("charMax=["+charMax+"]");
    int intValue = 'a';
    System.out.println("intValue=["+intValue+"]"); 
  }
  
  public void checkBoolean() {
   boolean flag = true;
   System.out.println(flag);
   flag = false;
   System.out.println(flag);
  }
}