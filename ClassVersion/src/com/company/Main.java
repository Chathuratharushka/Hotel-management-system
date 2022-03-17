package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String option;
        Hotel hotel=new Hotel(8);
        //printing menu
        System.out.println( "----Welcome!,to the hotel---- ");
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

        option = input.next().toUpperCase();        //to select menu option from the user

        while(!option.equals("Q")){     //checking menu option is valid or not.
            if (option.equals("A")){
                hotel.addCustomer();
            }else if (option.equals("V")){
                hotel.viewRooms();
            }else if (option.equals("E")){
                hotel.displayEmptyRooms();
            }else if (option.equals("D")){
                hotel.deleteCustomer();
            } else if (option.equals("F")){
                hotel.findRoom();
            }else if (option.equals("S")){
                hotel.storeInDocument();
            }else if (option.equals("L")){
                hotel.printTextFile();
            } else if (option.equals("O")){
                hotel.guestsByAlphabetically();
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
}

