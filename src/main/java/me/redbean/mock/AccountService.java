package me.redbean.mock;

/**
 * 계좌 처리를 하는 서비스 클래스
 *
 */
public class AccountService {
    private AccountManager accountManager;

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    /**
     * 테스트 대상 메서드
     * transfer 메소드는 accountManager의 구현체를 주입 받으므로, accountManager 구현체를 mock 객체로 생성한다
     * @param senderId
     * @param beneficiaryId
     * @param amount
     */
    public void transfer(String senderId , String beneficiaryId , long amount){
        Account sender = this.accountManager.findAccountForUser(senderId);
        Account beneficiary = this.accountManager.findAccountForUser(beneficiaryId);
        sender.debit(amount);
        beneficiary.credit(amount);
        this.accountManager.updateAccount(sender);
        this.accountManager.updateAccount(beneficiary);
    }

}
