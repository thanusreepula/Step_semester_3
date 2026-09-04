public class BankReferenceGeneratorValidator {
String normalizeReference(String raw) {
String trimmed = raw.trim();
String prefix = trimmed.substring(0, 3).toUpperCase();
return prefix + trimmed.substring(3);
}

String validateAndFormat(String reference) {
if (reference.length() != 14) {
return "Invalid: wrong length";
}
String bankCode = reference.substring(0, 3);
String body = reference.substring(3);

for (int i = 0; i < bankCode.length(); i++) {
if (!Character.isLetter(bankCode.charAt(i))) {
return "Invalid: bank code must be 3 letters";
}
}
for (int i = 0; i < body.length(); i++) {
if (!Character.isDigit(body.charAt(i))) {
return "Invalid: body must be digits";
}
}

String date = body.substring(0, 6);
String seq = body.substring(6);
String dd = date.substring(0, 2);
String mm = date.substring(2, 4);
String yy = date.substring(4, 6);

StringBuilder sb = new StringBuilder();
sb.append("[").append(bankCode).append("] DATE: ")
.append(dd).append("/").append(mm).append("/").append(yy)
.append(" | SEQ: ").append(seq);
return sb.toString();
}

public static void main(String[] args) {
BankReferenceGeneratorValidator b = new BankReferenceGeneratorValidator();
String norm = b.normalizeReference(" hdf03022600042 ");
System.out.println(b.validateAndFormat(norm));
System.out.println(b.validateAndFormat("12F03022600042"));
}
}