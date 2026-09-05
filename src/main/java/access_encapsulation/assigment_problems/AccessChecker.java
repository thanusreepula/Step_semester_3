public class AccessChecker {

static String classifyAccess(String fieldModifier, String accessorContext) {
switch (fieldModifier) {
case "private":
return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
case "default":
return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE"))
? "ALLOWED" : "DENIED";
case "protected":
if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) {
return "ALLOWED";
}
if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
return "ALLOWED";
}
if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {
return "DENIED";
}
return "DENIED";
case "public":
return "ALLOWED";
default:
return "DENIED";
}
}

static String summarizeByModifier(String[][] attempts) {
java.util.Map<String, int[]> counts = new java.util.LinkedHashMap<>();
String[] order = {"private", "default", "protected", "public"};
for (String mod : order) counts.put(mod, new int[]{0, 0});

for (String[] row : attempts) {
String mod = row[0];
String result = classifyAccess(row[0], row[1]);
int[] c = counts.get(mod);
if (result.equals("ALLOWED")) c[0]++;
else c[1]++;
}

StringBuilder sb = new StringBuilder();
for (int i = 0; i < order.length; i++) {
int[] c = counts.get(order[i]);
sb.append(order[i]).append(": ").append(c[0]).append(" allowed / ").append(c[1]).append(" denied");
if (i != order.length - 1) sb.append(" | ");
}
return sb.toString();
}

static String describeContext(String accessorContext) {
String[] parts = accessorContext.split("_");
StringBuilder sb = new StringBuilder();
for (int i = 0; i < parts.length; i++) {
String word = parts[i].toLowerCase();
sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
if (i != parts.length - 1) sb.append(" ");
}
return sb.toString();
}

public static void main(String[] args) {
System.out.println(classifyAccess("private", "SAME_CLASS"));
System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
System.out.println(summarizeByModifier(new String[][]{
{"private","SAME_CLASS"}, {"private","SAME_PACKAGE"},
{"default","SAME_PACKAGE"}, {"default","DIFFERENT_PACKAGE"},
{"protected","SAME_PACKAGE"}, {"protected","SAME_CLASS"},
{"public","DIFFERENT_PACKAGE"}
}));
System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
System.out.println(describeContext("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
}
}