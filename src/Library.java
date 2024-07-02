import java.util.HashMap;
import java.util.Map;

public class Library {
    // public static void main(String[] args) throws Exception {
    //     System.out.println("Hello, World!");
    // }
    private Map<String, Book> books;

        public Library() {
        books = new HashMap<>();
    }
    public void addBook(String title, String author, int quantity) {
        if (books.containsKey(title)) {
            books.get(title).addQuantity(quantity);
        } else {
            books.put(title, new Book(title, author, quantity));
        }
        System.out.println("Book added/updated successfully.");
    }
    public void borrowBook(String title, int quantity) {
        if (books.containsKey(title)) {
            if (books.get(title).borrowBook(quantity)) {
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Not enough copies available.");
            }
        } else {
            System.out.println("Book not found in the library.");
        }
    }
    public void returnBook(String title, int quantity) {
        if (books.containsKey(title)) {
            books.get(title).returnBook(quantity);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }
    public void displayBooks() {
        System.out.println("Books available in the library:");
        for (Book book : books.values()) {
            System.out.printf("Title: %s, Author: %s, Quantity: %d%n", book.getTitle(), book.getAuthor(), book.getQuantity());
        }
    }
    public void displayBookTitles() {
        System.out.println("Book titles available in the library:");
        if(books.isEmpty()){
            System.out.println("Sorry, We are out of stock!");
        } else {
            for (String title : books.keySet()) {
                System.out.println(title);
            }
        }
    }
}
