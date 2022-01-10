package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class newBookFunctions {
    public static void addBook(){
        ArrayList<String> newBook = new ArrayList<>();
        newBook.add(bookDetails());
        try {
            FileWriter myWriter = new FileWriter(Main.books.getName(), true); //True means append to file contents, False means overwrite
            myWriter.write(newBook.get(0) + "\n"); // writes to file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String bookDetails(){
        String bookTitle = Main.getString("enter book title");
        String bookISBN = Main.getString("enter book ISBN");
        String bookAuthor = Main.getString("enter book Author");
        String bookGenre = Main.getString("enter book Genre");
        return (bookTitle + "," + bookISBN + "," + bookAuthor + "," + bookGenre);
    }

}
