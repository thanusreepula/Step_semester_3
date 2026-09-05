public class PatientRecord {
private String patientId;
private String wardCode;
private double vitalsScore;
private String facilityName;

public PatientRecord(String patientId, String wardCode, double vitalsScore, String facilityName) {
if (patientId == null || patientId.trim().isEmpty() || patientId.trim().length() < 4) {
throw new IllegalArgumentException("Invalid patientId");
}
this.patientId = patientId.trim();
this.wardCode = wardCode;
this.vitalsScore = vitalsScore;
this.facilityName = facilityName;
}

public static void main(String[] args) {
try {
new PatientRecord("MT9", "W3", 98.2, "MediTrack Central");
System.out.println("construction succeeded");
} catch (IllegalArgumentException e) {
System.out.println("construction rejected");
}

try {
PatientRecord p = new PatientRecord("MT94", "W3", 98.2, "MediTrack Central");
System.out.println("construction succeeded");
} catch (IllegalArgumentException e) {
System.out.println("construction rejected");
}
}
}