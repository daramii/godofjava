public class ProfilePrint{
 
 //인스턴스 변수 선언
 byte age;
 String name; 
 boolean isMarried;
 
 public static void main(String[] args) {
   ProfilePrint pfp = new ProfilePrint();
   pfp.setAge((byte)30);
   pfp.setName("김다솔");
   pfp.setMarried(false);
   System.out.println(pfp.getAge());
   System.out.println(pfp.getName());
   System.out.println(pfp.isMarried());
 }
 
 
 public void setAge(byte age) {
  this.age = (byte)age; 
 }
 
 public byte getAge() {
   return this.age;
 }
 
 public void setName(String name) {
   this.name = name;
  }
  
  public String getName() {
   return this.name; 
  }
  
  public void setMarried(boolean flag) {
    this.isMarried = flag; 
  }
  
  public boolean isMarried() {
   return this.isMarried; 
  }
  
}


