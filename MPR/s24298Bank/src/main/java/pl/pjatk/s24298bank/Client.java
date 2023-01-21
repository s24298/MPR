package pl.pjatk.s24298bank;

public class Client {
    private int id;
    private int balance;

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Client(int id, int balance) {
        this.id = id;
        this.balance = balance;
        System.out.println("UTWORZONO KLIENTA: " + id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }


}
