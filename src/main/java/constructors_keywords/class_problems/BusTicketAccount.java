public class BusTicketAccount {
private String bookingId;
private double ticketFare;
private static String depotName;

static {
depotName = "Central Depot";
}

public BusTicketAccount(String bookingId, double ticketFare) {
this.bookingId = bookingId;
this.ticketFare = ticketFare;
}

public BusTicketAccount(String bookingId) {
this(bookingId, 0.0);
}

final double calculatePenalty(int minutesLate) {
BoardingPenaltyCalculator calc = new BoardingPenaltyCalculator(1.0);
return calc.calculatePenalty(this.ticketFare, minutesLate);
}

void processAccount(BusTicketAccount account, double amount, int minutesLate) {
account.ticketFare = amount;
double penalty = account.calculatePenalty(minutesLate);
System.out.println(account.bookingId + " penalty: " + penalty);
}

static class SleeperTicketAccount extends BusTicketAccount {
public SleeperTicketAccount(String bookingId, double ticketFare) {
super(bookingId, ticketFare);
}
}

static void processBatch(BusTicketAccount[] accounts, double[] amounts, int[] minutesLateArray) {
int processed = 0, nullSkipped = 0, sleeper = 0, regular = 0;
double grandTotal = 0.0;
int len = Math.min(accounts.length, Math.min(amounts.length, minutesLateArray.length));

for (int i = 0; i < len; i++) {
BusTicketAccount acc = accounts[i];
if (acc == null) {
nullSkipped++;
continue;
}
acc.ticketFare = amounts[i];
double penalty = acc.calculatePenalty(minutesLateArray[i]);
grandTotal += penalty;
processed++;
if (acc instanceof SleeperTicketAccount) {
sleeper++;
} else {
regular++;
}
}
System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + sleeper + " sleeper | " + regular + " regular | grand total penalties = " + grandTotal);
}

public static void main(String[] args) {
BusTicketAccount[] accounts = {
new SleeperTicketAccount("BK001", 2000),
null,
new BusTicketAccount("BK002", 1200)
};
double[] amounts = {1200, 900, 700};
int[] minutesLateArray = {10, 5, 0};
processBatch(accounts, amounts, minutesLateArray);
}
}