public class ManageStudent{
  
  public static void main (String args[]) {
    ManageStudent ms = new ManageStudent();
    Student[] student = null;
    student = ms.addStudent();
    ms.printStudents(student);
    
    
  }
  
  public Student[] addStudent() {
    Student[] student = new Student[3];
    student[0] = new Student("Lim");
    student[1] = new Student("Min");
    student[2] = new Student("Sook", "Seoul", "01012341234","ask@godofjava.com" );
    return student;
  }
  
  public void printStudents(Student[] student) {
    for(Student std : student) {
      System.out.println(std);
    }
  }
  
}