package com.company;

public class searchFunctions {

    public static void findBook() {
        boolean subMenu = true;
        while (subMenu == true) {
            String action = Main.getString("what would you like to (enter number of action): \n (1)-search by title- \n (2)-search by ISBN- \n (3)-search by author- \n (4)-search by genre-");
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
            String menuAgain = Main.getString("would you like to perform another action Y or N?");
            if (menuAgain.equals("N")) {
                subMenu = false;
            }
        }
    }

    public static void searchByTitle(){
        Main.fileToList("library.txt");
        String seperatedFileContents[][] = Main.commaSeperatedStringsSplitter(5); // this makes all 3 major lists equal to first major list ???????????  ---- commaSeperatedStringsSplitter method does fill its list correctly issue is hwn list is put here on this line
        boolean bookFound = false;
        String searchItem = Main.getString("enter the title of the book you are looking for:");
        for (int i = 0; i < Main.fileContents.size() ; i++) {
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
        Main.fileToList("library.txt");
        String seperatedFileContents[][] = Main.commaSeperatedStringsSplitter(5); // this makes all 3 major lists equal to first major list ???????????
        boolean bookFound = false;
        String searchItem = Main.getString("enter the ISBN of the book you are looking for:");
        for (int i = 0; i < Main.fileContents.size() ; i++) {
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
        Main.fileToList("library.txt");
        String seperatedFileContents[][] = Main.commaSeperatedStringsSplitter(5); // this makes all 3 major lists equal to first major list ???????????
        boolean bookFound = false;
        String searchItem = Main.getString("enter the Author of the book you are looking for:");
        for (int i = 0; i < Main.fileContents.size() ; i++) {
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
        Main.fileToList("library.txt");
        String seperatedFileContents[][] = Main.commaSeperatedStringsSplitter(5); // this makes all 3 major lists equal to first major list ???????????
        boolean bookFound = false;
        String searchItem = Main.getString("enter the genre of the book you are looking for:");
        for (int i = 0; i < Main.fileContents.size() ; i++) {
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
        for (int i = 0; i < Main.fileContents.size(); i++) {
            Main.fileContents.remove(0);
        }
    }


}
