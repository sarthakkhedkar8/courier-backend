import java.util.*;

class DeliveryAgent {
    String agentId, name, contact;

    public DeliveryAgent(String agentId, String name, String contact) {
        this.agentId = agentId;
        this.name = name;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return name + " (ID: " + agentId + ", Contact: " + contact + ")";
    }
}

class Parcel {
    String parcelId;
    String senderName, receiverName;
    String source, destination;
    String status; // pending, dispatched, in-transit, delivered
    DeliveryAgent agent;

    public Parcel(String parcelId, String senderName, String receiverName, String source, String destination) {
        this.parcelId = parcelId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.source = source;
        this.destination = destination;
        this.status = "Pending";
    }

    public void assignAgent(DeliveryAgent agent) {
        this.agent = agent;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Parcel ID: " + parcelId + "\nSender: " + senderName + "\nReceiver: " + receiverName +
               "\nFrom: " + source + " To: " + destination + "\nStatus: " + status +
               (agent != null ? "\nAgent: " + agent : "\nAgent: Not Assigned");
    }
}

public class CourierTrackingSystem {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Parcel> parcelMap = new HashMap<>();
    static Map<String, DeliveryAgent> agentMap = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Courier Tracking System ---");
            System.out.println("1. Add Parcel");
            System.out.println("2. Assign Delivery Agent");
            System.out.println("3. Update Parcel Status");
            System.out.println("4. Search Parcel by ID");
            System.out.println("5. List All Parcels");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addParcel();
                case 2 -> assignAgent();
                case 3 -> updateStatus();
                case 4 -> searchParcel();
                case 5 -> listParcels();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addParcel() {
        System.out.print("Enter Parcel ID: ");
        String id = sc.nextLine();
        if (parcelMap.containsKey(id)) {
            System.out.println("Parcel with this ID already exists.");
            return;
        }

        System.out.print("Sender Name: ");
        String sender = sc.nextLine();
        System.out.print("Receiver Name: ");
        String receiver = sc.nextLine();
        System.out.print("Source: ");
        String source = sc.nextLine();
        System.out.print("Destination: ");
        String dest = sc.nextLine();

        Parcel parcel = new Parcel(id, sender, receiver, source, dest);
        parcelMap.put(id, parcel);
        System.out.println("Parcel added successfully!");
    }

    static void assignAgent() {
        System.out.print("Enter Parcel ID: ");
        String parcelId = sc.nextLine();
        Parcel parcel = parcelMap.get(parcelId);
        if (parcel == null) {
            System.out.println("Parcel not found.");
            return;
        }

        System.out.print("Enter Agent ID: ");
        String agentId = sc.nextLine();

        DeliveryAgent agent = agentMap.get(agentId);
        if (agent == null) {
            System.out.print("Enter Agent Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Agent Contact: ");
            String contact = sc.nextLine();
            agent = new DeliveryAgent(agentId, name, contact);
            agentMap.put(agentId, agent);
        }

        parcel.assignAgent(agent);
        System.out.println("Agent assigned successfully!");
    }

    static void updateStatus() {
        System.out.print("Enter Parcel ID: ");
        String id = sc.nextLine();
        Parcel parcel = parcelMap.get(id);
        if (parcel == null) {
            System.out.println("Parcel not found.");
            return;
        }

        System.out.print("Enter new status (Pending/Dispatched/In-Transit/Delivered): ");
        String status = sc.nextLine();
        parcel.updateStatus(status);
        System.out.println("Status updated!");
    }

    static void searchParcel() {
        System.out.print("Enter Parcel ID: ");
        String id = sc.nextLine();
        Parcel parcel = parcelMap.get(id);
        if (parcel == null) {
            System.out.println("Parcel not found.");
            return;
        }
        System.out.println("\n" + parcel);
    }

    static void listParcels() {
        if (parcelMap.isEmpty()) {
            System.out.println("No parcels found.");
            return;
        }

        System.out.print("Filter by status? (yes/no): ");
        String filter = sc.nextLine();

        String statusFilter = null;
        if (filter.equalsIgnoreCase("yes")) {
            System.out.print("Enter status to filter (Pending/In-Transit/Delivered): ");
            statusFilter = sc.nextLine();
        }

        for (Parcel parcel : parcelMap.values()) {
            if (statusFilter == null || parcel.status.equalsIgnoreCase(statusFilter)) {
                System.out.println("\n" + parcel);
            }
        }
    }
}
