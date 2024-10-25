package org.example.oop_exercise_2;

public class Book {
    private final String title;
    private final String genre;
    private final double price;

    public Book(String title, String genre, double price) {
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    // Display book details along with author details.
    public void displayBookInfo(Author author) {
        System.out.println("Book Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Price: $" + price);
        author.displayAuthorInfo();
    }


    // Inner class Author encapsulating details of the book's author.
    class Author {
        private String name;
        private String nationality;

        public Author(String name, String nationality) {
            this.name = name;
            this.nationality = nationality;
        }

        public String getName() {
            return name;
        }

        public String getNationality() {
            return nationality;
        }

        // Display author's details.
        public void displayAuthorInfo() {
            System.out.println("Author: " + name + ", Nationality: " + nationality);
        }
    }
}
