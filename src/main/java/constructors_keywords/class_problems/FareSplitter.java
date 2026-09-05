public class FareSplitter {
private String tripId;
private double totalFare;
private int passengerCount;

public FareSplitter(String tripId, double totalFare, int passengerCount) {
if (totalFare < 0) throw new IllegalArgumentException("Negative fare");
if (passengerCount <= 0) throw new IllegalArgumentException("Invalid passenger count");
this.tripId = tripId;
this.totalFare = totalFare;
this.passengerCount = passengerCount;
}

public FareSplitter(String tripId, double totalFare) {
this(tripId, totalFare, 2);
}

public FareSplitter(String tripId) {
this(tripId, 0.0, 2);
}

double[] fareBreakdown() {
double[] shares = new double[passengerCount];
long totalPaise = Math.round(totalFare * 100);
long basePaise = totalPaise / passengerCount;
long remainder = totalPaise - (basePaise * passengerCount);

for (int i = 0; i < passengerCount; i++) {
shares[i] = basePaise / 100.0;
}
shares[passengerCount - 1] += remainder / 100.0;
return shares;
}

boolean isConfirmationOverdue(int confirmed, int expected) {
return confirmed < expected;
}

public static void main(String[] args) {
double[] r1 = new FareSplitter("TRIP001", 100000, 3).fareBreakdown();
for (double d : r1) System.out.print(d + " ");
System.out.println();

double[] r2 = new FareSplitter("TRIP003").fareBreakdown();
for (double d : r2) System.out.print(d + " ");
System.out.println();
}
}