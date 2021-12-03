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




























/*
package com.company;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.Scanner;
        import java.util.ArrayList;

public class Main {

    private static File myObj = new File("NewFilename.txt"); //Change to something sensible
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CreateFile();
        getStudents();
        WriteToFile();

        ReadFile();

        System.out.println("Do you want to delete this file now Y or N?");
        String userOption = scanner.next();
        if (userOption.equals("Y")) {
            DeleteFile();
        }
    }

    public static String getWord(){
        Scanner input = new Scanner(System.in);
        String word = input.next();
        return (word);
    }

    public static void CreateFile() {
        try {
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void getStudents() {
        ArrayList<String> students = new ArrayList<>();
        boolean addStudents = true;
        while (addStudents = true) {
            System.out.println("enter student name");
            String name = getWord();
            students.add(name);
            System.out.println("would you like to enter another student Y or N?");
            String answer = getWord();
            if (answer.equals("Y")) {
                addStudents = false;
            }
        }
    }

    public static void WriteToFile() {
        try {
            FileWriter myWriter = new FileWriter(myObj.getName(), false); //True means append to file contents, False means overwrite
            System.out.println("This is the contents of the file:");
            myWriter.write("Files in Java might be tricky, but it is fun enough!"); // Overwrites everything in the file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void ReadFile() {
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void DeleteFile() {
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}






package com.company;

        import java.util.ArrayList;
        import java.util.Scanner;

public class Main {

    private static ArrayList<String> students = new ArrayList<>();

    public static void main(String[] args) {
        int studentsToAdd = Integer.parseInt(getInput("How many students do you want to add?"));
        for (int i = 0; i < studentsToAdd; i++) {
            students.add(getStudentDetails());
        }
        printStudentEmails();
    }

    public static String getStudentDetails() {
        int studentID = Integer.parseInt(getInput("Enter your student ID"));
        String studentName = getInput("Enter your name");
        String studentEmail = getInput("Enter your Email address");
        return (studentID + "," + studentName + "," + studentEmail);
    }

    public static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    //Using the split method to split the string into parts
    public static void printStudentEmails() {
        for (int i = 0; i < students.size(); i++) {
            String[] studentDetails = students.get(i).split(",");
            System.out.println(studentDetails[2]);
        }
    }
}
*/