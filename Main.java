// wierd that you have to import simple stufff that is like built in in python but whatever
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // first comment
    static String nameFile = "name.txt";

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String userName = getName(sc);

        showStartup();

        printSlowly("Welcome back " + userName + "!");

        runCommands(sc);

        sc.close();
    }

    static String getName(Scanner sc) throws Exception {

        File f = new File(nameFile);



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
        printSlowly("What is your name? ");
        String nm = sc.nextLine();
        System.out.println("");

        PrintWriter pw = new PrintWriter(f);
        pw.println(nm);
        pw.close();

        return nm;
    }

    static void runCommands(Scanner sc) {

        boolean run = true;
        ArrayList<String> commandHistory = new ArrayList<>();

        while (run) {

            System.out.println("Enter command: ");
            String cmd = sc.nextLine();

            // Store command in history
            commandHistory.add(cmd);

            switch (cmd) {
                case "exit":
                    printSlowly("Bye!");
                    run = false;
                    break;
                
                case "help":
                    showHelp();
                    break;
                
                case "mission":
                    String m = getMission();
                    printSlowly("Your mission is: " + m);
                    System.out.println();
                    break;
            
                case "hello":
                    printSlowly("Hi there!");
                    System.out.println();
                    break;
        
                case "time":
                    printSlowly("Time is: " + LocalTime.now());
                    System.out.println();
                    break;
    
                case "joke":
                    tellJoke();
                    break;

                case "calc":
                    doCalc(sc);
                    break;
        
                case "motivate":
                    showQuote();
                    break;
        
                case "history":
                    showHistory(commandHistory);
                    break;
        
                default:
                    printSlowly("Unknown command");
                    printSlowly("Type 'help' to view commands");
                    System.out.println();
            }
        }
    }

    static void showHelp() {
        System.out.println("help - show this message");
        System.out.println("hello - greet the assistant");
        System.out.println("time - show current time");
        System.out.println("joke - tell a random joke");
        System.out.println("calc - simple calculator");
        System.out.println("motivate - get a motivational quote");
        System.out.println("mission - get a random mission to work towards");
        System.out.println("history - show command history of this current session");

        System.out.println();
    }

    static void tellJoke() {
        String[] jokes = {
            "Why don't scientists trust atoms? Because they make up everything!",
            "Why did the scarecrow win an award? Because he was outstanding in his field!",
            "Why did the bicycle fall over? Because it was two-tired!",
            "What do you call fake spaghetti? An impasta!",
            "Why did the math book look sad? Because it had too many problems!",
            "Why do programmers prefer dark mode? Because light attracts bugs!",
            "Why did the coffee file a police report? It got mugged!",
            "Why did the tomato turn red? Because it saw the salad dressing!",
            "Why did the cookie go to the doctor? Because it was feeling crumbly!",
            "Why did the computer go to the doctor? Because it had a virus!"
        };

        int r = (int)(Math.random() * jokes.length);

        printSlowly(jokes[r]);
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
                printSlowly("Cannot divide by zero");
                System.out.println();
                return;
            }
            ans = a / b;
        }

        printSlowly("Result: " + ans);
        System.out.println();
    }

    static void showQuote() {
        String[] q = {
            "Never give up!",
            "You got this!",
            "Keep trying!"
        };

        int r = (int)(Math.random() * q.length);

        printSlowly(q[r]);
        System.out.println();
    }

    static void showStartup() {
        printSlowly("================================");
        printSlowly("             J.A.R.V.I.S             "); 
        printSlowly("================================");
        printSlowly("");
    }

    static String getMission() {
        
        String[] missions = {
            "Fix 3 bugs in the code",
            "Push your project to GitHub",
            "Learn one new Java concept",
            "Drink water and code",
            "Build something cool!",
            "Take a break and go outside",
            "Write a good journal entry about your coding journey",
            "Help someone else with their code",
            "Refactor a piece of your code to make it cleaner",
            "Write a test for a piece of your code",
            "Learn a new programming language",
            "Contribute to an open source project",
            "Read a chapter of a programming book",
            "Redo mission command to get the mission"
        };
        int r = (int)(Math.random() * missions.length);
        return missions[r];
    }

    // dont know why you would want to see the history but here it is
    static void showHistory(ArrayList<String> history) {
        if (history.isEmpty()) {
            printSlowly("No command history yet!");
        } else {
            printSlowly("Command History:");
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
        System.out.println();
    }

    static void printSlowly(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

}