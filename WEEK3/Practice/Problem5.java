import java.util.Scanner;

public class Problem5 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
if (!scanner.hasNext()) {
scanner.close();
return;
}
String rName = scanner.next();
double rTotal = scanner.nextDouble();
double rPaid = scanner.nextDouble();
String rRoom = scanner.next();

String aName = scanner.next();
double aTotal = scanner.nextDouble();
double aPaid = scanner.nextDouble();
String aRoom = scanner.next();

String kName = scanner.next();
double kTotal = scanner.nextDouble();
double kPaid = scanner.nextDouble();
String kRoom = scanner.next();

double invalidPayment = scanner.nextDouble();

HostelFeeAccount fa1 = new HostelFeeAccount(1, rTotal, rPaid);
HostelFeeAccount fa2 = new HostelFeeAccount(2, aTotal, aPaid);
HostelFeeAccount fa3 = new HostelFeeAccount(3, kTotal, kPaid);

fa1.pay(invalidPayment);

HostelRoom hr1 = new HostelRoom(rRoom, 3, 2);
HostelRoom hr2 = new HostelRoom(aRoom, 2, 1);

SrmStudentCapstone s1 = new SrmStudentCapstone(rName, "RA01", fa1, hr1);
SrmStudentCapstone s2 = new SrmStudentCapstone(aName, "RA02", fa2, hr2);
SrmStudentCapstone s3 = new SrmStudentCapstone(kName, "RA03", fa3, null);

System.out.println(s1.fullStatus());
System.out.println(s2.fullStatus());
System.out.println(s3.fullStatus());
System.out.println("Total students: " + SrmStudentCapstone.totalStudents);

scanner.close();
}
}

class SrmStudentCapstone {
String name;
String regNo;
HostelFeeAccount feeAccount;
HostelRoom room;
static int totalStudents = 0;

SrmStudentCapstone(String name, String regNo, HostelFeeAccount feeAccount, HostelRoom room) {
this.name = name;
this.regNo = regNo;
this.feeAccount = feeAccount;
this.room = room;
totalStudents++;
}

String fullStatus() {
String roomStr = (room != null) ? room.roomNo : "unallotted";
return name + " | Due: Rs " + feeAccount.getDue() + " | Room: " + roomStr;
}
}