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

//mostly well named variables and good use of try catches and method named
//could add some more comments

public class Main {

    private static File books = new File("library.txt");


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

    public static String bookDetails(){
        String bookTitle = getString("enter book title");
        String bookISBN = getString("enter book ISBN");
        String bookAuthor = getString("enter book Author");
        String bookGenre = getString("enter book Genre");
        return (bookTitle + "," + bookISBN + "," + bookAuthor + "," + bookGenre);
    }

    public static void menu(){
        boolean menu = true;
        while (menu == true) {
            String action = getString("what would you like to (enter number of action): \n (1)-delete library- \n (2)-add book- \n (3)-view library-");
            if (action.equals("1")) {
                deleteLibrary();
            }
            if (action.equals("2")) {
                addBook();
            }
            if (action.equals("3")) {
                viewLibrary();
            }
        String menuAgain = getString("would you like to perform another action Y or N?");
            if (menuAgain.equals("N")) {
                menu = false;
            }
        }
    }

    public static void main(String[] args) {
    menu();


    }
}




