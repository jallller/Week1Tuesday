package app;

public class Transaction {
    private int id;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Transaction(int id, double amount, String currency) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Transaction() {
    }

    public Transaction(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    private double amount;
    private String currency;


}
