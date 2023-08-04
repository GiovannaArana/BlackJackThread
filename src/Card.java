public class Card {
    private String name;
    private int value;
    private String suits;

    public Card(String name, int value, String suits) {
        this.name = name;
        this.value = value;
        this.suits = suits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuits() {
        return suits;
    }

    public void setSuits(String suits) {
        this.suits = suits;
    }

    @Override
    public String toString() {
        return "\nCard{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", suits='" + suits + '\'' +
                "}";
    }
}
