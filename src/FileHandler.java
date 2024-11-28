import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileHandler {
    public static List<Expense> loadExpenses(String fileName) {
        List<Expense> expenses = new ArrayList<>();
        File file = new File(fileName);
        int maxId = 0;

        if (!file.exists()) {
            System.out.println("File not found. Starting with an empty expense list.");
            return expenses;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                double amount = Double.parseDouble(fields[1]);
                String category = fields[2];
                String date = fields[3];
                String description = fields.length > 4 ? fields[4] : "";

                expenses.add(new Expense(id, amount, category, date, description));

                if (id > maxId) {
                    maxId = id;
                }
            }

            Expense.setIdCounter(maxId);
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
                        String.valueOf(expense.getId()),
                        String.valueOf(expense.getAmount()),
                        expense.getCategory(),
                        expense.getDate(),
                        expense.getDescription());
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Expenses updated successfully");
        } catch (IOException e) {
            System.err.println("Error saving expenses: " + e.getMessage());
        }
    }
}
