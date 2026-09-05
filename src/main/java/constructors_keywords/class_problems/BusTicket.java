import java.util.*;

public class BusTicket {
private String passengerName;
private String destination;
private boolean checkedIn = false;

public BusTicket(String passengerName, String destination) {
if (passengerName == null || passengerName.trim().isEmpty()) {
throw new IllegalArgumentException("Invalid passenger name");
}
if (destination == null || destination.trim().isEmpty()) {
throw new IllegalArgumentException("Invalid destination");
}
this.passengerName = passengerName.trim();
this.destination = destination.trim();
}

void markCheckedIn() {
if (checkedIn) {
System.out.println("Already checked in!");
return;
}
checkedIn = true;
System.out.println("Checked in successfully.");
}

static void processBatch(String[][] rawBookings) {
int valid = 0, rejected = 0, duplicates = 0;
Set<String> seen = new HashSet<>();

for (String[] entry : rawBookings) {
String name = entry[0];
String dest = entry[1];
try {
BusTicket t = new BusTicket(name, dest);
String key = t.passengerName + "|" + t.destination;
if (seen.contains(key)) {
duplicates++;
} else {
seen.add(key);
valid++;
}
} catch (IllegalArgumentException e) {
rejected++;
}
}
System.out.println("Valid: " + valid + " | Rejected: " + rejected + " | Duplicates skipped: " + duplicates);
}

public static void main(String[] args) {
String[][] bookings = {
{"Divya","Chennai"}, {"","Bangalore"}, {"Ravi123","Pune"},
{"Divya","Chennai"}, {" "," "}
};
processBatch(bookings);
}
}