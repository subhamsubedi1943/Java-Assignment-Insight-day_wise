package com.ig.ui;

import com.ig.service.ScholarService;
import com.ig.model.Scholar;
import com.ig.exception.ScholarNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws ScholarNotFoundException {
        ScholarService service = new ScholarService();
        Scanner scanner = new Scanner(System.in);
        
        try {
            service.addHardcodedScholars();
        } catch (SQLException e) {
            System.out.println("⚠️ Error adding default scholars: " + e.getMessage());
        }

        while (true) {
            System.out.println("\n📌 Scholar Management System");
            System.out.println("1. List All Scholars");
            System.out.println("2. Get Scholar by ID");
            System.out.println("3. Add Scholar");
            System.out.println("4. Update Scholar Email");
            System.out.println("5. Delete Scholar");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        listAllScholars(service);
                        break;
                    case 2:
                        getOneScholar(service, scanner);
                        break;
                    case 3:
                        addScholar(service, scanner);
                        break;
                    case 4:
                        updateScholarEmail(service, scanner);
                        break;
                    case 5:
                        deleteScholar(service, scanner);
                        break;
                    case 6:
                        System.out.println("Exiting the system. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("❌ Invalid choice! Please try again.");
                }
            } catch (SQLException | ScholarNotFoundException e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }

    private static void listAllScholars(ScholarService service) throws SQLException {
        List<Scholar> scholars = service.listAllScholars();
        if (scholars.isEmpty()) {
            System.out.println("⚠️ No scholars found in the database.");
        } else {
            System.out.println("\n📋 List of Scholars:");
            for (Scholar s : scholars) {
                System.out.println(s);
            }
        }
    }

    private static void getOneScholar(ScholarService service, Scanner scanner) throws SQLException, ScholarNotFoundException {
        System.out.print("🔍 Enter Scholar ID: ");
        int scholarId = scanner.nextInt();
        scanner.nextLine();
        Scholar scholar = service.getOneScholar(scholarId);
        System.out.println("✅ Found: " + scholar);
    }

    private static void addScholar(ScholarService service, Scanner scanner) throws SQLException {
        System.out.print("🆕 Enter Scholar ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Mobile: ");
        String mobile = scanner.nextLine();

        Scholar scholar = new Scholar(id, name, email, mobile);
        service.addScholar(scholar);
        System.out.println("✅ Scholar added successfully!");
    }

    private static void updateScholarEmail(ScholarService service, Scanner scanner) throws SQLException, ScholarNotFoundException {
        System.out.print("✏️ Enter Scholar ID to update: ");
        int scholarId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Email: ");
        String newEmail = scanner.nextLine();

        service.updateScholarEmail(scholarId, newEmail);
        System.out.println("✅ Scholar email updated successfully!");
    }

    private static void deleteScholar(ScholarService service, Scanner scanner) throws SQLException, ScholarNotFoundException {
        System.out.print("🗑️ Enter Scholar ID to delete: ");
        int scholarId = scanner.nextInt();
        scanner.nextLine();

        service.deleteScholarById(scholarId);
        System.out.println("✅ Scholar deleted successfully!");
    }
}
