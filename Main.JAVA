public class Main {
   public Main() {
   }

   public static void main(String[] var0) {
    System.out.println("Welcome to the Terminal!");
      // take input
    while (true) {
        String var1 = System.console().readLine("Enter a command: ");
        if (var1.equalsIgnoreCase("exit")) {
            System.out.println("Exiting the Terminal. Goodbye!");
            break;
        }
        if (var1.trim().isEmpty()) {
            System.out.println("Please enter a valid command.");
            continue;
        }
        
        System.out.println("You entered: " + var1);

   }
}
}

