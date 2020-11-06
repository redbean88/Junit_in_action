package me.redbean.mockRefactoring;

import me.redbean.mock.Account;
import me.redbean.mock.AccountManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.security.auth.login.Configuration;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class DefaultAccountManager implements AccountManager {

    //private static final Log LOG = LogFactory.getLog(AccountManager.class);
    /**
     * 의존성 주입으로 변경
     */
    private Log LOG;
    private ResourceBundle bundle;

    /**
     * 빈 생성자에서 해당 객체 설정
     */
    public DefaultAccountManager() {
        this(LogFactory.getLog(AccountManager.class),PropertyResourceBundle.getBundle("technicl"));
    }

    /**
     * 의존성 주입 처리
     * @param LOG
     * @param bundle
     */
    public DefaultAccountManager(Log LOG, ResourceBundle bundle) {
        this.LOG = LOG;
        this.bundle = bundle;
    }

    @Override
    public Account findAccountForUser(String userId) {
        this.LOG.debug("사용자 정보 "+ userId);
       // ResourceBundle bundle = PropertyResourceBundle.getBundle("technicl");
        String sql = this.bundle.getString("FIND_ACCOUNT_FOR_USER");
        // db에서 사용자 정보를 불러옴
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }
}
