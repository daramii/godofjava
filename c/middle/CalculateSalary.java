package c.middle;

public class CalculateSalary {

    public static void main(String[] args) {
        CalculateSalary c = new CalculateSalary();
        System.out.println("LeeDaRi = " + c.getSalaryIncrease(new Employee("LeeDaRi", 1, 1000000000)));
        System.out.println("KimManager = " + c.getSalaryIncrease(new Employee("KimManager", 2, 100000000)));
        System.out.println("WhangDesign = " + c.getSalaryIncrease(new Employee("WhangDesign", 3, 70000000)));
        System.out.println("ParkArchi = " + c.getSalaryIncrease(new Employee("ParkArchi", 4, 80000000)));
        System.out.println("LeeDevelop = " + c.getSalaryIncrease(new Employee("LeeDevelop", 5, 60000000)));
    }

    public long getSalaryIncrease(Employee employee) {
        int type = employee.getType();
        //System.out.println(type);
        long salary = employee.getSalary();
        if(type == 1) {
            return  (long)(salary + (salary * (-0.95)));
        }
        else if (type == 2) {
            return  (long)(salary + (salary * (0.1)));
        }
        else if (type == 3) {
            return  (long)(salary + (salary * (0.2)));
        }
        else if (type == 4) {
            return  (long)(salary + (salary * (0.3)));
        }
        else {
            return  (long)(salary + (salary * (1.0)));
        }
    }


}
