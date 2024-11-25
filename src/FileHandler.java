import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileHandler {
    public static List<Expense> loadExpenses(String fileName) {
        List<Expense> expenses = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File not found. Starting with an empty expense list.");
            return expenses;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                double amount = Double.parseDouble(fields[0]);
                String category = fields[1];
                String date = fields[2];
                String description = fields.length > 3 ? fields[3] : "";
                expenses.add(new Expense(amount, category, date, description));
            }
            System.out.println("Loaded " + expenses.size() + " expenses from file.");
        } catch (IOException e) {
            System.err.println("Error loading expenses: " + e.getMessage());
        }
        return expenses;
    }

    public static void saveExpenses(List<Expense> expenses, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Expense expense : expenses) {
                String line = String.join(",",
                        String.valueOf(expense.getAmount()),
                        expense.getCategory(),
                        expense.getDate(),
                        expense.getDescription());
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Expenses saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving expenses: " + e.getMessage());
        }
    }
}
