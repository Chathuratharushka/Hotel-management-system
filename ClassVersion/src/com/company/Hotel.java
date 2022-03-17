package com.company;
import java.io.*;
import java.util.Scanner;

public class Hotel {
    Room[] rooms;
    Hotel(int size){
        rooms=new Room[size];
        for(int i=0;i<size;i++){
            rooms[i]=new Room(i+1,0);   //initializing room with room number and guests.
        }
    }
    CircularQueue waitingQueue=new CircularQueue();

    //to add a customer.
    public void addCustomer (){
        Scanner input = new Scanner(System.in);
        int checkFull=0;
        int roomNum;
        int roomsArrayIndex;
        //checking how many customers are in rooms
        for(int i=0;i< rooms.length;i++){
            if(!(rooms[i].payingGuest.firstName.equals("empty"))){
                checkFull++;        //counting customers in rooms.
            }
        }
        //if rooms are full customer will add to waiting list.
        if(checkFull>=rooms.length){
            Room temp=new Room();
            //getting customers details.
            System.out.println("Rooms are full please enter the customers details to add the waiting queue \n" +
                    "Enter the paying customer's first name :");
            String customerFirstName = input.next().toUpperCase();
            System.out.println("Enter the paying customer's surname :");
            String customerSurname = input.next().toUpperCase();
            System.out.println("Enter the paying customer's credit card number  :");
            long customerCreditCardNumber = input.nextLong();
            System.out.println("Enter the total number of guests in the room :");
            int guests = input.nextInt();
            //adding those details into tempory Room
            temp.payingGuest.firstName=customerFirstName;
            temp.payingGuest.surname=customerSurname;
            temp.payingGuest.creditCardNumber=customerCreditCardNumber;
            temp.numberOfGuests=guests;
            waitingQueue.enQueue(temp); // adding customer into waiting list
            System.out.println("wait until a customer check-out from the room to know new customer's room number.....");
        }
        //if rooms are not full customer will add to rooms
        else{
            System.out.println("Choose customer's room number between 1 and " +rooms.length+ " that like to add the customer : ");
            roomNum = input.nextInt();
            while ((roomNum < 1) || (roomNum > rooms.length)) {     //checking room number is valid or not.
                System.out.println("Choose customer's room number between 1 and "+rooms.length+" that like to add the customer : ");
                roomNum = input.nextInt();
            }
            //getting customers details.
            System.out.println("Enter the paying customer's first name for room " + roomNum + " :");
            String customerFirstName = input.next().toUpperCase();
            System.out.println("Enter the paying customer's surname for room " + roomNum + " :");
            String customerSurname = input.next().toUpperCase();
            System.out.println("Enter the paying customer's credit card number for room " + roomNum + " :");
            long customerCreditCardNumber = input.nextLong();
            System.out.println("Enter the total number of guests in the room number " + roomNum + " :");
            int guests = input.nextInt();
            roomsArrayIndex=roomNum-1;
            rooms[roomsArrayIndex].payingGuest.firstName=customerFirstName;
            rooms[roomsArrayIndex].payingGuest.surname=customerSurname;
            rooms[roomsArrayIndex].payingGuest.creditCardNumber=customerCreditCardNumber;
            rooms[roomsArrayIndex].numberOfGuests=guests;
            System.out.println("successfully " +customerFirstName+" "+customerSurname+ " added to the room number "+roomNum);

        }

    }
    public void viewRooms() {   //to view all rooms.

        for (int x = 0; x < rooms.length; x++) {
            if (rooms[x].payingGuest.firstName.equals("empty")) {   //checking room is empty or not.
                System.out.println("room " + rooms[x].roomNumber + " is empty");
            } else {
                System.out.println("room " + rooms[x].roomNumber + " occupied by " + rooms[x].payingGuest.firstName + " "+rooms[x].payingGuest.surname);
            }
        }
    }
    public void displayEmptyRooms(){        //to display all empty rooms
        int count=0;
        for (int x = 0; x < rooms.length; x++) {
            if (rooms[x].payingGuest.firstName.equals("empty")) {   //checcking room is empty or not.
                System.out.println("room " + rooms[x].roomNumber + " is empty");
                count++;
            }

        }
        System.out.println(count + " rooms are empty.");
    }
    //to delete the customer from room.
    public void deleteCustomer(){
        Scanner input = new Scanner(System.in);
        String customer;
        int hotelRoomsArrayIndex,roomNum;
        int checkFull=0;
        //checking how many rooms are full
        for(int i=0;i< rooms.length;i++){
            if(!(rooms[i].payingGuest.firstName.equals("empty"))){
                checkFull++;    //counting customers.
            }
        }
        //if rooms full, customer will add from the waiting list when customer delte from the room.
        if(checkFull==rooms.length){
            System.out.println("Choose customer's room number between 1 and " +rooms.length+ " that you want to remove from the room : ");
            roomNum = input.nextInt();
            while ((roomNum < 1) || (roomNum > rooms.length)) {
                System.out.println("Choose customer's room number between 1 and "+rooms.length+" that you want to remove from the room : ");
                roomNum = input.nextInt();
            }
            System.out.println(rooms[roomNum-1].payingGuest.firstName+" delete from the room number "+roomNum);
            Room temp=new Room();
            temp=waitingQueue.deQueue();
            rooms[roomNum-1].numberOfGuests= temp.numberOfGuests;
            rooms[roomNum-1].payingGuest.firstName=temp.payingGuest.firstName;
            rooms[roomNum-1].payingGuest.surname=temp.payingGuest.surname;
            rooms[roomNum-1].payingGuest.creditCardNumber=temp.payingGuest.creditCardNumber;
            System.out.println(rooms[roomNum-1].payingGuest.firstName+" added to the room number "+roomNum+" from waiting list.. ");
        }
        //if rooms are not full customer will remove from the room.
        else{
            System.out.println("Choose customer's room number between 1 and " +rooms.length+ " that you want to remove from the room : ");
            roomNum = input.nextInt();
            while ((roomNum < 1) || (roomNum > rooms.length)) {     //checking room number is valid or not.
                System.out.println("Choose customer's room number between 1 and "+rooms.length+" that you want to remove from the room : ");
                roomNum = input.nextInt();
            }
            hotelRoomsArrayIndex=roomNum-1;
            if(rooms[hotelRoomsArrayIndex].payingGuest.firstName.equals("empty")){
                System.out.println("The room you entered is already empty.");
            }else{
                customer=rooms[hotelRoomsArrayIndex].payingGuest.firstName;
                rooms[hotelRoomsArrayIndex].payingGuest.firstName="empty";
                rooms[hotelRoomsArrayIndex].payingGuest.surname="No customer";
                rooms[hotelRoomsArrayIndex].payingGuest.creditCardNumber= 0;
                System.out.println(customer + " deleted from room no "+ rooms[hotelRoomsArrayIndex].roomNumber );
            }
        }

    }
    //to find room number from the customers name.
    public void findRoom(){
        Scanner input = new Scanner(System.in);
        int found=0;
        String customerFirstName;
        System.out.println("Enter the customer's first name to find the room number :");
        customerFirstName= input.next().toUpperCase();
        for(int i=0;i<rooms.length;i++){
            if(rooms[i].payingGuest.firstName.equals(customerFirstName)){       //checking customer name
                System.out.println(customerFirstName + "'s Room number is " + rooms[i].roomNumber);
                found++;        //checking whether customer has found or not.
            }
        }

        if(found==0){
            System.out.println(customerFirstName +" is not in the hotel.");
        }
    }
    //storiing data in to a document.
    public void storeInDocument() {
        PrintWriter outputStream = null;
        try {
            FileOutputStream s = new FileOutputStream("out.txt");   //open the file
            outputStream = new PrintWriter(s);
        } catch (Exception e) {
            System.out.println(e);
        }

        //printing data in the document.
        for (int x = 0; x <rooms.length; x++) {
            if (rooms[x].payingGuest.firstName.equals("empty")) {
                outputStream.println("room " + rooms[x].roomNumber + " is empty");
            } else {
                outputStream.println("room " + rooms[x].roomNumber + " occupied by " + rooms[x].payingGuest.firstName + " "+rooms[x].payingGuest.surname+" and "+rooms[x].numberOfGuests+" guests are in this room");
            }

        }
        outputStream.close();       //close the file.
        System.out.println("successfully added the data into document.");
    }
    //display data in the file.
    public void printTextFile(){
        try {
            File dataFile = new File("out.txt");
            Scanner myReader = new Scanner(dataFile);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);
            }
            myReader.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //display customers name by alphabatically order.
    public  void guestsByAlphabetically(){
        int length= rooms.length;
        String[] alphabeticallyGuests=new String[length];
        for(int i=0;i<rooms.length;i++){
            alphabeticallyGuests[i]=rooms[i].payingGuest.firstName;     //initializing data in to separete array
        }
        for (int j=0;j<length-1;j++) {
            for (int i = 0; i < length-1; i++) {
                int compare=alphabeticallyGuests[i].compareTo(alphabeticallyGuests[i+1]); //to check which index is greater than other
                if(compare>0){       // to swap the customers if it's required.
                    String temp=alphabeticallyGuests[i];
                    alphabeticallyGuests[i]=alphabeticallyGuests[i+1];
                    alphabeticallyGuests[i+1]=temp;
                }
            }
        }
        System.out.println("Guests name by alphabetically order.");
        for(int i=0;i<length;i++){
            if(alphabeticallyGuests[i]!="empty"){   //to remove empty rooms from array.
                System.out.println(alphabeticallyGuests[i]);        //to print the customers
            }
        }
    }
}

