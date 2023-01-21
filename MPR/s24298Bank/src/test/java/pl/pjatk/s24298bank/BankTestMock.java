package pl.pjatk.s24298bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;


public class BankTestMock {


    @Test
    void getClient_Success() {
        BankManager bankManager = Mockito.mock(BankManager.class);
        when(bankManager.getClient(1)).thenReturn(new Client(1, 100));
        Assertions.assertNotNull(bankManager.getClient(1));
    }

    @Test
    void getClient_Fail_InvalidID() {
        BankManager bankManager = Mockito.mock(BankManager.class);
        Assertions.assertNull(bankManager.getClient(2));
    }


}
