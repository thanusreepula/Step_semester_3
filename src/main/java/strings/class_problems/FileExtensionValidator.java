public class FileExtensionValidator {
String validateFileExtension(String filename) {
int dotIndex = filename.lastIndexOf('.');
if (dotIndex == -1) return "Rejected — invalid file type";
String ext = filename.substring(dotIndex + 1);
if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
return "Accepted";
}
return "Rejected — invalid file type";
}

public static void main(String[] args) {
FileExtensionValidator v = new FileExtensionValidator();
System.out.println(v.validateFileExtension("Assignment1.PDF"));
System.out.println(v.validateFileExtension("notes.txt"));
}
}