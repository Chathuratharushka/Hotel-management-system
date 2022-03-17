package com.company;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String option;

        String[] firstNames = new String[8];        //initialing an array to hold customers' first names.
        String[] surnames=new String[8];            //initialing an array to hold customers' surnames.
        int[] numberOfGuests=new int[8];            //initialing an array to hold number of guests.
        long[]  creditCardNumbers=new long[8];      //initialing an array to hold customers' creditcards numbers.
        //initializing array indexes
        for (int i = 0; i < 8; i++ ) {
            firstNames[i]="empty";
            surnames[i]="No customer";
            creditCardNumbers[i]=0;
            numberOfGuests[i]=0;
        }
        System.out.println( "----Welcome!, to the Hotel System---- ");      //printing menu
        System.out.println( "please enter \n" +
                "A : to add a customer to room\n" +
                "V : to view all rooms\n"+
                "E : to display empty rooms\n"+
                "D : to delete customer from room\n"+
                "F : to find room from customer name\n" +
                "S : to store program data into file\n" +
                "L : to load program data from file\n" +
                "O : to view guests Ordered alphabetically by name\n"+
                "Q : to Quit");
        option=input.next().toUpperCase();      //to select menu option from the user
        while(!option.equals("Q")){     //checking menu option is valid or not.
            if(option.equals("A")){
                addCustomer(firstNames,surnames,creditCardNumbers,numberOfGuests);
            }else if (option.equals("V")){
                viewRooms(firstNames,surnames);
            }else if(option.equals("E")){
                displayEmptyRooms(firstNames);
            }else if(option.equals("D")){
                deleteCustomer(firstNames,surnames,creditCardNumbers,numberOfGuests);
            }else if(option.equals("F")){
                findRoom(firstNames);
            }else if(option.equals("S")){
                storeInDocument(firstNames,surnames,numberOfGuests);
            }else if(option.equals("L")){
                printTextFile();
            }else if(option.equals("O")){
                guestsByAlphabetically(firstNames);
            }
            System.out.println( "please enter \n" +
                    "A : to add a customer to room\n" +
                    "V : to view all rooms\n"+
                    "E : to display Empty rooms\n"+
                    "D : to delete customer from room\n"+
                    "F : to find room from customer name\n" +
                    "S : to store program data into file\n" +
                    "L : to load program data from file\n" +
                    "O : to view guests Ordered alphabetically by name\n"+
                    "Q : to Quit");
            option=input.next().toUpperCase();
        }

    }

    public static void viewRooms(String[] firstNameArray,String[] surnameArray) {       //to view all rooms
        int roomNumber = 1;
        for (int x = 0; x < 8; x++) {
            if (firstNameArray[x].equals("empty")) {
                System.out.println("room " + roomNumber + " is empty");     //checking room is empty or not.
            } else {
                System.out.println("room " + roomNumber + " occupied by " + firstNameArray[x]+" "+surnameArray[x]);
            }
            roomNumber++;       //counting room number.
        }
    }
    public static void addCustomer (String[] firstNameArray,String[] surnameArray,long[] creditcardsArray,int[] guestsArray){       //to add a customer into system.
        Scanner input = new Scanner(System.in);
        int roomNum;
        int arrayIndex;

        System.out.println("Choose customer's room number between 1 and " + firstNameArray.length+ " that want to add the customer : ");
        roomNum = input.nextInt();
        while ((roomNum < 1) || (roomNum > firstNameArray.length)) {    //checking room number is valid or not
            System.out.println("Choose customer's room number between 1 and " + firstNameArray.length+ " that want to add the customer : ");
            roomNum = input.nextInt();
        }

        //getting customers details from the user.
        System.out.println("Enter the customer's first name for room " + roomNum + " :");
        String customerFirstName = input.next().toUpperCase();
        System.out.println("Enter the customer's  surnname for room " + roomNum + " :");
        String customerSurname = input.next().toUpperCase();
        System.out.println("Enter the customer's credit card number for room " + roomNum + " :");
        long customerCreditCard = input.nextLong();
        System.out.println("Enter the total number of guests in the room number " + roomNum + " :");
        int guests = input.nextInt();
        arrayIndex=roomNum-1;
        //adding customer's details into arays.
        firstNameArray[arrayIndex] = customerFirstName;
        surnameArray[arrayIndex] = customerSurname;
        creditcardsArray[arrayIndex] = customerCreditCard;
        guestsArray[arrayIndex]=guests;
        System.out.println("Successfully "+customerFirstName +" "+customerSurname+" added to the room number "+roomNum);
    }
    public static void displayEmptyRooms(String[] firstNameArray){      //to view all empty rooms.
        int roomNumber = 1;
        int count=0;
        for (int x = 0; x < firstNameArray.length; x++) {
            if (firstNameArray[x].equals("empty")) {        //checking room is empty or not
                System.out.println("room " + roomNumber + " is empty");
                count++;        //counting empty rooms.
            }
            roomNumber++;
        }
        System.out.println(count + " rooms are empty.");
    }
    public static void deleteCustomer(String[] firstNameArray,String[] surnameArray,long[] creditcardArray,int[] guestsArray){          //to delete customer from the system.
        Scanner input = new Scanner(System.in);
        String customer;
        int roomNum;
        int arrayIndex;
        System.out.println("Choose customer's room number between 1 and " + firstNameArray.length+ " that you want to remove from the room : ");
        roomNum = input.nextInt();
        while ((roomNum < 1) || (roomNum > firstNameArray.length)) {        //checking room number is valid or not
            System.out.println("Choose customer's room number between 1 and " + firstNameArray.length+ " that you want to remove from the room : ");
            roomNum = input.nextInt();
        }

        arrayIndex=roomNum-1;
        if(firstNameArray[arrayIndex].equals("empty")){
            System.out.println("The room you entered is already empty.");
        }else{      //deleting customer from the room.
            customer=firstNameArray[arrayIndex];
            firstNameArray[arrayIndex]="empty";
            surnameArray[arrayIndex]="No customer";
            creditcardArray[arrayIndex]=0;
            guestsArray[arrayIndex]=0;
            System.out.println(customer + " deleted from room no "+ roomNum );
        }
    }
    public static void findRoom(String[] firstNamesArray){  //to find room number from the customer's name.
        Scanner input = new Scanner(System.in);
        int roomNum=1;
        int found=0;
        String customerName;
        System.out.println("Enter the customer's name to find the room number :");
        customerName= input.next().toUpperCase();
        for(int i=0;i<firstNamesArray.length;i++){
            if(firstNamesArray[i].equals(customerName)){
                System.out.println(customerName + "'s Room number is " + roomNum);
                found++;        //checking customer has found or not.
            }
            roomNum++;
        }
        if(found==0){
            System.out.println(customerName +" is not in the hotel.");
        }
    }
    public static void storeInDocument(String[] firstNamesArray,String[] surnamesArray,int[] guestsArray) {         //to storing customers' detials into document.
        PrintWriter outputStream = null;
        try {
            FileOutputStream s = new FileOutputStream("out.txt");       //to open file.
            outputStream = new PrintWriter(s);
        } catch (Exception e) {
            System.out.println(e);
        }
        //printing details into file.
        int roomNumber = 1;
        for (int x = 0; x < 8; x++) {
            if (firstNamesArray[x].equals("empty")) {
                outputStream.println("room " + roomNumber + " is empty");
            } else {
                outputStream.println("room " + roomNumber + " occupied by " + firstNamesArray[x]+" "+surnamesArray[x]+" and "+guestsArray[x]+" guests are in this room");
            }
            roomNumber++;
        }
        outputStream.close();       //to close the file
        System.out.println("successfully added the data into document.");
    }
    public static void printTextFile(){         //to print details from the file
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
    public static void guestsByAlphabetically(String[] customerArray){          //to get customers name by alphabeticaly order
        int length=customerArray.length;
        String[] alphabeticallyGuests=new String[length];
        for(int i=0;i<customerArray.length;i++){    //to initialize all customers into separate array.
            alphabeticallyGuests[i]=customerArray[i];
        }
        for (int j=0;j<length-1;j++) {
            for (int i = 0; i < length-1; i++) {
                int compare=alphabeticallyGuests[i].compareTo(alphabeticallyGuests[i+1]);        //to check which index is greater than other
                if(compare>0){      // to swap the customers if it's required.
                    String temp=alphabeticallyGuests[i];
                    alphabeticallyGuests[i]=alphabeticallyGuests[i+1];
                    alphabeticallyGuests[i+1]=temp;
                }
            }
        }
        System.out.println("Guests name by alphabetically order.");
        for(int i=0;i<length;i++){      //to remove empty rooms from array
            if(alphabeticallyGuests[i]!="empty"){
                System.out.println(alphabeticallyGuests[i]);        //to print the customers
            }
        }
    }
}
