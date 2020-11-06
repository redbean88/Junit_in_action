package me.redbean.mock;

import java.util.HashMap;
import java.util.Map;

/**
 * 서비스 확인을 위한 실제 DB가 아닌 가짜객체(Mock)
 */
public class MockAccountManager implements AccountManager{
    private Map<String , Account> acounts = new HashMap<String, Account>();

    public void addAccount(String userId, Account account){
        this.acounts.put(userId,account);
    }

    @Override
    public Account findAccountForUser(String userId) {
        return this.acounts.get(userId);
    }

    @Override
    public void updateAccount(Account account) {
        // nothing to do
    }
}
