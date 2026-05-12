public class Main {
   public Main() {
   }

   public static void main(String[] var0) {
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.println("\n");
    System.out.println("Booting up...");
    System.out.println("System is ready.");
    System.out.println("\n");
    System.out.println("Welcome to the Terminal!");
      // take input
    while (true) {
        System.out.print("Enter a command: ");
        String var1 = input.nextLine();
        if (var1.equalsIgnoreCase("exit")) {
            System.out.println("Exiting the Terminal. Goodbye!");
            break;
        }

        if (var1.trim().isEmpty()) {
            System.out.println("Please enter a valid command.\n");
            continue;
        }

        if (var1.equalsIgnoreCase("help")) {
          System.out.println("");
            System.out.println("Available commands:");
            System.out.println("- help: Show this help message");
            System.out.println("- hello: Greet the user");
            System.out.println("- time: Show the current time");
            System.out.println("- status: Show system status");
            System.out.println("- calc: Simple calculator");
            System.out.println("- joke: Tell a random joke");
            System.out.println("- motivate: Show a motivational quote");
            System.out.println("- exit: Exit the Terminal\n");
            continue;
        }

        if (var1.equalsIgnoreCase("hello")) {
            System.out.println("Hello, welcome to the Terminal!\n");
            continue;
        }

        if (var1.equalsIgnoreCase("status")) {
            System.out.println("System Status: ONLINE");
            System.out.println("Threat Level: Extremely High");
            System.out.println("Coffee Level: CRITICAL\n");
            continue;
        }

        if (var1.equalsIgnoreCase("time")) {
            System.out.println("The current time is: " + java.time.LocalTime.now() + "\n");
            continue;
        }

        if (var1.equalsIgnoreCase("joke")) {
            tellJoke();
            continue;
        }

        if (var1.equalsIgnoreCase("motivate")) {
            String[] quotes = {
                "The only way to do great work is to love what you do.",
                "Believe you can and you're halfway there."
            };
            System.out.println(quotes[(int) (Math.random() * quotes.length)] + "\n");
            continue;
        }

        if (var1.equalsIgnoreCase("calc")) {
            System.out.print("First number: ");
            String firstNumberText = input.nextLine();

            System.out.print("Math sign (+, -, *, /): ");
            String mathSign = input.nextLine();

            System.out.print("Second number: ");
            String secondNumberText = input.nextLine();

            double firstNumber;
            double secondNumber;

            try {
                firstNumber = Double.parseDouble(firstNumberText);
                secondNumber = Double.parseDouble(secondNumberText);
            } catch (Exception e) {
                System.out.println("Please type numbers only.");
                continue;
            }

            if (mathSign.equals("+")) {
                System.out.println("Answer: " + (firstNumber + secondNumber) + "\n");
            }

            if (mathSign.equals("-")) {
                System.out.println("Answer: " + (firstNumber - secondNumber) + "\n");
            }

            if (mathSign.equals("*")) {
                System.out.println("Answer: " + (firstNumber * secondNumber) + "\n");
            }

            if (mathSign.equals("/")) {
                System.out.println("Answer: " + (firstNumber / secondNumber) + "\n");
            }

            if (!mathSign.equals("+") && !mathSign.equals("-") && !mathSign.equals("*") && !mathSign.equals("/")) {
                System.out.println("That math sign does not work.\n");
            }

            continue;
        }

        System.out.println("You entered: " + var1);

   }
   input.close();
}

public static void tellJoke() {
    String[] jokes = {
        "Why don't scientists trust atoms? Because they make up everything!",
        "What do you call a fake noodle? An impasta!",
        "Why did the scarecrow win an award? Because he was outstanding in his field!",
        "Why don't skeletons fight each other? They don't have the guts!",
        "What do you call cheese that isn't yours? Nacho cheese!",
        "Why did the bicycle fall over? Because it was two-tired!"
    };
    System.out.println(jokes[(int) (Math.random() * jokes.length)] + "\n");
}
}
