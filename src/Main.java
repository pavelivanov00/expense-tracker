//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "expenses.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        List<Expense> expenses = FileHandler.loadExpenses(FILE_NAME);
        manager.setExpenses(expenses);

        boolean running = true;

        System.out.println("Hello and welcome!");

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("   1. Add Expense");
            System.out.println("   2. View Expenses");
            System.out.println("   3. Delete Expense");
            System.out.println("   4. Exit");
            System.out.println("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Date (dd.MM.yyyy): ");
                    String date = scanner.nextLine();

                    System.out.print("Description: ");
                    String description = scanner.nextLine();

                    Expense newExpense = new Expense(amount, category, date, description);
                    manager.addExpense(newExpense);
                    FileHandler.saveExpenses(manager.getExpenses(), FILE_NAME);
                    System.out.println("Expense added and saved: " + newExpense.getCategory() + " - " + newExpense.getAmount());
                    break;
                }
                case 2: {
                    System.out.println("Current Expenses:");
                    for (Expense expense : manager.getExpenses()) {
                        String output = "ID:"+expense.getId() + " - " +
                                expense.getDate() + " - " +
                                expense.getAmount() + " - " +
                                expense.getCategory() + " (" +
                                expense.getDescription() + ")";
                        System.out.println(output);
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter the ID of the expense to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine();

                    boolean removed = manager.deleteExpenseById(idToDelete);
                    if (removed) {
                        FileHandler.saveExpenses(manager.getExpenses(), FILE_NAME);
                    } else {
                        System.out.println("No expense found with ID: " + idToDelete);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                    break;
                }

                default: System.out.println("Invalid choice. Please try again.");
                break;
            }
        }
        scanner.close();
    }
}