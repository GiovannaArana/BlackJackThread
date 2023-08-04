import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String awnser;

        do {
            System.out.println("Ready to play? (y/n)");
            awnser = sc.next().toLowerCase();
        } while (!awnser.equals("y") && !awnser.equals("n"));
        System.out.println("Player Name: ");

        String name = sc.next();
        System.out.println("Money to bet: ");
        double money = sc.nextDouble();
        Player player = new Player(name, money);

        if (awnser.equals("y")){
            Thread thread = new Thread(new BlackJackThread(player));
            thread.start();
        } else System.out.println("Maybe next time...");

    }
}