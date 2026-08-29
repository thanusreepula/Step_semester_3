import java.util.Scanner;

public class Problem2 {
public static void checkTypingAccuracy(String original, String typed) {
int matches = 0;
int length = original.length();
int firstMismatchPos = -1;
char origChar = ' ';
char typedChar = ' ';

for (int i = 0; i < length; i++) {
if (original.charAt(i) == typed.charAt(i)) {
matches++;
} else if (firstMismatchPos == -1) {
firstMismatchPos = i + 1;
origChar = original.charAt(i);
typedChar = typed.charAt(i);
}
}

double accuracy = ((double) matches / length) * 100;
if (firstMismatchPos != -1) {
System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n",
matches, length, accuracy, firstMismatchPos, origChar, typedChar);
} else {
System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n",
matches, length, accuracy);
}
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String original = scanner.nextLine();
String typed = scanner.nextLine();
checkTypingAccuracy(original, typed);
scanner.close();
}
}