
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int age;
    private String disease;
    private String doctor;

    public Patient(String name, int age, String disease, String doctor) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void displayInfo() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("Disease   : " + disease);
        System.out.println("Doctor    : " + doctor);
        System.out.println("-----------------------------------");
    }
}

public class HospitalManagementSystem {
    private static List<Patient> patients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewAllPatients();
                    break;
                case 3:
                    searchPatientById();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    private static void addPatient() {
        System.out.print("Enter patient's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age;
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter age: ");
            scanner.next();
        }
        age = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter disease: ");
        String disease = scanner.nextLine();

        System.out.print("Enter assigned doctor: ");
        String doctor = scanner.nextLine();

        Patient newPatient = new Patient(name, age, disease, doctor);
        patients.add(newPatient);
        System.out.println("Patient added successfully with ID: " + newPatient.getId());
    }

    private static void viewAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
        } else {
            System.out.println("\n--- All Patients ---");
            for (Patient p : patients) {
                p.displayInfo();
            }
        }
    }

    private static void searchPatientById() {
        System.out.print("Enter patient ID: ");
        int id;
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter ID: ");
            scanner.next();
        }
        id = scanner.nextInt();

        boolean found = false;
        for (Patient p : patients) {
            if (p.getId() == id) {
                System.out.println("\n--- Patient Found ---");
                p.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }
}
