// checking account: no fees or interest for now
public class CheckingAccount extends Account {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public String toString() {
        return "[Checking] " + super.toString();
    }
}
