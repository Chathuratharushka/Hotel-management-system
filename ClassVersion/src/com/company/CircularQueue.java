package com.company;

public class CircularQueue {
    int size = 5;
    Room[] waitingArray = new Room[size];
    int frontOfArray, rearOfArray;

    CircularQueue() {
        frontOfArray = -1;
        rearOfArray = -1;
    }

    boolean fullOrNot() {
        if (frontOfArray == 0 && rearOfArray == size - 1) {
            return true;
        }
        if (frontOfArray == rearOfArray + 1) {
            return true;
        }
        return false;
    }

    // Adding an element
    void enQueue(Room element) {
        if (fullOrNot()) {
            System.out.println("Queue is full");
        } else {
            if (frontOfArray == -1)
                frontOfArray = 0;
            rearOfArray = (rearOfArray + 1) % size;
            waitingArray[rearOfArray] = element;
            System.out.println("Inserted " + element);
        }
    }

    // Removing an element
    Room deQueue() {
        Room element=new Room();

        element = waitingArray[frontOfArray];
        if (frontOfArray == rearOfArray) {
            frontOfArray = -1;
            rearOfArray = -1;
        }
        else {
            frontOfArray = (frontOfArray + 1) % size;
        }
        return (element);
    }
}

