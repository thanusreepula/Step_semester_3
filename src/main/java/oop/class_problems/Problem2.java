import java.util.Scanner;

public class Problem2 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
if (!scanner.hasNextDouble()) {
scanner.close();
return;
}
double plainTotal = scanner.nextDouble();
double plainPaid = scanner.nextDouble();
double hostelTotal = scanner.nextDouble();
double hostelPaid = scanner.nextDouble();
double schTotal = scanner.nextDouble();
double schPaid = scanner.nextDouble();
double schPercent = scanner.nextDouble();

FeeAccount plain = new FeeAccount(101, plainTotal, plainPaid);
HostelFeeAccount hostel = new HostelFeeAccount(102, hostelTotal, hostelPaid);
ScholarshipFeeAccount scholarship = new ScholarshipFeeAccount(103, schTotal, schPaid, schPercent);

FeeAccount[] accounts = { plain, hostel, scholarship };
for (FeeAccount acc : accounts) {
if (acc instanceof ScholarshipFeeAccount) {
ScholarshipFeeAccount s = (ScholarshipFeeAccount) acc;
System.out.println("Scholarship account effective due: Rs " + s.effectiveDue());
} else if (acc instanceof HostelFeeAccount) {
System.out.println("Hostel account due: Rs " + acc.getDue());
} else {
System.out.println("Plain account due: Rs " + acc.getDue());
}
}
scanner.close();
}
}

class FeeAccount {
private int regNo;
private double totalFee;
private double amountPaid;

FeeAccount(int regNo, double totalFee, double amountPaid) {
this.regNo = regNo;
this.totalFee = totalFee;
this.amountPaid = amountPaid;
}

void pay(double amount) {
if (amount > 0) {
this.amountPaid += amount;
}
}

double getDue() {
return totalFee - amountPaid;
}
}

class HostelFeeAccount extends FeeAccount {
HostelFeeAccount(int regNo, double totalFee, double amountPaid) {
super(regNo, totalFee, amountPaid);
}

void payInTwoInstallments(double amount) {
pay(amount);
}
}

class ScholarshipFeeAccount extends FeeAccount {
private double scholarshipPercent;

ScholarshipFeeAccount(int regNo, double totalFee, double amountPaid, double scholarshipPercent) {
super(regNo, totalFee, amountPaid);
this.scholarshipPercent = scholarshipPercent;
}

double effectiveDue() {
return getDue() - (getDue() * (scholarshipPercent / 100.0));
}
}