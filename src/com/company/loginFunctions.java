package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class loginFunctions {


    public static void signUp(){
        ArrayList<String> newUser = new ArrayList<>();
        newUser.add(userDetails("user"));
        try {
            FileWriter myWriter = new FileWriter(Main.users.getName(), true); //True means append to file contents, False means overwrite
            myWriter.write(newUser.get(0) + "\n"); // writes to file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void newAdmin(){
        ArrayList<String> newUser = new ArrayList<>();
        newUser.add(userDetails("admin"));
        try {
            FileWriter myWriter = new FileWriter(Main.users.getName(), true); //True means append to file contents, False means overwrite
            myWriter.write(newUser.get(0) + "\n"); // writes to file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public static String userDetails(String authority) {
        String userEmail = getEmail("enter email");
        String userPassword = getPassword("enter enter password (must contain at least 1 letter and 1 number and be 6 characters long");
        String userAuthority = (authority);
        return (userEmail + "," + userPassword + "," + userAuthority);
    }

    public static String getEmail(String prompt) {
        Scanner input = new Scanner(System.in);
        String strInput = "";
        boolean validEmail = false;
        while (validEmail == false) {
            try {
                System.out.println(prompt);
                strInput = input.next();
            } catch (Exception e) {
                System.out.println("incorrect input");
                System.out.println(e);
            }
            if (strInput.contains("@") && strInput.contains(".com")) {
                validEmail = true;
            }else {
                System.out.println("invalid email entered. try again ( make sure email follows format text-'@'-text-'.com'");
            }
        }
        return (strInput);
    }

    public static String getPassword(String prompt) {
        Scanner input = new Scanner(System.in);
        String strInput = "";
        boolean validPassword = false;
        while (validPassword == false) {
            try {
                System.out.println(prompt);
                strInput = input.next();
            } catch (Exception e) {
                System.out.println("incorrect input");
                System.out.println(e);
            }
            boolean passwordCheck = checkPassword(strInput);
            if (passwordCheck == true) {
                validPassword = true;
            }else {
                System.out.println("invalid password entered");
            }
        }
        return (strInput);
    }

    public static boolean checkPassword(String password){  // need to add more checks for special characters
        boolean valid = false;
        char a;
        int checks = 0;
        for (a = 'a'; a <= 'z'; ++a) {
            String strA = String.valueOf(a);
            if (password.contains(strA)) {
                checks++;
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            String strA = String.valueOf(i);
            if (password.contains(strA)) {
                checks++;
                break;
            }
        }
        if (password.length() > 6) {
            checks++;
        }
        if (checks == 3) {
            valid = true;
        }
        return (valid);
    }

    public static int logIn(){
        int logInStatus = 0; // 0 = not logged in - 1 = user logged in - 2 = admin logged in
        Main.fileToList("users.txt");
        boolean userFound = false;
        int userIndexPos = 0;
        String username = Main.getString("enter your user email");
        String password = Main.getString("enter your user password");
        for (int i = 0; i < Main.fileContentsUsers.size(); i++) {
            if (Main.fileContentsUsers.get(i).getUserEmail().equals(username)) { // another temp index pos fix * not rn for all in this method
                userIndexPos = i;
                userFound = true;
            }
        }
        if (userFound == true) {
            if (Main.fileContentsUsers.get(userIndexPos).getUserPassword().equals(password)) { // temp index pos fix
                logInStatus++;
            }
            if (Main.fileContentsUsers.get(userIndexPos).getUserAuthority().equals("admin")) { // temp index pos fix
                logInStatus++;
            }
        }
        return(logInStatus);
    }


}
