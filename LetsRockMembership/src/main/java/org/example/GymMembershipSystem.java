import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Member {
    private String name;
    private String memberNumber;
    private String email;
    private String phoneNumber;

    public Member(String name, String memberNumber, String email, String phoneNumber) {
        this.name = name;
        this.memberNumber = memberNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return " Name: " + name + ",\n Member ID#: " + memberNumber + ",\n Email: " + email + ",\n Phone Number: " + phoneNumber;
    }
}

public class GymMembershipSystem {
    private List<Member> members;

    public GymMembershipSystem() {
        members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void displayMembers() {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GymMembershipSystem membershipSystem = new GymMembershipSystem();

        System.out.println("Welcome to the 'Let's Rock' Climbing Gym Membership System!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Member");
            System.out.println("2. Display Members");
            System.out.println("3. Quit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter member ID number: ");
                    String memberNumber = scanner.nextLine();
//                    scanner.nextLine(); // Consume newline character

                    System.out.print("Enter member email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter member phone number: ");
                    String phoneNumber = scanner.nextLine();

                    Member member = new Member(name, memberNumber, email, phoneNumber);
                    membershipSystem.addMember(member);

                    System.out.println("Member added successfully!");
                    break;

                case 2:
                    System.out.println("\nList of Members:");
                    membershipSystem.displayMembers();
                    break;

                case 3:
                    System.out.println("Thank you for visiting us at 'Let's Rock!' Climbing Gym. Have a great day. \n Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
