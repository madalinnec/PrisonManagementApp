package repository;

import entities.Administrator;
import entities.Prisoner;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public static boolean logIn(String email, String password) {
        Scanner scanner = new Scanner(System.in);
        TableManagement tableManagement = new TableManagement();
        List<Administrator> adminList = tableManagement.returnAdminList();
        for (Administrator p : adminList) {
            if (email.equalsIgnoreCase(p.getEmail()) && password.equals(p.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static void options(int option) {
        Scanner scanner = new Scanner(System.in);

        if (option == 0) {

            System.out.println("1.Prisons list");
            System.out.println("2.Manage prisoners");
            System.out.println("3.Statistics");
            System.out.println("4.Inbox");
            System.out.println("5.Log out");
            option = scanner.nextInt();

        }

        switch (option) {

            case 1:
                boolean validOption = false;
                while (validOption == false) {
                    System.out.println("1.Request to Register Prisoner");
                    System.out.println("2.Request to Release Prisoner");
                    System.out.println("3.Request to Transfer Prisoner");
                    System.out.println("4.Back");
                    int option2 = scanner.nextInt();
                    if (option2 == 1) {
                        System.out.println("Prisoner registered successful");
                        validOption = true;
                    } else if (option2 == 2) {
                        //release prisoner
                        validOption = true;
                    } else if (option2 == 3) {
                        //transfer prisoner
                        validOption = true;
                    } else if (option2 == 4) {
                        validOption = true;
                        options(0);
                    } else {
                        System.out.println("Invalid option!!!Please insert a valid option: ");
                    }
                    options(1);
                }
                break;

            case 2:

                boolean validOption2 = false;
                while (validOption2 = true) {


                    System.out.println("1.Prisoners list");
                    System.out.println("2.Search prisoner by Name");
                    System.out.println("3.Manage prisoner by ID");
                    System.out.println("4.Back");

                    int option3 = scanner.nextInt();
                    if (option3 == 1) {
                        // prisoner list
                        validOption2 = true;
                    } else if (option3 == 2) {
                        // search by name
                        validOption2 = true;
                    } else if (option3 == 3) {
                        // search by id
                        validOption2 = true;
                    } else if (option3 == 4) {
                        validOption2 = true;
                        options(0);
                    } else {
                        System.out.println("Invalid option!!!Please insert a valid option: ");
                    }
                    options(2);


                }
                break;

            case 3:

                boolean validOption3 = true;
                while (validOption3 = true) {
                    System.out.println("1.Occupation percentage per prison");
                    System.out.println("2.Percentage of prisoners with sentence under 2 years");
                    System.out.println("3.Back");
                    int option4 = scanner.nextInt();
                    if (option4 == 1) {
                        //Occupation percentage per prison method
                    } else if (option4 == 2) {
                        //Percentage of prisoners with sentence under 2 years method
                    } else if (option4 == 3) {
                        validOption3 = true;
                        options(0);
                    } else {
                        System.out.println("Invalid option!!!Please insert a valid option: ");
                    }
                    options(3);
                }
                break;

            case 4:

                boolean validOption4 = true;
                while (validOption4 = true) {
                    System.out.println("1.Accept request");
                    System.out.println("2.Reject request");
                    System.out.println("3.Delete message");
                    System.out.println("4.Back");
                    int option5 = scanner.nextInt();
                    if (option5 == 1) {
                        //Accept request message
                    } else if (option5 == 2) {
                        //Reject request message
                    } else if (option5 == 3) {
                        //Delete message
                    } else if (option5 == 4) {
                        validOption4 = true;
                        options(0);
                    } else {
                        System.out.println("Invalid option!!!Please insert a valid option: ");
                    }
                    options(4);
                }

            case 5:
                System.out.println("Log Out successful");
                break;


        }
    }
}
