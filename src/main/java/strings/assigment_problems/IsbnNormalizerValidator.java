public class IsbnNormalizerValidator {
String normalizeCode(String raw) {
String trimmed = raw.trim();
String prefix = trimmed.substring(0, 3).toUpperCase();
return prefix + trimmed.substring(3);
}

String validateAndFormat(String code) {
if (code.length() != 13) {
return "Invalid: wrong length";
}
String pubCode = code.substring(0, 3);
String body = code.substring(3);

for (int i = 0; i < pubCode.length(); i++) {
if (!Character.isLetter(pubCode.charAt(i))) {
return "Invalid: publisher code must be 3 letters";
}
}
for (int i = 0; i < body.length(); i++) {
if (!Character.isDigit(body.charAt(i))) {
return "Invalid: non-digit body";
}
}

String year = body.substring(0, 4);
String catalog = body.substring(4);

StringBuilder sb = new StringBuilder();
sb.append("[").append(pubCode).append("] YEAR: ").append(year)
.append(" | CATALOG: ").append(catalog);
return sb.toString();
}

public static void main(String[] args) {
IsbnNormalizerValidator v = new IsbnNormalizerValidator();
String norm = v.normalizeCode(" pen2026004251 ");
System.out.println(v.validateAndFormat(norm));
System.out.println(v.validateAndFormat("12N2026004251"));
}
}