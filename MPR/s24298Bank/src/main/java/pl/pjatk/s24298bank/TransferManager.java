package pl.pjatk.s24298bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransferManager {

    private List<Transfer> transfersList = new ArrayList<>();


    public List<Transfer> getTransfersList() {
        return transfersList;
    }

    public void addToTransferList(Transfer transfer){
        transfersList.add(transfer);
    }

    public void setTransfersList(List<Transfer> transfersList) {
        this.transfersList = transfersList;
    }


}
