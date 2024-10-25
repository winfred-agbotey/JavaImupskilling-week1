package org.example.oop_exercise_2;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the outer class Book.
        Book book = new Book("1984", "Dystopian", 15.99);

        //Create an instance of the inner class Author
        Book.Author author = book.new Author("George Orwell", "British");

        book.displayBookInfo(author);
    }
}