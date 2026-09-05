public class DeliveryAccount {
private String studentId;
private double orderValue;
private static String platformName;

static {
platformName = "Campus Eats";
}

public DeliveryAccount(String studentId, double orderValue) {
this.studentId = studentId;
this.orderValue = orderValue;
}

public DeliveryAccount(String studentId) {
this(studentId, 0.0);
}

final double calculateSurgeFee(int delayMinutes) {
SurgeFeeCalculator calc = new SurgeFeeCalculator(1.0);
return calc.calculateSurgeFee(this.orderValue, delayMinutes);
}

void processAccount(DeliveryAccount account, double amount, int delayMinutes) {
account.orderValue = amount;
double fee = account.calculateSurgeFee(delayMinutes);
System.out.println(account.studentId + " surge fee: " + fee);
}

static class PremiumAccount extends DeliveryAccount {
public PremiumAccount(String studentId, double orderValue) {
super(studentId, orderValue);
}
}

static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
int processed = 0, nullSkipped = 0, premium = 0, regular = 0;
double grandTotal = 0.0;
int len = Math.min(accounts.length, Math.min(amounts.length, delayMinutesArray.length));

for (int i = 0; i < len; i++) {
DeliveryAccount acc = accounts[i];
if (acc == null) {
nullSkipped++;
continue;
}
acc.orderValue = amounts[i];
double fee = acc.calculateSurgeFee(delayMinutesArray[i]);
grandTotal += fee;
processed++;
if (acc instanceof PremiumAccount) {
premium++;
} else {
regular++;
}
}
System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + premium + " premium | " + regular + " regular | grand total surge fees = " + grandTotal);
}

public static void main(String[] args) {
DeliveryAccount[] accounts = {
new PremiumAccount("STU001", 500),
null,
new DeliveryAccount("STU002", 300)
};
double[] amounts = {500, 400, 300};
int[] delayMinutesArray = {10, 5, 0};
processBatch(accounts, amounts, delayMinutesArray);
}
}