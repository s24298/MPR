package pl.pjatk.s24298bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientManager {

    private List<Client> clientList = new ArrayList<>();

    public List<Client> getClientList() {
        return clientList;
    }

    public void addClientToList(Client client){
        clientList.add(client);
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
