package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 243);
        Book java = new Book("Java", 444);
        Book cats = new Book("Cats", 213);
        Book dogs = new Book("Dogs", 199);
        Book[] books = new Book[]{
                cleanCode, java, cats, dogs
        };
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println("Replacement of books with index 0 and 3");
        books[0] = dogs;
        books[3] = cleanCode;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println("Show only Clean code book");
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getPages());
            }
        }
    }
}