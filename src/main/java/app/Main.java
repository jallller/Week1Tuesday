package app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Main {
    public static void main(String[] args) {
/*
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
*/


/*        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(1, 150.75, "USD"));
        transactions.add(new Transaction(2, 200.00, "EUR"));
        transactions.add(new Transaction(3, 300.50, "USD"));
        transactions.add(new Transaction(4, 400.25, "GBP"));
        transactions.add(new Transaction(5, 100.00, "JPY"));
        transactions.add(new Transaction(6, 250.00, "USD"));
        transactions.add(new Transaction(7, 350.75, "EUR"));
        transactions.add(new Transaction(8, 450.00, "CAD"));

        // Print the sample transactions
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }*/

        // Sample dataset of employees
        List<Employees> employees = new ArrayList<>();

        employees.add(new Employees("Alice", 30, "HR", 55000));
        employees.add(new Employees("Bob", 24, "IT", 62000));
        employees.add(new Employees("Charlie", 29, "Finance", 75000));
        employees.add(new Employees("David", 35, "IT", 82000));
        employees.add(new Employees("Eve", 40, "HR", 67000));
        employees.add(new Employees("Frank", 28, "Finance", 58000));
        employees.add(new Employees("Grace", 45, "IT", 95000));

        // Print the employees to check the data
        employees.forEach(System.out::println);


        //Calculate the average age of all employees.

        avgAge(employees);

        //Find the employee with the highest salary.
        highestSalary(employees);

        //Group employees by department and calculate the average salary for each department.

        groupByDepAvgSalary(employees);

        //Count the number of employees in each department.
        countNumberOfEmployees(employees);

        //Find the three oldest employees.



        //Filter and display employees whose salary is above a certain threshold.



        //Sort by different critia
        sortByName(employees);
        sortByAgeDesc(employees);



/*        //Calculate the total sum of all transaction amounts
        totalSumTransactionAmount(transactions);

        //Group transactions by currency and calculate the sum of amounts for each currency.
        groupSumCurAmounts(transactions);

        //Find the highest transaction amount.
        highestTransaction(transactions);

        //Find the average transaction amount.
        avgTransactionAmount(transactions);*/

    }

    //Sort by different critia

    public static void sortByName(List<Employees> employees) {
        employees.stream()
                .sorted(Comparator.comparing(Employees::getName))
                .forEach(System.out::println);

    }
    public static void sortByAgeDesc(List<Employees> employees) {
        employees.stream()
                .sorted(Comparator.comparing(Employees::getAge).reversed())
                .forEach(System.out::println);

    }



    //Count the number of employees in each department.
    public static void countNumberOfEmployees(List<Employees> employees) {
        Map<String, Long> countDep = employees.stream()
                .collect(Collectors.groupingBy(     // Group employees by department
                        Employees::getDepartment,    // Key: department
                        Collectors.counting()       // Value: number of employees in each department
                ));
        countDep.forEach((department, count) ->
                System.out.println("Department : " + department + ", Number of employees: " + count));
    }

    //Group employees by department and calculate the average salary for each department.
    public static void groupByDepAvgSalary(List<Employees> employees) {
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employees::getDepartment,
                        Collectors.averagingDouble(Employees::getSalary)
                ))
                .forEach((emplooye, avgSalary) ->
                        System.out.println("Employee: " + emplooye + ", avg salary: " + avgSalary));
    }


    public static void highestSalary(List<Employees> employees) {
        employees.stream()
                .max(Comparator.comparing(Employees::getSalary))
                .ifPresent(transaction -> System.out.println("Highest salary: " + transaction.getSalary()));
    }

    public static void avgAge(List<Employees> employees){
        Double avgAge = employees.stream()
                .collect(Collectors.averagingInt(Employees::getAge));  // Calculate the average rating

        System.out.println("Avg age : " + avgAge);
    }



    //Calculate the total sum of all transaction amounts

    public static double totalSumTransactionAmount(List<Transaction> transactions) {
        double totalAmount = transactions.stream()
                .collect(Collectors.summingDouble(Transaction::getAmount));  // Summing up transaction amounts

        System.out.println("Total transaction amount: " + totalAmount);
        return totalAmount;
    }

    //Group transactions by currency and calculate the sum of amounts for each currency.
    public static void groupSumCurAmounts(List<Transaction> transaction) {
        transaction.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCurrency,
                        Collectors.summingDouble(Transaction::getAmount)
                ))
                .forEach((currency,sumAmount) ->
                        System.out.println("Currency: " + currency + "amount :" + sumAmount));
    }

    //Find the highest transaction amount.
    public static void highestTransaction(List<Transaction> transactions){
        transactions.stream()
                .max(Comparator.comparing(Transaction::getAmount))
                .ifPresent(transaction -> System.out.println("Highest amount: " + transaction.getAmount()));


    }

    //Find the average transaction amount.

    public static void avgTransactionAmount(List<Transaction> transactions){
        double avgTransaction = transactions.stream()
                .collect(Collectors.averagingDouble(Transaction::getAmount));  // Calculate the average rating

        System.out.println("Avg transaction : " + avgTransaction);

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



/*
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
//}


    //Find the average rating of all books.

    public static void avgRatingBooks(List<Book> books) {
        double avgRating = books.stream()
                .collect(Collectors.averagingDouble(Book::getRating));  // Calculate the average rating

        System.out.println("Avg rating all : " + avgRating);
    }*/



}