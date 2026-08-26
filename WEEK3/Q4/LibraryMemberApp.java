class BrokenLibraryMember {
    static String name;
    static String memberId;
    static int booksIssued;
    BrokenLibraryMember(String name, String memberId, int booksIssued) {
        BrokenLibraryMember.name = name;
        BrokenLibraryMember.memberId = memberId;
        BrokenLibraryMember.booksIssued = booksIssued;
    }
}
class LibraryMember {
    String name;
    String memberId;
    int booksIssued;
    static String libraryName = "City Central Library";
    static int memberCount = 0;
    LibraryMember(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
        memberCount++;
        this.memberId = "LM-" + (1000 + memberCount);
    }
    void printMemberCard() {
        System.out.println(name + " | " + memberId);
    }
    static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }
}
public class LibraryMemberApp {
    public static void main(String[] args) {
        System.out.println("--- Broken version ---");
        BrokenLibraryMember aditi = new BrokenLibraryMember("Aditi", "LM-1001", 2);
        BrokenLibraryMember rohan = new BrokenLibraryMember("Rohan", "LM-1002", 1);
        System.out.println(BrokenLibraryMember.name);
        System.out.println(BrokenLibraryMember.name);
        System.out.println("(Aditi's data was overwritten — both members now show \"Rohan\")");
        System.out.println("--- Fixed version ---");
        LibraryMember aditi2 = new LibraryMember("Aditi", 2);
        LibraryMember rohan2 = new LibraryMember("Rohan", 1);
        aditi2.printMemberCard();
        rohan2.printMemberCard();
        LibraryMember.printTotalMembers();
    }
}