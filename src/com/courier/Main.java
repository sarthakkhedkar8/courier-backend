package com.courier;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourierManager manager = new CourierManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Courier Management System ---");
            System.out.println("1. Add Parcel");
            System.out.println("2. Assign Delivery Agent");
            System.out.println("3. Update Parcel Status");
            System.out.println("4. View Parcel Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Parcel ID: ");
                    String pid = sc.nextLine();
                    System.out.print("Sender Name: ");
                    String sender = sc.nextLine();
                    System.out.print("Receiver Name: ");
                    String receiver = sc.nextLine();
                    System.out.print("Source: ");
                    String source = sc.nextLine();
                    System.out.print("Destination: ");
                    String dest = sc.nextLine();
                    Parcel parcel = new Parcel(pid, sender, receiver, source, dest);
                    manager.addParcel(parcel);
                    break;

                case 2:
                    System.out.print("Enter Parcel ID to assign agent: ");
                    String parcelId = sc.nextLine();
                    System.out.print("Agent ID: ");
                    String aid = sc.nextLine();
                    System.out.print("Agent Name: ");
                    String name = sc.nextLine();
                    System.out.print("Contact: ");
                    String contact = sc.nextLine();
                    DeliveryAgent agent = new DeliveryAgent(aid, name, contact);
                    manager.assignAgent(parcelId, agent);
                    break;

                case 3:
                    System.out.print("Enter Parcel ID to update status: ");
                    String updateId = sc.nextLine();
                    System.out.print("Enter new status (Pending/In-transit/Delivered): ");
                    String status = sc.nextLine();
                    manager.updateStatus(updateId, status);
                    break;

                case 4:
                    System.out.print("Enter Parcel ID to view details: ");
                    String viewId = sc.nextLine();
                    manager.viewParcel(viewId);
                    break;

                case 5:
                    System.out.println("Exiting. Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
