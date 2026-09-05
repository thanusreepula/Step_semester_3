
public class DischargeSummary {
private final String patientId;
private final String[] medicationCodes;
private static String hospitalName;

static {
hospitalName = "MediTrack Clinic";
}

public DischargeSummary(String patientId, String[] medicationCodes) {
for (String code : medicationCodes) {
if (!isValidCode(code)) {
throw new IllegalArgumentException("Invalid medication code: " + code);
}
}
this.patientId = patientId;
this.medicationCodes = medicationCodes.clone();
}

private static boolean isValidCode(String code) {
if (code == null || code.length() != 5) return false;
if (!code.startsWith("MED-")) return false;
char last = code.charAt(4);
return Character.isUpperCase(last) && Character.isLetter(last);
}

String[] getMedicationCodes() {
return medicationCodes.clone();
}

DischargeSummary withCorrectedMedication(int index, String newCode) {
String[] updated = medicationCodes.clone();
updated[index] = newCode;
return new DischargeSummary(this.patientId, updated);
}

static class CriticalCareDischargeSummary extends DischargeSummary {
private final int icuDays;

public CriticalCareDischargeSummary(String patientId, String[] medicationCodes, int icuDays) {
super(patientId, medicationCodes);
this.icuDays = icuDays;
}
}

static String processNightlyBatch(DischargeSummary[] summaries) {
int processed = 0, nullSkipped = 0, critical = 0, routine = 0;
for (DischargeSummary s : summaries) {
if (s == null) {
nullSkipped++;
continue;
}
processed++;
if (s instanceof CriticalCareDischargeSummary) {
critical++;
} else {
routine++;
}
}
return processed + " processed | " + nullSkipped + " null skipped | " + critical + " critical-care | " + routine + " routine";
}

public static void main(String[] args) {
try {
new DischargeSummary("MT2026-0142", new String[]{"MED-A", "bad"});
System.out.println("construction succeeded");
} catch (IllegalArgumentException e) {
System.out.println("construction rejected");
}

DischargeSummary d = new DischargeSummary("MT2026-0142", new String[]{"MED-A","MED-B"});
String[] codes = d.getMedicationCodes();
codes[0] = "TAMPERED";
System.out.println(d.getMedicationCodes()[0]);

System.out.println(processNightlyBatch(new DischargeSummary[]{
new CriticalCareDischargeSummary("MT001", new String[]{"MED-X"}, 4),
null,
new DischargeSummary("MT002", new String[]{"MED-Y"})
}));
}
}