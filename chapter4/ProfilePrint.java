public class ProfilePrint{
 
 //�ν��Ͻ� ���� ����
 byte age;
 String name; 
 boolean isMarried;
 
 public static void main(String[] args) {
   ProfilePrint pfp = new ProfilePrint();
   pfp.setAge((byte)30);
   pfp.setName("��ټ�");
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


