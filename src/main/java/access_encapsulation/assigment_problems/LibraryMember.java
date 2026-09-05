public class LibraryMember {
private String membershipId;
private String branchCode;
private double finesOwed;
private String displayName;

public LibraryMember(String membershipId, String branchCode, double finesOwed, String displayName) {
if (membershipId == null || membershipId.trim().isEmpty() || membershipId.trim().length() < 4) {
throw new IllegalArgumentException("Invalid membershipId");
}
this.membershipId = membershipId.trim();
this.branchCode = branchCode;
this.finesOwed = finesOwed;
this.displayName = displayName;
}

public static void main(String[] args) {
try {
new LibraryMember("LB9", "BR1", 0, "Priya Nair");
System.out.println("construction succeeded");
} catch (IllegalArgumentException e) {
System.out.println("construction rejected");
}

try {
LibraryMember m = new LibraryMember("LB94", "BR1", 0, "Priya Nair");
System.out.println("construction succeeded");
} catch (IllegalArgumentException e) {
System.out.println("construction rejected");
}
}
}