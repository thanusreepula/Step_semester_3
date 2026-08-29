import java.util.Scanner;

public class Problem3 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
if (!scanner.hasNext()) {
scanner.close();
return;
}
String studentName = scanner.next();

HostelRoom[] rooms1 = {
new HostelRoom("C-214", 3, 2),
new HostelRoom("C-507", 2, 2)
};
safeAllot(rooms1, studentName);

HostelRoom[] rooms2 = {
new HostelRoom("C-214", 3, 3),
new HostelRoom("C-507", 2, 2)
};
safeAllot(rooms2, studentName);

scanner.close();
}

static HostelRoom findAvailableRoom(HostelRoom[] rooms) {
if (rooms == null) return null;
for (HostelRoom room : rooms) {
if (room.occupied < room.beds) {
return room;
}
}
return null;
}

static void safeAllot(HostelRoom[] rooms, String studentName) {
HostelRoom room = findAvailableRoom(rooms);
if (room != null) {
room.allot(studentName);
} else {
System.out.println("No rooms available for " + studentName);
}
}
}

class HostelRoom {
String roomNo;
int beds;
int occupied;

HostelRoom(String roomNo, int beds, int occupied) {
this.roomNo = roomNo;
this.beds = beds;
this.occupied = occupied;
}

void allot(String name) {
if (occupied < beds) {
occupied++;
System.out.println(name + " allotted to room " + roomNo);
}
}
}