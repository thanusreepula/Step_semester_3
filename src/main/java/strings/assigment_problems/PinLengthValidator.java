public class PinLengthValidator {
void checkPinLength(String pin) {
if (pin.length() != 4) {
System.out.println("Invalid PIN — must be exactly 4 digits.");
} else {
System.out.println("PIN length OK.");
}
}

public static void main(String[] args) {
PinLengthValidator v = new PinLengthValidator();
v.checkPinLength("482");
v.checkPinLength("4820");
}
}