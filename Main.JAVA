public class Main {
   public Main() {
   }

   public static void main(String[] var0) {
    System.out.println("Welcome to the Terminal!");
      // take input
    String command = System.console().readLine("Enter a command: ");
    System.out.println("You entered: " + command);
   }
}

