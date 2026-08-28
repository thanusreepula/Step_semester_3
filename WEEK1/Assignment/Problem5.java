import java.util.Scanner;

public class Problem5 {
public static void classifyWordLengths(String review) {
String[] words = review.trim().split("\\s+");
int shortCount = 0;
int mediumCount = 0;
int longCount = 0;

for (String word : words) {
if (word.isEmpty()) {
continue;
}
int len = word.length();
if (len >= 1 && len <= 4) {
shortCount++;
} else if (len >= 5 && len <= 8) {
mediumCount++;
} else if (len >= 9) {
longCount++;
}
}

System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String review = scanner.nextLine();
classifyWordLengths(review);
scanner.close();
}
}