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

            switch (cmd.toLowerCase()) {
                case "exit":
                    // save history before exiting.
                    historyFile(commandHistory);

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
                
                case "changeUser":
                    changeUsername(sc);
                    break;

                case "clear":
                    clearConsole();
                    break;

                case "settings":
                    settings(sc);
                    break;

                case "calc":
                    try {
                        doCalc(sc);
                    } catch (Exception e) {
                        printSlowly("Invalid input for calculator");
                        System.out.println();
                    }
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
    // add settings command that aloows to toggle text animation or speed and change not more but will be helpful in the future as i add more features
    static void showHelp() {
        System.out.println("help - show this message");
        System.out.println("hello - greet the assistant");
        System.out.println("time - show current time");
        System.out.println("joke - tell a random joke");
        System.out.println("calc - simple calculator");
        System.out.println("motivate - get a motivational quote");
        System.out.println("mission - get a random mission to work towards");
        System.out.println("history - show command history of this current session");
        System.out.println("changeUser - change the user name (will overwrite old name)");
        System.out.println("settings - change settings (coming soon)");
        System.out.println("clear (Mac exclusive) - clear the console");
        System.out.println("exit - exit the program");

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
            "Why did the computer go to the doctor? Because it had a virus!",
            "Why did programmers hate nature? It has too many bugs!",
            "Why do Java developers wear glasses? Because they don't see sharp!",
            "Why did the programmer quit his job? Because he didn't get arrays!",
            "Why do programmers prefer iOS development? Because on Andriod they have to deal with JAVA!"
        };

        int r = (int)(Math.random() * jokes.length);

        printSlowly(jokes[r]);
        System.out.println();
    }

    static void doCalc(Scanner sc) {

        System.out.println("Simple Calculator");
        System.out.println();
        
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
            "Keep trying!",
            "Believe in yourself!",
            "Every day is a new opportunity to learn and grow.",
            "Do not be afraid to make mistakes, they are a part of the learning process.",
            "Success is not final, failure is not fatal: It is the courage to continue that counts.",
            "The only way to do great work is to love what you do.",
            "The future belongs to those who believe in the beauty of their dreams.",
            "Don't watch the clock; do what it does. Keep going.",
            "The harder you work for something, the greater you'll feel when you achieve it.",
            "Dream big and dare to fail.",
            "Success is not in what you have, but who you are.",
            "Don't be pushed around by the fears in your mind. Be led by the dreams in your heart.",
            "Trust yourself. You know more than you think you do.",
            "The only limit to our realization of tomorrow will be our doubts of today.",
            "It does not matter how slowly you go as long as you do not stop.",
            "You are never too old to set another goal or to dream a new dream."
        };
        int r = (int)(Math.random() * q.length);

        printSlowly(q[r]);
        System.out.println();
    }

    static void showStartup() {
        printSlowly("================================");
        printSlowly("             J.A.R.V.I.S"); 
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
            String a = "Commands used:" + history.size();
            printSlowly(a);
            printSlowly("Command History:");
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }

        }
        // add a 
        System.out.println();
    }
    //writes the command history to a file called history.txt. Will be useful in the future when I add more features and want to keep track of them
    static void historyFile(ArrayList<String> history) {
        try {
            PrintWriter pw = new PrintWriter(new File("history.txt"));
            for (String cmd: history) {
                pw.println(cmd);
            }

            pw.close();
            printSlowly("History saved to history.txt");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error saving history");
            System.out.println();
        }
    }

    static void clearHistory() {
        try {
            PrintWriter pw = new PrintWriter(new File("history.txt"));
            pw.close();
            printSlowly("History cleared");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error clearing history");
            System.out.println();
        }
    }

    static boolean animationEnabled = true;

    static void printSlowly(String text) {
        
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            try {
                if (animationEnabled) {
                    Thread.sleep(50); // default speed is 50ms per character
                }
                else {
                    Thread.sleep(0); // no animation, print instantly
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void changeUsername(Scanner sc) {
        try {
            File f = new File(nameFile);
            if (f.exists()) {
                f.delete();
            }
            String newName = getName(sc);
            printSlowly("Name changed to " + newName);
            System.out.println();
        } catch (Exception e) {
            printSlowly("Error changing name");
            System.out.println();
        }
    }

    static void settings(Scanner sc) {
        printSlowly("Settings:");
        printSlowly("1. Toggle text animation");
        printSlowly("2. Change text animation speed");
        printSlowly("3. Change user name");
        printSlowly("4. Clear command history");
        printSlowly("5. Back to main menu");
        printSlowly("Enter option number: ");
        String option = sc.nextLine();

        switch (option) {
            case "1":
                animationEnabled = !animationEnabled;
                String status = animationEnabled ? "enabled" : "disabled";
                printSlowly("Text animation set to " + status);
                System.out.println();
                break;
            case "2":
                // this is lot harder than you think, but will change it and make it work later. For now the speed is always 50ms per chrarecter, I mean comeone, it is not that bad
                break;
            case "3":
                changeUsername(sc);
                break;
            
            case "4":
                clearHistory();
                break;

            case "5":
                // back to main menu
                break;

            default:
                printSlowly("Invalid option");
                System.out.println();
        }
    }
}