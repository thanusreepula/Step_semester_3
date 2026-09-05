

public class AccessRuleEngine {

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

static String summarizeBatch(String[][] attempts) {
int allowed = 0, denied = 0;
for (String[] row : attempts) {
String result = classifyAccess(row[0], row[1]);
if (result.equals("ALLOWED")) {
allowed++;
} else {
denied++;
}
}
return "Allowed: " + allowed + " | Denied: " + denied;
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
System.out.println(classifyAccess("default", "DIFFERENT_PACKAGE"));
System.out.println(summarizeBatch(new String[][]{
{"protected","SAME_PACKAGE"},
{"protected","DIFFERENT_PACKAGE"},
{"public","DIFFERENT_PACKAGE"}
}));
System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
System.out.println(describeContext("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
}
}