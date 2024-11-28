import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public boolean deleteExpenseById(int id) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                String output = "Deleted expense:\n" +
                        "ID:" + expense.getId() + " - " +
                        expense.getDate() + " - " +
                        expense.getAmount() + " - " +
                        expense.getCategory() + " (" +
                        expense.getDescription() + ")";
                System.out.println(output);

                expenses.remove(expense);
                return true;
            }
        }
        return false;
    }

}


