// checking account: no fees or interest for now ( which is how basic checking accounts work)
public class CheckingAccount extends Account {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public String toString() {
        return "[Checking] " + super.toString();
    }
}
