package me.redbean.mock;

/**
 * 사용자 정보 조회해오는 서비스 ( dto 서비스)
 */
public interface AccountManager {
    Account findAccountForUser(String userId);
    void updateAccount(Account account);
}
