import java.util.Scanner;

public class Problem1 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
if (!scanner.hasNextInt()) {
scanner.close();
return;
}
int n = scanner.nextInt();
SrmStudent[] students = new SrmStudent[n];
for (int i = 0; i < n; i++) {
if (!scanner.hasNext()) {
break;
}
String name = scanner.next();
int attendance = scanner.nextInt();
students[i] = new SrmStudent(name, attendance);
}
for (SrmStudent s : students) {
if (s != null) {
System.out.println(s.name + " " + s.attendance + "% " + (s.isEligible() ? "Eligible" : "Detained"));
}
}
System.out.printf("Class average: %.1f%%\n", SrmStudent.classAverage(students));
scanner.close();
}
}

class SrmStudent {
String name;
int attendance;

SrmStudent(String name, int attendance) {
this.name = name;
this.attendance = attendance;
}

void addAttendanceUpdate(int newAttendance) {
this.attendance = newAttendance;
}

boolean isEligible() {
return this.attendance >= 75;
}

static double classAverage(SrmStudent[] students) {
if (students == null || students.length == 0) {
return 0.0;
}
double sum = 0;
int count = 0;
for (SrmStudent s : students) {
if (s != null) {
sum += s.attendance;
count++;
}
}
return count == 0 ? 0.0 : sum / count;
}
}