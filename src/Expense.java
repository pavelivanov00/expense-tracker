public class Expense {

    private static int idCounter = 1;
    private int id;
    private double amount;
    private String category;
    private String date;
    private String description;

    // constructor for new expenses where the value for id is calculated
    public Expense(double amount, String category, String date, String description) {
        this.id = idCounter++;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // constructor for expenses read from the file
    public Expense(int id, double amount, String category, String date, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public static void setIdCounter(int maxId) {
        idCounter = maxId + 1;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
