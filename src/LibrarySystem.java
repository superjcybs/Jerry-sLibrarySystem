import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to Jerry's Library, Choose a task");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Display Books by Titles");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            // int choice = scanner.nextInt();
            // scanner.nextLine(); // Consume newline

int choice = getValidChoice(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = getValidInt(scanner);
                    library.addBook(title, author, quantity);
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter quantity to borrow: ");
                    quantity = getValidInt(scanner);
                    library.borrowBook(title, quantity);
                    break;

                case 3:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter quantity to return: ");
                    quantity = getValidInt(scanner);
                    library.returnBook(title, quantity);
                    break;

                case 4:
                    library.displayBookTitles();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

     private static int getValidChoice(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
     }

    private static int getValidInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
}
}