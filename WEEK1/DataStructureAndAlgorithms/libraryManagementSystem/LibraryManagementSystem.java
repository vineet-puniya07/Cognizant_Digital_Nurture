package libraryManagementSystem;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagementSystem {

    Book[] books;
    int size;
    int capacity;

    LibraryManagementSystem(int capacity) {
        this.capacity = capacity;
        this.books = new Book[capacity];
        this.size = 0;
    }

    void addBook(int id, String title, String author) {
        if (size == capacity) {
            System.out.println("Library full! Cannot add more books.");
            return;
        }
        books[size] = new Book(id, title, author);
        size++;
        System.out.println("Book added: " + title);
    }

    int linearSearch(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    int binarySearch(String title) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    void sortBooksByTitle() {
        Arrays.sort(books, 0, size, new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return b1.title.compareToIgnoreCase(b2.title);
            }
        });
    }

    void traverseBooks() {
        if (size == 0) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("ID\tTitle\tAuthor");
        for (int i = 0; i < size; i++) {
            System.out.println(books[i].bookId + "\t" + books[i].title + "\t" + books[i].author);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lib = new LibraryManagementSystem(10);
        Scanner sc = new Scanner(System.in);

        lib.addBook(1, "Java Basics", "James Gosling");
        lib.addBook(2, "Data Structures", "Robert Lafore");
        lib.addBook(3, "Clean Code", "Robert Martin");
        lib.addBook(4, "Algorithms", "Thomas Cormen");
        lib.addBook(5, "Operating Systems", "Silberschatz");

        lib.traverseBooks();

        System.out.print("\nEnter title to search (Linear Search): ");
        String searchTitle1 = sc.nextLine();
        int result1 = lib.linearSearch(searchTitle1);
        if (result1 != -1) {
            System.out.println("Found: " + lib.books[result1].title + " by " + lib.books[result1].author);
        } else {
            System.out.println("Book not found.");
        }

        lib.sortBooksByTitle();
        System.out.println("\nBooks sorted by title for Binary Search:");
        lib.traverseBooks();

        System.out.print("\nEnter title to search (Binary Search): ");
        String searchTitle2 = sc.nextLine();
        int result2 = lib.binarySearch(searchTitle2);
        if (result2 != -1) {
            System.out.println("Found: " + lib.books[result2].title + " by " + lib.books[result2].author);
        } else {
            System.out.println("Book not found.");
        }
    }
}