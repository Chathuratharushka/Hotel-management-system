package com.company;

public class Room {
    int roomNumber;
    int numberOfGuests;
    Person payingGuest;
    public Room(){
        roomNumber=0;
        numberOfGuests=0;
        payingGuest=new Person();
    }

    public Room(int roomNumber, int numberOfGuests) {
        this.roomNumber = roomNumber;
        this.numberOfGuests = numberOfGuests;
        this.payingGuest =new Person();
    }
}
