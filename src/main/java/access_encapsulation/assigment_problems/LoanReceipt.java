public class LoanReceipt {
private final String memberId;
private final String[] bookIds;
private static String libraryName;

static {
libraryName = "PageTurner Library";
}

public LoanReceipt(String memberId, String[] bookIds) {
for (String id : bookIds) {
if (!isValidBookId(id)) {
throw new IllegalArgumentException("Invalid book ID: " + id);
}
}
this.memberId = memberId;
this.bookIds = bookIds.clone();
}

private static boolean isValidBookId(String id) {
if (id == null || id.length() != 6) return false;
if (!id.startsWith("BK-")) return false;
for (int i = 3; i < 6; i++) {
if (!Character.isDigit(id.charAt(i))) return false;
}
return true;
}

String[] getBookIds() {
return bookIds.clone();
}

LoanReceipt withCorrectedBookId(int index, String newId) {
String[] updated = bookIds.clone();
updated[index] = newId;
return new LoanReceipt(this.memberId, updated);
}

static class ReferenceOnlyLoanReceipt extends LoanReceipt {
private final String roomNumber;

public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
super(memberId, bookIds);
this.roomNumber = roomNumber;
}
}

static String processNightlyCirculation(LoanReceipt[] receipts) {
int processed = 0, nullSkipped = 0, referenceOnly = 0, regular = 0;
for (LoanReceipt r : receipts) {
if (r == null) {
nullSkipped++;
continue;
}
processed++;
if (r instanceof ReferenceOnlyLoanReceipt) {
referenceOnly++;
} else {
regular++;
}
}
return processed + " processed | " + nullSkipped + " null skipped | " + referenceOnly + " reference-only | " + regular + " regular";
}

public static void main(String[] args) {
try {
new LoanReceipt("LIB-8841", new String[]{"BK-100", "bad"});
System.out.println("construction succeeded");
} catch (IllegalArgumentException e) {
System.out.println("construction rejected");
}

LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100","BK-101"});
String[] ids = r.getBookIds();
ids[0] = "HACKED";
System.out.println(r.getBookIds()[0]);

System.out.println(processNightlyCirculation(new LoanReceipt[]{
new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
null,
new LoanReceipt("LIB-002", new String[]{"BK-201"})
}));
}
}