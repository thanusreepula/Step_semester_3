class Employee {
    private String empId;
    private String empName;
    private double salary;
    Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }
    double getSalary() {
        return salary;
    }
}
class ManagerEmployee extends Employee {
    private double teamBonus;
    ManagerEmployee(String empId, String empName, double salary, double teamBonus) {
        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }
    double effectiveSalary() {
        return getSalary() + teamBonus;
    }
}
class InternEmployee extends Employee {
    private double stipendCap;
    InternEmployee(String empId, String empName, double salary, double stipendCap) {
        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }
    double effectiveSalary() {
        return Math.min(getSalary(), stipendCap);
    }
}
class ParkingSlot {
    String slotNo;
    int capacity;
    int occupiedCount;
    ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }
    void allot() {
        occupiedCount++;
    }
}
class CompanyEmployeeRecord {
    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;
    static int totalRecords = 0;
    CompanyEmployeeRecord(String name, String empId, Employee employee, ParkingSlot slot) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;
        totalRecords++;
    }
    String fullProfile() {
        double pay;
        if (employee instanceof ManagerEmployee) {
            pay = ((ManagerEmployee) employee).effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            pay = ((InternEmployee) employee).effectiveSalary();
        } else {
            pay = employee.getSalary();
        }
        String slotInfo = (slot != null) ? slot.slotNo : "no parking assigned";
        return name + " | Pay: Rs " + pay + " | Slot: " + slotInfo;
    }
}
public class CompanyEmployeeRecordApp {
    public static void main(String[] args) {
        Employee divyaEmp = new ManagerEmployee("E1", "Divya", 70000, 8000);
        Employee karanEmp = new Employee("E2", "Karan", 40000);
        Employee meeraEmp = new InternEmployee("E3", "Meera", 12000, 10000);
        ParkingSlot slotA1 = new ParkingSlot("A1", 4, 3);
        ParkingSlot slotA2 = new ParkingSlot("A2", 5, 4);
        slotA1.allot();
        slotA2.allot();
        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Divya", "E1", divyaEmp, slotA1);
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Karan", "E2", karanEmp, slotA2);
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Meera", "E3", meeraEmp, null);
        CompanyEmployeeRecord[] records = { r1, r2, r3 };
        for (CompanyEmployeeRecord r : records) {
            System.out.println(r.fullProfile());
        }
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}