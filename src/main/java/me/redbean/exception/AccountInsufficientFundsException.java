package me.redbean.exception;

public class AccountInsufficientFundsException extends Exception {
    public AccountInsufficientFundsException(String message) {
        super(message);
    }
}
