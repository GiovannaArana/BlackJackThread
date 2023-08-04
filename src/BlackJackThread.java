import java.util.Random;
import java.util.Scanner;

public class BlackJackThread extends Thread{
    private Player player;
    private final int MAX_POINTS = 21;

    public BlackJackThread(Player player){
        this.player=player;
    }

    public void run(){
        Deck deck = new Deck();
        deck.generateDeck();
        Scanner sc = new Scanner(System.in);
        do {
            if(player.getMoney() == 0){
                System.out.println("You are out of money, sorry ;-;");
                break;
            }
            makeBet(player, sc);

            while (askForAnotherCard(player, sc)) {
                dealCard(player, deck);
                if (player.getPoints() >= MAX_POINTS) break;
            }

            if (player.getPoints() > MAX_POINTS) System.out.println("Oh... That's sad, you lose, " + player.getName());
            else if (player.getPoints() == MAX_POINTS) playerWin(player);

            else {
                Card nextCard = deck.getCards().get(0);
                System.out.println(player.getName() + " next card was " + nextCard);
                player.addCard(nextCard);
                System.out.println(player.getName() + " points would be: " + player.getPoints());

                if (player.getPoints() > MAX_POINTS) playerWin(player);
                else playerLose(player);
            }
            player.resetCards();
            System.out.println("You have $"+player.getMoney()+", "+ player.getName());
            System.out.println("Another round? (y/n)");
        }while (sc.next().toLowerCase().startsWith("y"));
        sc.close();
    }

    private void makeBet(Player player, Scanner sc){
        System.out.println("You have $"+player.getMoney()+". How much you wanna bet in this round, "+ player.getName()+"?");
        double bet = sc.nextDouble();

        while (bet>player.getMoney() || bet <= 0){
            System.out.println("Invalid value, please try again. Your money: " + player.getMoney());
            bet = sc.nextDouble();
        }

        player.setBet(bet);
    }

    private void dealCard(Player player, Deck deck) {
        Card currentCard = deck.getCards().get(0);
        System.out.println(player.getName() + " card is " + currentCard);
        player.addCard(currentCard);
        deck.getCards().remove(currentCard);

        System.out.println(player);
    }
    private boolean askForAnotherCard(Player player, Scanner sc) {
        System.out.println("Do you want a card, " + player.getName() + "? (y/n)");
        return sc.next().toLowerCase().startsWith("y");
    }

    private void playerWin(Player player){
        System.out.println("Congrats, " + player.getName() + ", You won!");
        player.addMoney();
    }

    private void playerLose(Player player) {
        System.out.println("Oh... That's sad, you lose, " + player.getName());
    }
}
