import java.util.Scanner;

public class Problem1 {
public static void checkDuplicateSeats(int[] seatNumbers) {
boolean duplicateFound = false;
for (int i = 0; i < seatNumbers.length; i++) {
boolean alreadyPrinted = false;
for (int k = 0; k < i; k++) {
if (seatNumbers[i] == seatNumbers[k]) {
alreadyPrinted = true;
break;
}
}
if (alreadyPrinted) {
continue;
}
for (int j = i + 1; j < seatNumbers.length; j++) {
if (seatNumbers[i] == seatNumbers[j]) {
System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
duplicateFound = true;
break;
}
}
}
if (!duplicateFound) {
System.out.println("No Duplicate Seats Found");
}
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String input = scanner.nextLine();
input = input.replace("{", "").replace("}", "").trim();
if (input.isEmpty()) {
return;
}
String[] parts = input.split(",");
int[] seatNumbers = new int[parts.length];
for (int i = 0; i < parts.length; i++) {
seatNumbers[i] = Integer.parseInt(parts[i].trim());
}
checkDuplicateSeats(seatNumbers);
scanner.close();
}
}