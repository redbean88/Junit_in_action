package me.redbean.mock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountServiceTest {
    MockAccountManager mockAccountManager;
    Account senderAccount;
    Account beneficiaryAccount;
    AccountService accountService;

    @Before
    public void setup(){
        mockAccountManager = new MockAccountManager();

        //유저 생성
        senderAccount = new Account("1",200);
        beneficiaryAccount = new Account("2",100);

        //사용자 정보 등록
        mockAccountManager.addAccount("1",senderAccount);
        mockAccountManager.addAccount("2", beneficiaryAccount);


        accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);   //의존성 주입
    }

    @Test
    public void testTransferOK(){
        accountService.transfer("1","2",50);
        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }


}