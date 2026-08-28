import java.util.Scanner;

public class Problem4 {
public static void analyzeInventory(int[] sectionA, int[] sectionB) {
int totalA = 0;
int totalB = 0;
int highestQty = Integer.MIN_VALUE;
String highestSection = "";
int highestItemIndex = -1;

for (int i = 0; i < sectionA.length; i++) {
totalA += sectionA[i];
if (sectionA[i] > highestQty) {
highestQty = sectionA[i];
highestSection = "Section A";
highestItemIndex = i + 1;
}
}

for (int i = 0; i < sectionB.length; i++) {
totalB += sectionB[i];
if (sectionB[i] > highestQty) {
highestQty = sectionB[i];
highestSection = "Section B";
highestItemIndex = i + 1;
}
}

String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
totalA, totalB, status, highestQty, highestSection, highestItemIndex);
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String lineA = scanner.nextLine().replace("{", "").replace("}", "").trim();
String lineB = scanner.nextLine().replace("{", "").replace("}", "").trim();

String[] partsA = lineA.split(",");
int[] sectionA = new int[partsA.length];
for (int i = 0; i < partsA.length; i++) {
sectionA[i] = Integer.parseInt(partsA[i].trim());
}

String[] partsB = lineB.split(",");
int[] sectionB = new int[partsB.length];
for (int i = 0; i < partsB.length; i++) {
sectionB[i] = Integer.parseInt(partsB[i].trim());
}

analyzeInventory(sectionA, sectionB);
scanner.close();
}
}