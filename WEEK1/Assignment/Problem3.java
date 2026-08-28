import java.util.Scanner;

public class Problem3 {
public static void findLongestStreak(String signalLog) {
if (signalLog == null || signalLog.length() == 0) {
return;
}
char longestChar = signalLog.charAt(0);
int maxStreak = 1;
char currentChar = signalLog.charAt(0);
int currentStreak = 1;

for (int i = 1; i < signalLog.length(); i++) {
if (signalLog.charAt(i) == currentChar) {
currentStreak++;
} else {
if (currentStreak > maxStreak) {
maxStreak = currentStreak;
longestChar = currentChar;
}
currentChar = signalLog.charAt(i);
currentStreak = 1;
}
}
if (currentStreak > maxStreak) {
maxStreak = currentStreak;
longestChar = currentChar;
}

System.out.println("Longest Streak: '" + longestChar + "' repeated " + maxStreak + " times");
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String signalLog = scanner.nextLine();
findLongestStreak(signalLog);
scanner.close();
}
}