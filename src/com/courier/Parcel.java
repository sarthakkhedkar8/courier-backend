package com.courier;

public class Parcel {
    String parcelId;
    String sender;
    String receiver;
    String source;
    String destination;
    String status;

    public Parcel(String parcelId, String sender, String receiver, String source, String destination) {
        this.parcelId = parcelId;
        this.sender = sender;
        this.receiver = receiver;
        this.source = source;
        this.destination = destination;
        this.status = "Pending";
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public void displayParcel() {
        System.out.println("Parcel ID: " + parcelId);
        System.out.println("Sender: " + sender + ", Receiver: " + receiver);
        System.out.println("Source: " + source + ", Destination: " + destination);
        System.out.println("Status: " + status);
    }
}
