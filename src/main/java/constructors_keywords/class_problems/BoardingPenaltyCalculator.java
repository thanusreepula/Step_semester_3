final class BoardingPenaltyCalculator {
private final double minimumPenaltyPercent;

public BoardingPenaltyCalculator(double minimumPenaltyPercent) {
this.minimumPenaltyPercent = minimumPenaltyPercent;
}

final double calculatePenalty(double ticketFare, int minutesLate) {
if (ticketFare < 0 || minutesLate < 0) {
throw new IllegalArgumentException("Negative input not allowed");
}
if (minutesLate == 0) return 0.0;

double tiered = 0.0;
int m = minutesLate;

int tier1 = Math.min(m, 5);
tiered += tier1 * 0.005 * ticketFare;
m -= tier1;

if (m > 0) {
int tier2 = Math.min(m, 10);
tiered += tier2 * 0.01 * ticketFare;
m -= tier2;
}

if (m > 0) {
tiered += m * 0.02 * ticketFare;
}

double floor = minimumPenaltyPercent * 0.01 * ticketFare;
return Math.max(tiered, floor);
}

public static void main(String[] args) {
BoardingPenaltyCalculator calc = new BoardingPenaltyCalculator(1.0);
System.out.println("Rs " + calc.calculatePenalty(1000, 0));
System.out.println("Rs " + calc.calculatePenalty(1000, 1));
System.out.println("Rs " + calc.calculatePenalty(1000, 16));
}
}