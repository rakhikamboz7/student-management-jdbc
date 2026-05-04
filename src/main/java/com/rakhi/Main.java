package com.rakhi;
import java.util.Scanner;


public class Main {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        System.out.println(service);

        while (true) {
            System.out.println("Using service: " + service);
            System.out.println("\n----- Student Management-----");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Search Student by Id");
            System.out.println("4. Delete Student by Id");
            System.out.println("5. Update Student Info");
            System.out.println("6. Exit");

            System.out.print("Choose Option: ");

            int choice = Integer.parseInt(sc.nextLine());
            if(choice == 1) {

                System.out.println("Enter ID: ");
                int id = Integer.parseInt(sc.nextLine());

                System.out.println("Enter Name: ");
                String name = sc.nextLine();

                System.out.println("Enter Age: ");
                int age = Integer.parseInt(sc.nextLine());

                Student student = new Student(id, name, age);  //Object creation
                service.addStudent(student);

            } else if (choice ==2) {
                service.showAllStudents();
            } else if (choice ==3) {
                System.out.println("Enter Student Id: ");
                int id = Integer.parseInt(sc.nextLine());
                service.searchStudent(id);
                System.out.println("Press Enter to continue...");
                sc.nextLine();

            }
            else if (choice ==4){
                System.out.println("Enter Student Id: ");
                int id = Integer.parseInt(sc.nextLine());
                service.deleteStudent(id);

            }
            else if(choice ==5) {
                System.out.println("Enter Student Id to update:");
                int id = Integer.parseInt(sc.nextLine());

                System.out.println("Enter New Name: ");
                String newName = sc.nextLine();

                System.out.println("Enter New Age: ");
                int newAge = Integer.parseInt(sc.nextLine());

                service.updateStudent(id, newName, newAge);
            }
            else if (choice == 6) {
                System.out.println("Exiting App...");
                break;
            }
            else {
                System.out.println("Invalid Choice");
            }
        }
        sc.close();


    }

}
