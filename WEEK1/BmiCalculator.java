import java.util.Scanner;

public class BmiCalculator {

public static String getBmiStatus(double bmi) {
if (bmi < 18.5) {
return "Underweight";
} else if (bmi < 25) {
return "Normal";
} else if (bmi < 30) {
return "Overweight";
} else {
return "Obese";
}
}

public static void printWellnessReport(double[] heights, double[] weights) {
System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
for (int i = 0; i < heights.length; i++) {
double bmi = weights[i] / (heights[i] * heights[i]);
String status = getBmiStatus(bmi);
double roundedBmi = Math.round(bmi * 100.0) / 100.0;
System.out.println("Person " + (i + 1) + " | " + heights[i] + " | " + weights[i] + " | " + roundedBmi + " | " + status);
}
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.print("Enter number of people in the team: ");
int teamSize = scanner.nextInt();

double[] heights = new double[teamSize];
double[] weights = new double[teamSize];

for (int i = 0; i < teamSize; i++) {
System.out.print("Person " + (i + 1) + " - Enter height (m): ");
heights[i] = scanner.nextDouble();
System.out.print("Person " + (i + 1) + " - Enter weight (kg): ");
weights[i] = scanner.nextDouble();
}

printWellnessReport(heights, weights);

scanner.close();
}
}