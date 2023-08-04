import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck (){
        this.cards = new ArrayList<>();
    }
    public List<Card> getCards() {
        return cards;
    }

    public void generateDeck(){
        this.cards.clear();
        String [] suits = {"Hearts","Diamonds","Clubs","Spades"};
        for (String s : suits) {
            for (int i = 2; i <= 10; i++) {
                cards.add(new Card(Integer.toString(i), i,s));
            }
            cards.add(new Card("Ace", 1, s));
            cards.add(new Card("King", 10, s));
            cards.add(new Card("Queen", 10, s));
            cards.add(new Card("Jack", 10, s));
        }
        randomizeCards();
    }

    private void randomizeCards(){
        Collections.shuffle(cards);
    }
}
