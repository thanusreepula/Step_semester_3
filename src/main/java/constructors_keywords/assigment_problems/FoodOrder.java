public class FoodOrder {
private String studentName;
private String dishName;
private boolean delivered = false;

public FoodOrder(String studentName, String dishName) {
if (studentName == null || studentName.trim().isEmpty()) {
throw new IllegalArgumentException("Invalid student name");
}
if (dishName == null || dishName.trim().isEmpty()) {
throw new IllegalArgumentException("Invalid dish name");
}
this.studentName = studentName.trim();
this.dishName = dishName.trim();
}

void markDelivered() {
if (delivered) {
System.out.println("Already delivered! Possible double-serve.");
return;
}
delivered = true;
System.out.println("Order delivered.");
}

static void processBatch(String[][] rawOrders) {
int valid = 0, rejected = 0;
for (String[] entry : rawOrders) {
try {
new FoodOrder(entry[0], entry[1]);
valid++;
} catch (IllegalArgumentException e) {
rejected++;
}
}
System.out.println("Valid: " + valid + " | Rejected: " + rejected);
}

public static void main(String[] args) {
String[][] orders = {
{"Ravi","Paneer Butter Masala"}, {"","Chole Bhature"},
{"Meera"," "}, {"Divya","Veg Biryani"}
};
processBatch(orders);
}
}