import java.io.File;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    // first comment
    static String nameFile = "name.txt";
    static String missionFile = "mission.txt";

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String userName = getName(sc);

        showStartup();

        System.out.println("Welcome back " + userName + "!");

        runCommands(sc);

        sc.close();
    }

    static String getName(Scanner sc) throws Exception {

        File f = new File(nameFile);
        File mf = new File(missionFile);

        // make mission file if not there
        if (!mf.exists()) {
            mf.createNewFile();
            PrintWriter pw = new PrintWriter(mf);
            pw.println("Explore the new planet"); // default mission lol
            pw.close();
        }

        // check if name file exists
        if (f.exists()) {
            Scanner s2 = new Scanner(f);
            if (s2.hasNextLine()) {
                String nm = s2.nextLine();
                s2.close();
                return nm;
            }
            s2.close();
        }

        // ask name if no file
        System.out.print("What is your name? ");
        String nm = sc.nextLine();

        PrintWriter pw = new PrintWriter(f);
        pw.println(nm);
        pw.close();

        return nm;
    }

    static void runCommands(Scanner sc) {

        boolean run = true;

        while (run) {

            System.out.print("Enter command: ");
            String cmd = sc.nextLine();

            if (cmd.equals("exit")) {
                System.out.println("Bye!");
                run = false;
            }
            else if (cmd.equals("help")) {
                showHelp();
            }
            else if (cmd.equals("hello")) {
                System.out.println("Hi there!");
                System.out.println();
            }
            else if (cmd.equals("time")) {
                System.out.println("Time is: " + LocalTime.now());
                System.out.println();
            }
            else if (cmd.equals("joke")) {
                tellJoke();
            }
            else if (cmd.equals("calc")) {
                doCalc(sc);
            }
            else if (cmd.equals("motivate")) {
                showQuote();
            }
            else {
                System.out.println("Unknown command");
                System.out.println();
            }
        }
    }

    static void showHelp() {
        System.out.println("Commands: help, hello, time, joke, calc, motivate, exit, mission, ");
        System.out.println();
    }

    static void tellJoke() {
        String[] jokes = {
            "Why did the chicken cross the road?",
            "What's a computer's favorite snack?"
        };

        int r = (int)(Math.random() * jokes.length);

        System.out.println(jokes[r]);
        System.out.println();
    }

    static void doCalc(Scanner sc) {

        System.out.print("Number 1: ");
        double a = Double.parseDouble(sc.nextLine());

        System.out.print("Operator (+,-,*,/): ");
        String op = sc.nextLine();

        System.out.print("Number 2: ");
        double b = Double.parseDouble(sc.nextLine());

        double ans = 0;

        if (op.equals("+")) {
            ans = a + b;
        } else if (op.equals("-")) {
            ans = a - b;
        } else if (op.equals("*")) {
            ans = a * b;
        } else if (op.equals("/")) {
            if (b == 0) {
                System.out.println("Cannot divide by zero");
                System.out.println();
                return;
            }
            ans = a / b;
        }

        System.out.println("Result: " + ans);
        System.out.println();
    }

    static void showQuote() {
        String[] q = {
            "Never give up!",
            "You got this!",
            "Keep trying!"
        };

        int r = (int)(Math.random() * q.length);

        System.out.println(q[r]);
        System.out.println();
    }

    static void showStartup() {
        System.out.println("Starting up...");
        System.out.println("Welcome to Terminal!");
        System.out.println();
    }
}