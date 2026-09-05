final class SurgeFeeCalculator {
private final double minimumSurgePercent;

public SurgeFeeCalculator(double minimumSurgePercent) {
this.minimumSurgePercent = minimumSurgePercent;
}

final double calculateSurgeFee(double orderValue, int delayMinutes) {
if (orderValue < 0 || delayMinutes < 0) {
throw new IllegalArgumentException("Negative input not allowed");
}
if (delayMinutes == 0) return 0.0;

double tiered = 0.0;
int m = delayMinutes;

int tier1 = Math.min(m, 5);
tiered += tier1 * 0.005 * orderValue;
m -= tier1;

if (m > 0) {
int tier2 = Math.min(m, 10);
tiered += tier2 * 0.01 * orderValue;
m -= tier2;
}

if (m > 0) {
tiered += m * 0.02 * orderValue;
}

double floor = minimumSurgePercent * 0.01 * orderValue;
return Math.max(tiered, floor);
}

public static void main(String[] args) {
SurgeFeeCalculator calc = new SurgeFeeCalculator(1.0);
System.out.println("Rs " + calc.calculateSurgeFee(500, 0));
System.out.println("Rs " + calc.calculateSurgeFee(500, 1));
System.out.println("Rs " + calc.calculateSurgeFee(500, 16));
}
}