package pl.pjatk.s24298bank;

public class Transfer {
    private Status status;
    private Client client;
    private int transferValue;


    public Transfer(Status status, Client client, int transferValue) {
        this.status = status;
        this.client = client;
        this.transferValue = transferValue;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTransferValue(int transferValue) {
        this.transferValue = transferValue;
    }

    public Status getStatus() {
        return status;
    }

    public Client getClient() {
        return client;
    }

    public int getTransferValue() {
        return transferValue;
    }
}
