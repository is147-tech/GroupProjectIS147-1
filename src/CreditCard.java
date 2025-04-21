// specific named cards, is inheriting from CreditAccount

// need to explain more about each credit card, base for now
public class CreditCard extends CreditAccount {
    private String cardName;
    private String description;

    public CreditCard(String name, double limit, double apr, String description) {
        super(limit, apr);
        this.cardName = name;
        this.description = description;
    }

    public String getCardName() { return cardName; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return String.format(
                "%s → %s%n    %s",
                cardName, super.toString(), description
        );
    }
}
