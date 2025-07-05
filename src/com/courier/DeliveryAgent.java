package com.courier;

public class DeliveryAgent {
    String agentId;
    String name;
    String contact;

    public DeliveryAgent(String agentId, String name, String contact) {
        this.agentId = agentId;
        this.name = name;
        this.contact = contact;
    }

    public void displayAgent() {
        System.out.println("Agent ID: " + agentId + ", Name: " + name + ", Contact: " + contact);
    }
}
