class BaseEmployee {
    private String empId;
    private String empName;
    private double salary;
    BaseEmployee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }
    double getSalary() {
        return salary;
    }
    String getEmpName() {
        return empName;
    }
}
class ManagerEmployee extends BaseEmployee {
    private double teamBonus;
    ManagerEmployee(String empId, String empName, double salary, double teamBonus) {
        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }
    double effectiveSalary() {
        return getSalary() + teamBonus;
    }
}
class InternEmployee extends BaseEmployee {
    private double stipendCap;
    InternEmployee(String empId, String empName, double salary, double stipendCap) {
        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }
    double effectiveSalary() {
        return Math.min(getSalary(), stipendCap);
    }
}
public class Employee {
    public static void main(String[] args) {
        BaseEmployee plain = new BaseEmployee("E1", "Plain", 40000);
        ManagerEmployee manager = new ManagerEmployee("E2", "Manager", 70000, 8000);
        InternEmployee intern = new InternEmployee("E3", "Intern", 12000, 10000);
        BaseEmployee[] all = { plain, manager, intern };
        for (BaseEmployee e : all) {
            if (e instanceof ManagerEmployee) {
                System.out.println("Manager effective pay: Rs " + ((ManagerEmployee) e).effectiveSalary());
            } else if (e instanceof InternEmployee) {
                System.out.println("Intern effective pay: Rs " + ((InternEmployee) e).effectiveSalary());
            } else {
                System.out.println("Plain employee pay: Rs " + e.getSalary());
            }
        }
    }
}