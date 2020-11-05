package me.redbean.exception;

public class Account {
    long balance = 0;


    public Account() {
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public void transfer(Account debit, long amountToTransfer) throws AccountInsufficientFundsException {
        throw new AccountInsufficientFundsException("잔액이 부족합니다.");
    }
}
