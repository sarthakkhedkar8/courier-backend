package com.courier;

import java.util.*;

public class CourierManager {
    private Map<String, Parcel> parcels = new HashMap<>();
    private Map<String, DeliveryAgent> agents = new HashMap<>();

    public void addParcel(Parcel parcel) {
        parcels.put(parcel.parcelId, parcel);
        System.out.println("Parcel added successfully!");
    }

    public void assignAgent(String parcelId, DeliveryAgent agent) {
        if (parcels.containsKey(parcelId)) {
            agents.put(parcelId, agent);
            System.out.println("Agent assigned to parcel " + parcelId);
        } else {
            System.out.println("Parcel not found.");
        }
    }

    public void updateStatus(String parcelId, String status) {
        Parcel parcel = parcels.get(parcelId);
        if (parcel != null) {
            parcel.updateStatus(status);
            System.out.println("Status updated.");
        } else {
            System.out.println("Parcel not found.");
        }
    }

    public void viewParcel(String parcelId) {
        Parcel parcel = parcels.get(parcelId);
        DeliveryAgent agent = agents.get(parcelId);
        if (parcel != null) {
            parcel.displayParcel();
            if (agent != null) {
                System.out.print("Assigned Agent: ");
                agent.displayAgent();
            } else {
                System.out.println("No agent assigned yet.");
            }
        } else {
            System.out.println("Parcel not found.");
        }
    }
}
