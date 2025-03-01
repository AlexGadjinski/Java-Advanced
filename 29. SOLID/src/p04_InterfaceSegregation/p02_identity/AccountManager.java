package p04_InterfaceSegregation.p02_identity;

import p04_InterfaceSegregation.p02_identity.interfaces.Account;
import p04_InterfaceSegregation.p02_identity.interfaces.User;

public class AccountManager implements Account {
    private boolean requireUniqueEmail;

    private int minRequiredPasswordLength;

    private int maxRequiredPasswordLength;

    @Override
    public void register(String username, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void login(String username, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changePassword(String oldPass, String newPass) {
        //change password
    }
}
