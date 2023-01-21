package pl.pjatk.s24298bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankManager {

    final private ClientManager clientManager;
    final private TransferManager transferManager;

    Client addClient(int id, int balance) {

        Client client = getClient(id);

        if (client != null) {
            System.out.println("ID Zajete");
            return null;
        }

        Client tempClient = new Client(id, balance);
        clientManager.addClientToList(tempClient);
        return tempClient;
    }

    Client getClient(int id) {

        for (Client client : clientManager.getClientList()) {
            if (client.getId() == id)
                return client;
        }

        return null;
    }

    Transfer makeTransfer(int id, int desiredTransfer) {
        Client sender = getClient(id);
        Transfer transfer = null;

        if (sender == null){
            System.out.println("Nie ma takiego ID");
            return null;
        }

        if(desiredTransfer <= 0){
            System.out.println("Za mala kwota");
            return null;
        }


        if (sender.getBalance() < desiredTransfer) {
            System.out.println("Niewystarczajace srodki");
            transfer = new Transfer(Status.DECLINED, sender, desiredTransfer);
            transferManager.addToTransferList(transfer);
            return transfer;
        } else {
            sender.setBalance(sender.getBalance() - desiredTransfer);
            System.out.println("New balance: " + sender.getBalance());
            transfer = new Transfer(Status.ACCEPTED, sender, desiredTransfer);
            transferManager.addToTransferList(transfer);
            return transfer;
        }
    }

    Client addToBalance(int id, int addedValue) {
        Client client = getClient(id);
        if (client == null) {
            System.out.println("Nie ma takiego id w bazie");
            return null;
        }

        if(addedValue <= 0){
            System.out.println("Za mala kwota");
            return null;
        }

        client.setBalance(client.getBalance() + addedValue);
        System.out.println("Nowe saldo:" + client.getBalance());

        return client;
    }

    void getClientInfo(int id) {
        Client client = getClient(id);
        if (client == null) {
            System.out.println("Nie ma takiego ID");
        } else {
            client.toString();
        }


    }

    public BankManager(ClientManager clientManager, TransferManager transferManager) {
        this.clientManager = clientManager;
        this.transferManager = transferManager;
    }
}
