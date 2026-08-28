import java.util.Scanner;

public class Problem4 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
if (!scanner.hasNext()) {
scanner.close();
return;
}
String s1Name = scanner.next();
String s2Name = scanner.next();

System.out.println("Broken version:");
BrokenSrmStudent b1 = new BrokenSrmStudent(s1Name);
BrokenSrmStudent b2 = new BrokenSrmStudent(s2Name);
System.out.println(BrokenSrmStudent.name);
System.out.println(BrokenSrmStudent.name);

System.out.println("\nFixed version:");
FixedSrmStudent f1 = new FixedSrmStudent(s1Name);
FixedSrmStudent f2 = new FixedSrmStudent(s2Name);
f1.printIdCard();
f2.printIdCard();
FixedSrmStudent.printTotalAdmissions();

scanner.close();
}
}

class BrokenSrmStudent {
static String name;

BrokenSrmStudent(String name) {
BrokenSrmStudent.name = name;
}
}

class FixedSrmStudent {
String name;
String regNo;
int attendance;
static String university = "SRM";
static int admissionCount = 0;

FixedSrmStudent(String name) {
this.name = name;
admissionCount++;
this.regNo = "RA2311003010" + (10 + admissionCount);
}

void printIdCard() {
System.out.println(name + " | " + regNo);
}

static void printTotalAdmissions() {
System.out.println("Students admitted so far: " + admissionCount);
}
}