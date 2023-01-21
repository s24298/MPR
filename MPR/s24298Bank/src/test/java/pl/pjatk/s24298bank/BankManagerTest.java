package pl.pjatk.s24298bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


class BankManagerTest {


    TransferManager transferManager = new TransferManager();
    ClientManager clientManager = new ClientManager();
    BankManager bankManager = new BankManager(clientManager, transferManager);

    @Test
    void addClient_Fail_ClientAlreadyExist() {
        bankManager.addClient(1, 100);
        Assertions.assertNotNull(bankManager.getClient(1));
    }

    @Test
    void addClient_NewClient_Success() {
        Assertions.assertNull(bankManager.getClient(1));
    }

    @Test
    void getClient_Success() {
        bankManager.addClient(1, 100);
        Assertions.assertNotNull(bankManager.getClient(1));
    }

    @Test
    void getClient_Fail() {
        Assertions.assertNull(bankManager.getClient(1));
    }

    @Test
    void makeTransfer_Fail_NotEnoughMoney() {
        bankManager.addClient(1, 100);
        Transfer transfer = bankManager.makeTransfer(1, 1000);
        Assertions.assertFalse(transfer.getStatus() != Status.DECLINED);
    }

    @Test
    void makeTransfer_Fail_InvalidDesiredTransfer() {
        bankManager.addClient(1, 100);
        Transfer transfer = bankManager.makeTransfer(1, -1000);
        Assertions.assertNull(transfer);
    }

    @Test
    void makeTransfer_Fail_InvalidID() {
        Assertions.assertNull(bankManager.getClient(1));
    }

    @Test
    void makeTransfer_Success() {
        bankManager.addClient(1, 100);
        Transfer transfer = bankManager.makeTransfer(1, 50);
        Assertions.assertFalse(transfer.getStatus() != Status.ACCEPTED);
    }

    @Test
    void addToBalance_success() {
        bankManager.addClient(1, 100);
        Assertions.assertNotNull(bankManager.addToBalance(1, 200));
    }

    @Test
    void addToBalance_fail_InvalidID() {
        Assertions.assertNull(bankManager.addToBalance(3, 200));
    }

    @Test
    void addToBalance_fail_InvalidValue() {
        bankManager.addClient(1, 100);
        Assertions.assertNull(bankManager.addToBalance(1, -200));
    }


}