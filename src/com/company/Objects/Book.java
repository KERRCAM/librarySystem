package com.company.Objects;

import com.company.Main;

public class Book {

    //dfaks,fadsk,dfjs,fjdfsa
    private String bookTitle;
    private String bookISBN;
    private String bookAuthor;
    private String bookGenre;

    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + ',' +
                ", bookISBN='" + bookISBN + ',' +
                ", bookAuthor='" + bookAuthor + ',' +
                ", bookGenre='" + bookGenre + ',' +
                '}';
    }

    public Book(String bookTitle, String bookISBN, String bookAuthor, String bookGenre) {
        this.bookTitle = bookTitle;
        this.bookISBN = bookISBN;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
}
