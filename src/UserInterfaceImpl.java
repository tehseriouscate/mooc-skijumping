import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {

    private Scanner scanner;
    private String input;

    private List<Jumper> jumpers;
    private int round;

    public UserInterfaceImpl() {
        scanner = new Scanner(System.in);
        jumpers=new ArrayList<Jumper>();
        round = 1;
    }


    public void run() {
        start();
        getNames();
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            input = scanner.nextLine();
            if (!input.equals("jump")) {
                break;
            }
            jump();
        }
        quit();
    }


    @Override
    public void start() {
        System.out.println("Kumpula ski jumping week\n" +
                "\n" +
                "Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
    }

    @Override
    public void getNames() {
        while (true) {
            System.out.print("  Participant name: ");
            input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            jumpers.add(new Jumper(input));
        }
        System.out.println("\nThe tournament begins!\n");
    }

    @Override
    public void jump() {

        System.out.println("\nRound " + round + "\n" +
                "\n" +
                "Jumping order:");
        Collections.sort(jumpers);
        int order = 1;
        for (Jumper jumper : jumpers) {
            System.out.println("  " + order + ". " +jumper.getName() + " (" + jumper.getPoints() + " points)");
            order++;

        }


        for (Jumper jumper : jumpers) {
            jumper.jump();
        }

            System.out.println("\nResults of round " + round);

        for (Jumper jumper : jumpers) {
            System.out.println("  " + jumper.getName());
            System.out.println("    length: " + jumper.getDistances().get(round-1));
            System.out.println("    judge votes: " + jumper.getJudgesPoints() + "\n");
        }
        round++;

    }

    @Override
    public void quit() {
        System.out.println("\nThanks!\n" +
                "\n" +
                "Tournament results:"+"\nPosition    Name");
        int position = 1;
        int counter = 0;
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        for (Jumper jumper : jumpers)   {
            System.out.print("\n" + position +"           " + jumper.getName() + " (" + jumper.getPoints() + " points)\n" +
                    "            jump lengths:");
            position++;
            for (int i : jumper.getDistances()) {
                if (counter==jumper.getDistances().size()-1) {
                    System.out.print(" " + i + " m");
                    counter=0;
                }
                else {
                    System.out.print(" " + i + " m,");
                    counter++;
                }
            }
        }

    }
}
