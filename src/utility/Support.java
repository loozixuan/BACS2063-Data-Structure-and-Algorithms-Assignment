package utility;


public class Support {
    
   public static String readString(String prompt) {
    System.out.print(prompt);
    return new java.util.Scanner(System.in).nextLine();
  }
   
    public static char readChar(String prompt) {
    char input = 0;
    boolean valid = false;
    while (!valid) {
      String temp = readString(prompt);
      if (temp.length() != 1) {
        System.out.println("*** Please enter a character ***");
      } else {
        input = temp.charAt(0);
        valid = true;
      }
    }
    return input;
  }
    
   public static int readInt(String prompt) {
    int input = 0;
    boolean valid = false;
    while (!valid) {
      try {
        input = Integer.parseInt(readString(prompt));
        valid = true;
      } catch (NumberFormatException e) {
        System.out.println("*** Please enter correct quantity ***");
      }
    }
    return input;
  }
  
  
}
