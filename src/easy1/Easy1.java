/**
 * @author jswmcw
 */

package easy1;
import java.io.*;
import java.util.*;

public class Easy1 {
	
	static File infoFile = new File("info.txt");
    static String name, redditName;
    static int age;
    
    // Read in info from file
    private static void readFile() throws IOException {
        Scanner fileScanner = new Scanner(infoFile);
        name = fileScanner.nextLine();
        age = fileScanner.nextInt();
        redditName = fileScanner.next();
        fileScanner.close();
    }
    
    // Write info to file
    private static void writeFile() throws IOException {
        PrintWriter toFile = new PrintWriter(infoFile);
        toFile.printf("%s\n", name);
        toFile.printf("%d\n", age);
        toFile.printf("%s\n", redditName);
        toFile.close();
    }
    
    // Read input in from user
    private static void readInput() {
        Scanner readIn = new Scanner(System.in);
    
        try {
        	System.out.print("What is your name?: ");
            name = readIn.nextLine();
            System.out.print("How old are you?: ");
            age = readIn.nextInt();
            if (age < 0 || age > 150) throw new InputMismatchException();
        }
        catch (InputMismatchException e) {
            System.out.println("That was not a valid age. You are now 5 years old...");
            age = 5;
        }
        finally {
        	System.out.print("What is your Reddit username?: ");
            redditName = readIn.next();
        	readIn.close();
        }
    }

	public static void main(String[] args) {
		
		// Check if info file exists. Read input from user if not and create file
		try {
			if (infoFile.exists()) {
	            readFile();
	        } else {
	            readInput();
	            writeFile();
	        }
		}
		catch (IOException e){
			System.err.println("File error: " + e);
		}
		
        System.out.println("Your name is " + name + ", you are " + age + 
                            " years old, and your username is " + redditName);

	}

}
