package com.example.projectpulse.enums.ticket;

// Enumeration for the different statuses of a ticket.
public enum Status {
    // Ticket is currently active and needs attention.
    Active,

    // Ticket is in progress and being worked on.
    Progress,

    // Ticket is completed and no further action is needed.
    Completed;

    public static Status fromIndex(int index) {
        if (index < 0 || index >= values().length) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
        return values()[index];
    }
}
