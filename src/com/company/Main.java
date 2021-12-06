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

    public static void removeBook(){

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

    private static void searchByTitle(){

    }

    private static void searchByISBN(){

    }

    private static void searchByAuthor(){

    }

    private static void searchByGenre(){

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
            String action = getString("what would you like to (enter number of action): \n (1)-delete library- \n (2)-add book- \n (3)-view library- \n (4)-remove book- \n (5)-find book-");
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




