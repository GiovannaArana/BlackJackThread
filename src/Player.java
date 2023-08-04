import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private double money;
    private List<Card> cards;
    private double bet;

    public Player(String name, double money) {
        this.name = name;
        this.money = money;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setBet(double bet){
        this.bet=bet;
        this.money -= bet;
    }

    public double getBet(){
        return this.bet;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", cards='" + cards + '\'' +
                ",\npoints='" + getPoints() + '\'' +
                '}';
    }

    public void resetCards(){
        this.cards.clear();
    }

    public void addCard(Card newCard){
        this.cards.add(newCard);
    }

    public int getPoints(){
        int points = cards.stream()
                .mapToInt(cards ->cards.getValue())
                .sum();
        return points;
    }

    public void addMoney() {
        this.money += (this.bet * 2);
        this.bet = 0;
    }
}