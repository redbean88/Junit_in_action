package me.redbean.exception;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test(expected = AccountInsufficientFundsException.class)
    public void 잔액부족_처리_예외_확인() throws AccountInsufficientFundsException {
        long balance = 1000;
        long amountToTransfer = 2000;
        Account creddit = new Account(balance);
        Account debit = new Account();
        creddit.transfer(debit , amountToTransfer);

    }
}