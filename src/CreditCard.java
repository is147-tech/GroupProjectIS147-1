// CreditCard.java
// Specific named cards, is inheriting from CreditAccount

public class CreditCard extends CreditAccount { // Requirement 17: Inheritance
    private String cardName;  // Requirement 2: Variable
    private String description;

    // Requirement 14: Constructor
    public CreditCard(String name, double limit, double apr, String description) {
        super(limit, apr); // Requirement 15: super keyword
        this.cardName = name; // Requirement 21: this keyword
        this.description = description;
    }


    // Requirement 9: Passing argument by value
    public void updateDescription(String newDescription) {
        this.description = newDescription;
        System.out.println("Description updated to: " + newDescription); // Requirement 23
    }

    public String getCardName() { return cardName; } // Requirement 22: Modifier
    public String getDescription() { return description; }

    @Override
    public String toString() {
        // Requirement 6: String method
        String uppercaseName = cardName.toUpperCase();

        // Requirement 5: Operators (string concat + assignment)
        String cardInfo = uppercaseName + " → " + super.toString();

        return String.format("%s%n    %s", cardInfo, description);
    }
}
