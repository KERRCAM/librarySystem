package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
//test
/*  2D array print test
 for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
        System.out.println(seperatedFileContents[i][j]);
        }
    }
*/

// FIND UNFINISHED METHOD - testing

public class Main {

    public static File books = new File("library.txt");
    public static File users = new File("users.txt");
    public static ArrayList<String> fileContents = new ArrayList<>();


    public static String getString(String prompt) {
        Scanner input = new Scanner(System.in);
        String strInput = "";
        try {
            System.out.println(prompt);
            strInput = input.next();
        } catch (Exception e) {
            System.out.println("incorrect input");
            System.out.println(e);
        }
        return (strInput);
    }

    public static void deleteLibrary(){
        if (books.delete()) {
            System.out.println("Deleted the file: " + books.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void viewLibrary(){
        try (BufferedReader br = new BufferedReader(new FileReader("library.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e){
            System.out.println("error");
            System.out.println(e);
        }
    }

    public static void removeBook(){
    // call ISBN search function get user to confirm correct book if correct remove from text file and rearrange text file with list to have no gaps if incorrect tell user and leave
    }



    public static void fileToList(String file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContents.add(line);
            }
        }catch (Exception e){
            System.out.println("error");
            System.out.println(e);
        }
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.println(fileContents.get(i));
        }
    }

    public static String[][] commaSeperatedStringsSplitter(int size){
        String seperatedFileContents[][] = new String[fileContents.size()][size];
        for (int i = 0; i < fileContents.size(); i++) {
            String[] splitter = (fileContents.get(0)).split("[,]", 0);
            int indexPos = 0;
            for (String currentPart : splitter) {
                indexPos++;
                seperatedFileContents[i][indexPos] = currentPart;
            }
        }
        return(seperatedFileContents);
    }

    public static void adminMenu(){
        boolean menu = true;
        while (menu == true) {
            String action = getString("what would you like to (enter number of action): \n (1)-delete library- \n (2)-add book- \n (3)-view library- \n (4)-remove book- \n (5)-find book- \n (6)-add new admin");
            if (action.equals("1")) {
                deleteLibrary();
            }
            if (action.equals("2")) {
                newBookFunctions.addBook();
            }
            if (action.equals("3")) {
                viewLibrary();
            }
            if (action.equals("4")) {
                removeBook();
            }
            if (action.equals("5")) {
                searchFunctions.findBook();
            }
            if (action.equals("6")) {
                loginFunctions.newAdmin();
            }
        String menuAgain = getString("would you like to perform another action Y or N?");
            if (menuAgain.equals("N")) {
                menu = false;
            }
        }
    }

    public static void userMenu(){
        boolean menu = true;
        while (menu == true) {
            String action = getString("what would you like to (enter number of action): \n (1)-view library-  \n (2)-find book-");
            if (action.equals("1")) {
                viewLibrary();
            }
            if (action.equals("2")) {
                searchFunctions.findBook();
            }
            String menuAgain = getString("would you like to perform another action Y or N?");
            if (menuAgain.equals("N")) {
                menu = false;
            }
        }
    }

    public static void main(String[] args) {
        //newAdmin(); uncomment  for new computer that needs initial admin profile
        String option = getString("would you like to (enter number of action): \n (1)-log in- \n (2)-sign up-");
        if (option.equals("1")) {
            int logInStatus = loginFunctions.logIn();
            if (logInStatus == 0) {
                System.out.println("username or password incorrect");
            }
            if (logInStatus == 1) {
                System.out.println("user logged in");
                userMenu();
            }
            if (logInStatus == 2) {
                System.out.println("admin logged in");
                adminMenu();
            }if (option.equals("2")) {
                loginFunctions.signUp();
            }
        }
    }

}



/* just incase everything breaks
package com.company;
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.Scanner;
        import java.util.ArrayList;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.FileReader;

  2D array print test
 for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
        System.out.println(seperatedFileContents[i][j]);
        }
    }


// FIND UNFINISHED METHOD - testing

public class Main {

    private static File books = new File("library.txt");
    private static File users = new File("users.txt");
    public static ArrayList<String> fileContents = new ArrayList<>();


    public static String getString(String prompt) {
        Scanner input = new Scanner(System.in);
        String strInput = "";
        try {
            System.out.println(prompt);
            strInput = input.next();
        } catch (Exception e) {
            System.out.println("incorrect input");
            System.out.println(e);
        }
        return (strInput);
    }

    public static void deleteLibrary(){
        if (books.delete()) {
            System.out.println("Deleted the file: " + books.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void viewLibrary(){
        try (BufferedReader br = new BufferedReader(new FileReader("library.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e){
            System.out.println("error");
            System.out.println(e);
        }
    }

    public static void removeBook(){
        // call ISBN search function get user to confirm correct book if correct remove from text file and rearrange text file with list to have no gaps if incorrect tell user and leave
    }

    public static void findBook() {
        boolean subMenu = true;
        while (subMenu == true) {
            String action = getString("what would you like to (enter number of action): \n (1)-search by title- \n (2)-search by ISBN- \n (3)-search by author- \n (4)-search by genre-");
            if (action.equals("1")) {
                searchByTitle();
            }
            if (action.equals("2")) {
                searchByISBN();
            }
            if (action.equals("3")) {
                searchByAuthor();
            }
            if (action.equals("4")) {
                searchByGenre();
            }
            String menuAgain = getString("would you like to perform another action Y or N?");
            if (menuAgain.equals("N")) {
                subMenu = false;
            }
        }
    }

    public static void fileToList(String file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContents.add(line);
            }
        }catch (Exception e){
            System.out.println("error");
            System.out.println(e);
        }
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.println(fileContents.get(i));
        }
    }

    public static String[][] commaSeperatedStringsSplitter(int size){
        String seperatedFileContents[][] = new String[fileContents.size()][size];
        for (int i = 0; i < fileContents.size(); i++) {
            String[] splitter = (fileContents.get(0)).split("[,]", 0);
            int indexPos = 0;
            for (String currentPart : splitter) {
                indexPos++;
                seperatedFileContents[i][indexPos] = currentPart;
            }
        }
        return(seperatedFileContents);
    }

    public static void searchByTitle(){
        fileToList("library.txt");
        String seperatedFileContents[][] = commaSeperatedStringsSplitter(5); // this makes all 3 major lists equal to first major list ???????????  ---- commaSeperatedStringsSplitter method does fill its list correctly issue is hwn list is put here on this line
        boolean bookFound = false;
        String searchItem = getString("enter the title of the book you are looking for:");
        for (int i = 0; i < fileContents.size() ; i++) {
            if (searchItem.equals(seperatedFileContents[i][1])) { //need to fix that index 0 is null for some reason having index 1 is only temp fix
                bookFound = true;
                System.out.println("book found");
                for (int k = 0; k < 5; k++) {
                    System.out.println("book information:");
                    System.out.println(seperatedFileContents[i][k]); // prints 3 times becuase currentsly all 3 major lists show as only 1st list
                }
            }
        }
        if (bookFound == false) {
            System.out.println("book not found");
        }
        fileContentsWipe();
    }

    public static void searchByISBN(){
        fileToList("library.txt");
        String seperatedFileContents[][] = commaSeperatedStringsSplitter(5); // this makes all 3 major lists equal to first major list ???????????
        boolean bookFound = false;
        String searchItem = getString("enter the ISBN of the book you are looking for:");
        for (int i = 0; i < fileContents.size() ; i++) {
            if (searchItem.equals(seperatedFileContents[i][2])) { //need to fix that index 0 is null for some reason having index 2 is only temp fix
                bookFound = true;
                System.out.println("book found");
                for (int k = 0; k < 5; k++) {
                    System.out.println("book information:");
                    System.out.println(seperatedFileContents[i][k]); // prints 3 times becuase currentsly all 3 major lists show as only 1st list
                }
            }
        }
        if (bookFound == false) {
            System.out.println("book not found");
        }
        fileContentsWipe();
    }

    public static void searchByAuthor(){
        fileToList("library.txt");
        String seperatedFileContents[][] = commaSeperatedStringsSplitter(5); // this makes all 3 major lists equal to first major list ???????????
        boolean bookFound = false;
        String searchItem = getString("enter the Author of the book you are looking for:");
        for (int i = 0; i < fileContents.size() ; i++) {
            if (searchItem.equals(seperatedFileContents[i][3])) { //need to fix that index 0 is null for some reason having index 3 is only temp fix
                bookFound = true;
                System.out.println("book found");
                for (int k = 0; k < 5; k++) {
                    System.out.println("book information:");
                    System.out.println(seperatedFileContents[i][k]); // prints 3 times becuase currentsly all 3 major lists show as only 1st list
                }
            }
        }
        if (bookFound == false) {
            System.out.println("book not found");
        }
        fileContentsWipe();
    }

    public static void searchByGenre(){
        fileToList("library.txt");
        String seperatedFileContents[][] = commaSeperatedStringsSplitter(5); // this makes all 3 major lists equal to first major list ???????????
        boolean bookFound = false;
        String searchItem = getString("enter the genre of the book you are looking for:");
        for (int i = 0; i < fileContents.size() ; i++) {
            if (searchItem.equals(seperatedFileContents[i][4])) { //need to fix that index 0 is null for some reason having index 4 is only temp fix
                bookFound = true;
                System.out.println("book found");
                for (int k = 0; k < 5; k++) {
                    System.out.println("book information:");
                    System.out.println(seperatedFileContents[i][k]); // prints 3 times becuase currentsly all 3 major lists show as only 1st list
                }
            }
        }
        if (bookFound == false) {
            System.out.println("book not found");
        }
        fileContentsWipe();
    }

    public static void fileContentsWipe(){
        for (int i = 0; i < fileContents.size(); i++) {
            fileContents.remove(0);
        }
    }

    public static void addBook(){
        ArrayList<String> newBook = new ArrayList<>();
        newBook.add(bookDetails());
        try {
            FileWriter myWriter = new FileWriter(books.getName(), true); //True means append to file contents, False means overwrite
            myWriter.write(newBook.get(0) + "\n"); // writes to file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void signUp(){
        ArrayList<String> newUser = new ArrayList<>();
        newUser.add(userDetails("user"));
        try {
            FileWriter myWriter = new FileWriter(users.getName(), true); //True means append to file contents, False means overwrite
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
            FileWriter myWriter = new FileWriter(users.getName(), true); //True means append to file contents, False means overwrite
            myWriter.write(newUser.get(0) + "\n"); // writes to file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String bookDetails(){
        String bookTitle = getString("enter book title");
        String bookISBN = getString("enter book ISBN");
        String bookAuthor = getString("enter book Author");
        String bookGenre = getString("enter book Genre");
        return (bookTitle + "," + bookISBN + "," + bookAuthor + "," + bookGenre);
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
        fileToList("users.txt");
        String seperatedFileContents[][] = commaSeperatedStringsSplitter(4); // temp fix
        boolean userFound = false;
        int userIndexPos = 0;
        String username = getString("enter your user email");
        String password = getString("enter your user password");
        for (int i = 0; i < seperatedFileContents.length; i++) {
            if (seperatedFileContents[i][1].equals(username)) { // another temp index pos fix
                userIndexPos = i;
                userFound = true;
            }
        }
        if (userFound == true) {
            if (seperatedFileContents[userIndexPos][2].equals(password)) { // temp index pos fix
                logInStatus++;
            }
            if (seperatedFileContents[userIndexPos][3].equals("admin")) { // temp index pos fix
                logInStatus++;
            }
        }
        return(logInStatus);
    }


    public static void adminMenu(){
        boolean menu = true;
        while (menu == true) {
            String action = getString("what would you like to (enter number of action): \n (1)-delete library- \n (2)-add book- \n (3)-view library- \n (4)-remove book- \n (5)-find book- \n (6)-add new admin");
            if (action.equals("1")) {
                deleteLibrary();
            }
            if (action.equals("2")) {
                addBook();
            }
            if (action.equals("3")) {
                viewLibrary();
            }
            if (action.equals("4")) {
                removeBook();
            }
            if (action.equals("5")) {
                findBook();
            }
            if (action.equals("6")) {
                newAdmin();
            }
            String menuAgain = getString("would you like to perform another action Y or N?");
            if (menuAgain.equals("N")) {
                menu = false;
            }
        }
    }

    public static void userMenu(){
        boolean menu = true;
        while (menu == true) {
            String action = getString("what would you like to (enter number of action): \n (1)-view library-  \n (2)-find book-");
            if (action.equals("1")) {
                viewLibrary();
            }
            if (action.equals("2")) {
                findBook();
            }
            String menuAgain = getString("would you like to perform another action Y or N?");
            if (menuAgain.equals("N")) {
                menu = false;
            }
        }
    }

    public static void main(String[] args) {
        //newAdmin(); uncomment  for new computer that needs initial admin profile
        String option = getString("would you like to (enter number of action): \n (1)-log in- \n (2)-sign up-");
        if (option.equals("1")) {
            int logInStatus = logIn();
            if (logInStatus == 0) {
                System.out.println("username or password incorrect");
            }
            if (logInStatus == 1) {
                System.out.println("user logged in");
                userMenu();
            }
            if (logInStatus == 2) {
                System.out.println("admin logged in");
                adminMenu();
            }if (option.equals("2")) {
                signUp();
            }
        }
    }

}
*/