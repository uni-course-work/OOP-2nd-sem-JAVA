public class AccountFrozenException extends RuntimeException {
    public AccountFrozenException (String accountNo) {
        super("Account No: " + accountNo + " is frozen");
    }
}
