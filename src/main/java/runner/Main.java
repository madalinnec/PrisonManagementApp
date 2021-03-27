package runner;

import entities.Administrator;
import repository.Menu;
import repository.TableManagement;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TableManagement tableManagement = new TableManagement();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-Welcome to PrisonApp-");
        System.out.println("     1.Register: ");
        System.out.println("     2.Login: ");
        System.out.println();
        System.out.println("Please enter your choice: ");
        int option = scanner.nextInt();

//        TableManagement tableManagement = new TableManagement();
//        tableManagement.createTables();
//        tableManagement.addAdministratorToDatabase();
//        tableManagement.removeAdministratorFromDatabase();
//        tableManagement.addPrisonToDatabase();
//        tableManagement.removePrisonFromDatabase();
//        tableManagement.addPrisonerToDatabase();
//        tableManagement.removePrisonerFromDatabase();

        switch (option) {
            case 1:
                //Register method
                tableManagement.addAdministratorToDatabase();
                break;
            case 2:
                System.out.println("Please enter your ADMIN email address:  ");
                String email = scanner.next();
                System.out.println("Please enter your ADMIN Password:   ");
                String password = scanner.next();
                //---------------------------
                if (Menu.logIn(email, password)) {
                    Menu.options(0);
                } else {
                    System.out.println("Invalid account/password..TRY AGAIN!!!");
                }
                //---------------------------

                //----------------------------
//                System.out.println("Loggin successful, please choose an option: ");


        }

    }

    //aici se termina main ----------------------------------
    //MARE GRESEALA DAR NU STIU CUM E CORECT :|
    //In paranteza  trebuie schimbat


}


