class ParkingSlot {
    String slotNo;
    int capacity;
    int occupiedCount;
    ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }
    void allot(String vehicleNo) {
        occupiedCount++;
        System.out.println(vehicleNo + " allotted to slot " + slotNo);
    }
}
public class ParkingSlotApp {
    static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        for (ParkingSlot s : slots) {
            if (s.occupiedCount < s.capacity) return s;
        }
        return null;
    }
    static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot slot = findAvailableSlot(slots);
        if (slot != null) {
            slot.allot(vehicleNo);
        } else {
            System.out.println("No slots available for " + vehicleNo);
        }
    }
    public static void main(String[] args) {
        ParkingSlot[] batch1 = { new ParkingSlot("A1", 4, 3), new ParkingSlot("A2", 5, 5) };
        safeAllot(batch1, "TN09AB1234");
        ParkingSlot[] batch2 = { new ParkingSlot("A1", 4, 4), new ParkingSlot("A2", 5, 5) };
        safeAllot(batch2, "TN09AB1234");
    }
}