package app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Main {
    public static void main(String[] args) {
        Book[] sampleBooks = {
                new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 277, 4.1),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281, 4.3),
                new Book("1984", "George Orwell", 1949, 328, 4.2),
                new Book("Pride and Prejudice", "Jane Austen", 1813, 279, 4.4),
        };

        List<Book> books = new ArrayList<>();

        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 277, 4.1));
        books.add(new Book(("To Kill a Mockingbird"), "Harper Lee", 1960, 281, 4.3));
        books.add(new Book("1984", "George Orwell", 1949, 328, 4.2));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813, 279, 4.4));

//        for (Book book : books){
//            books.forEach(System.out::println);
//        }


        //Find the average rating of all books.

        avgRatingBooks(books);


        //Filter and display books published after a specific year.

        booksPublishedAfter(1950, books);  // Example: Filter books published after 1950


        //Sort books by rating in descending order.
        sortRatingDesc(books);


        //Find and display the title of the book with the highest rating.

        findDisplayHighestRating(books);


        //Group books by author and calculate the average rating for each author’s books.

        groupByAutherAvgRating(books);


        //Calculate the total number of pages for all books (assuming each book has a fixed number of pages).
        totalNrPages(books);



//        List<Transaction> transactions = new ArrayList<>();
//
//        transactions.add(new Transaction(1, 150.75, "USD"));
//        transactions.add(new Transaction(2, 200.00, "EUR"));
//        transactions.add(new Transaction(3, 300.50, "USD"));
//        transactions.add(new Transaction(4, 400.25, "GBP"));
//        transactions.add(new Transaction(5, 100.00, "JPY"));
//        transactions.add(new Transaction(6, 250.00, "USD"));
//        transactions.add(new Transaction(7, 350.75, "EUR"));
//        transactions.add(new Transaction(8, 450.00, "CAD"));
//
//        // Print the sample transactions
//        for (Transaction transaction : transactions) {
//            System.out.println(transaction);
//        }

    }




    //Filter and display books published after a specific year.
    public static void booksPublishedAfter(int year, List<Book> books) {
        System.out.println("\nBooks published after " + year + ":");
        books.stream()
                .filter(book -> book.getPublicationYear() > year)
                .forEach(System.out::println);
    }

    //Sort books by rating in descending order.
    public static void sortRatingDesc(List<Book> books) {
        books.stream()
                .sorted(Comparator.comparing(Book::getRating).reversed())
                .forEach(System.out::println);

    }

    //Find and display the title of the book with the highest rating.
    public static void findDisplayHighestRating(List<Book> books) {
        books.stream()
                .max(Comparator.comparing(Book::getRating))  // Find the book with the maximum rating
                .ifPresent(book -> System.out.println("Highest rating: " + book.getTitle()));

    }

    //Group books by author and calculate the average rating for each author’s books.
    public static void groupByAutherAvgRating(List<Book> books) {
        books.stream()
                .collect(Collectors.groupingBy(
                        Book::getAuther,
                        Collectors.averagingDouble(Book::getRating)
                ))
                .forEach((auther, avgRating) ->
                        System.out.println("Auther: " + auther + ", avg rating: " + avgRating));
    }

    //Calculate the total number of pages for all books (assuming each book has a fixed number of pages).

    public static int totalNrPages(List<Book> books) {
        int pages = books.stream()
                .mapToInt(Book::getPages)
                .sum();
        System.out.println("number of pages : " + pages);
        return pages;

    }

    //Find the average rating of all books.

    public static void avgRatingBooks(List<Book> books) {
        double avgRating = books.stream()
                .collect(Collectors.averagingDouble(Book::getRating));  // Calculate the average rating

        System.out.println("Avg rating all : " + avgRating);
    }



}