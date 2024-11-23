//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager myManager = new ExpenseManager();

        System.out.println("Hello and welcome!");
        System.out.println("Enter expense details:");

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Date: ");
        String date = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        Expense newExpense = new Expense(amount, category, date, description);
        myManager.addExpense(newExpense);


        System.out.println("Expense added: " + newExpense.getCategory() + " - " + newExpense.getAmount());
        scanner.close();

    }
}