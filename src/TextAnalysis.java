import java.util.Scanner;
import java.io.FileInputStream;

public class TextAnalysis {
	
	//Initialising arrays for character count and frequency rate, scanner input.
    static char[] characterArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '!', '?', ':', '&', '"', '(', ')', '/', '#', '@', '*'};
    static int[] frequencyRate = new int [characterArray.length];
    static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		//Initialising all variables and scanners needed for each menu option.
		Scanner sc = new Scanner(System.in);
		Scanner displayType = new Scanner(System.in);
		int menuOption = 0;
		String str = "";
		boolean programEnds = false;
		double rateOfRelativeFrequency;
		int highestNumber;
		int yAxisNumber;
		
		while (programEnds == false) {
			//Introduction message that displays menu options to user.
			System.out.println("Welcome to the Text Analysis Program, Designed to analyse your text in different modes! Created by Joshua Adesoba.\n\nPlease choose an option below:\n\n1: Analyse some text via Keyboard Input\n2: Analyse some text from a File\n3: See a Demo of the Text Analysis Program\n4: Exit Program");
			menuOption = sc.nextInt();
		switch(menuOption) {
			case 1:
				str = userInput();
		        frequencyOfLetters(str);
		        
		        System.out.println("Thank you, and which form of output you like this sentence to be analysed in?\n\n");
		        
				System.out.println("1: Analyse sentence with Text Output");
				System.out.println("2: Analyse sentence with Graphical Output");
				System.out.println("3: Analyse sentence with Table Output\n");
				
				int outputChoice = displayType.nextInt();
				
				//Displays Basic Text output
				if(outputChoice == 1) {
					System.out.println("\nBasic Text Output");
					underline();
					for(int i = 0; i < characterArray.length; i++){
			            System.out.println("The character " + characterArray[i] + " appears " + frequencyRate[i] + " time(s).");
			            underline();
			        }
				}
				//Displays Graph output
				else if(outputChoice == 2) {
					System.out.println("\nGraphical Output:\n");
					
					highestNumber = 0;
					yAxisNumber = 0;
					
					for(int frequency : frequencyRate) {
						if(frequency > highestNumber) {
							highestNumber = frequency;
						}
					}
					//Variable to determine highest count of character on Graph Axis
					yAxisNumber = highestNumber;
					for(int i = 0; i < highestNumber; i++)  {
					    
						System.out.printf("%-3d|", yAxisNumber,  "| ");
					    for(int n = 0; n < characterArray.length; n += 1) {
					       if(frequencyRate[n] == highestNumber || frequencyRate[n] >= yAxisNumber ) {
					    	System.out.print("x ");
					       }
					       else {
					    	  System.out.print("  ");
					       }
					    }
					    System.out.println();
					    yAxisNumber--;
					}
					System.out.println("   ==================================================================================================");
					System.out.println("    a b c d e f g h i j k l m n o p q r s t u v w x y z 0 1 2 3 4 5 6 7 8 9 . , ! ? : & \" ( ) / # @ *");
				break;
				}
				//Displays Table output with Relative Frequency
				else if(outputChoice == 3) {
					
					System.out.println("Table Output:");
					System.out.println("-------------------");
					//Table Key: C = Character, F = Frequency, RF = Relative Frequency
			        System.out.println("| " + "C" + " | " + "F" + "  | " + "RF" + "     |");
			        System.out.println("-------------------");
					for(int i = 0; i < characterArray.length; i++) {
						rateOfRelativeFrequency = frequencyRate[i];
						rateOfRelativeFrequency = rateOfRelativeFrequency / str.length();
						System.out.printf("| " + characterArray[i] + " | %-2d | %-5.4f |\n", frequencyRate[i], rateOfRelativeFrequency);
						System.out.println("-------------------");
			        }
				}
			break;
			
			case 2:
				str = userInputForFile();
		        frequencyOfLetters(str);
		        
		        System.out.println("\nTable Output:");
		        System.out.println("-------------------");
		        System.out.println("| " + "C" + " | " + "F" + "  | " + "RF" + "     |");
		        System.out.println("-------------------");
				for(int i = 0; i < characterArray.length; i++) {
					rateOfRelativeFrequency = frequencyRate[i];
					rateOfRelativeFrequency = rateOfRelativeFrequency / str.length();
					System.out.printf("| " + characterArray[i] + " | %-2d | %-5.4f |\n", frequencyRate[i], rateOfRelativeFrequency);
					System.out.println("-------------------");
		        }
				System.out.println("\nGraphical Output:\n");
				
				highestNumber = 0;
				yAxisNumber = 0;
				
				for(int frequency : frequencyRate) {
					if(frequency > highestNumber) {
						highestNumber = frequency;
					}
				}
				yAxisNumber = highestNumber;
				for(int i = 0; i < highestNumber; i++)  {
				    
					System.out.printf("%-3d|", yAxisNumber,  "| ");
				    for(int n = 0; n < characterArray.length; n += 1) {
				       if(frequencyRate[n] == highestNumber || frequencyRate[n] >= yAxisNumber ) {
				    	System.out.print("x ");
				       }
				       else {
				    	  System.out.print("  ");
				       }
				    }
				    System.out.println();
				    yAxisNumber--;
				}
				System.out.println("   ==================================================================================================");
				System.out.println("    a b c d e f g h i j k l m n o p q r s t u v w x y z 0 1 2 3 4 5 6 7 8 9 . , ! ? : & \" ( ) / # @ *");
			break;
			
			case 3:
				//Demo String for analysis
				str = "This program analyses text and characters, displaying them in either text or graphical format!";
		        frequencyOfLetters(str);
		        
		        System.out.println("You have chosen option 3!\nHere is a demonstration of the Text Analyser Program. It will analyse the letter count of the sentence below and display the frequency rate of each letter in a graph and table.\n");
		        System.out.println("String Sentence: " + str);
		        
		        System.out.println("\nTable Output:");
		        System.out.println("-------------------");
		        System.out.println("| " + "C" + " | " + "F" + "  | " + "RF" + "     |");
		        System.out.println("-------------------");
				for(int i = 0; i < characterArray.length; i++) {
					rateOfRelativeFrequency = frequencyRate[i];
					rateOfRelativeFrequency = rateOfRelativeFrequency / str.length();
					System.out.printf("| " + characterArray[i] + " | %-2d | %-5.4f |\n", frequencyRate[i], rateOfRelativeFrequency);
					System.out.println("-------------------");
		        }
				System.out.println("\nGraphical Output:\n");
				
				highestNumber = 0;
				yAxisNumber = 0;
				
				for(int frequency : frequencyRate) {
					if(frequency > highestNumber) {
						highestNumber = frequency;
					}
				}
				yAxisNumber = highestNumber;
				for(int i = 0; i < highestNumber; i++)  {
				    
					System.out.printf("%-3d|", yAxisNumber,  "| ");
				    for(int n = 0; n < characterArray.length; n += 1) {
				       if(frequencyRate[n] == highestNumber || frequencyRate[n] >= yAxisNumber ) {
				    	System.out.print("x ");
				       }
				       else {
				    	  System.out.print("  ");
				       }
				    }
				    System.out.println();
				    yAxisNumber--;
				}
				System.out.println("   ==================================================================================================");
				System.out.println("    a b c d e f g h i j k l m n o p q r s t u v w x y z 0 1 2 3 4 5 6 7 8 9 . , ! ? : & \" ( ) / # @ *");
			break;
			
			case 4: 
				System.out.println("\nThank you for using the Text Analysis Program, Goodbye!");
				System.exit(0);
				//Exits the Program. Will not run again until the program is restarted. 
		}
		//Menu loop for Character Input to pick another option. Added in case user does not directly choose option 4 to exit.
		System.out.println("\nWould you like to pick another option? Y/N");
		char choice = sc.next().charAt(0);
		
			if(choice == 'N' || choice == 'n') {
				programEnds = true;
				System.out.println("\nThank you for using the Text Analysis Program, Goodbye!");
			}
		}
	}
	
    public static void frequencyOfLetters(String str){
    	//Determines the frequency rate of letters in a piece of text.
    	for(int i = 0; i < characterArray.length; i++) {
    		frequencyRate[i] = timesCharAppears(str, characterArray[i]);
    	}
    	
    }
	
    public static int timesCharAppears (String str, char character){
    	//Determines how many time a character appears in a piece of text.
        str = str.toLowerCase();
        int count = 0;
        char[] charArray = str.toCharArray();
        
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == character){
                count++;
            }
        }
        
        return count;
    }
    
	public static String userInputForFile() throws Exception {
		
		//Allows user to input file data to be analysed
		String stringFromFile = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nYou have chosen option 2! Note: Please move the file you want to read and analyse into the Java Assignment folder");
		System.out.println("Please enter you file name you would like to analyse:");
		
		String fileInput = sc.next();
		
		Scanner fileInputScanner = new Scanner(new FileInputStream(fileInput));
		
		while(fileInputScanner.hasNextLine()) {
			stringFromFile = fileInputScanner.nextLine();
		}
		return stringFromFile;
	}
	
    public static void underline() {
    	//Adds dotted line under each character when result is displayed in text output.
    	System.out.println("---------------------------------");
    }
		
    public static String userInput(){
    	System.out.println("\nYou have chosen option 1! Please enter a sentence...");
        return input.nextLine();
      //Allows user input to be entered and analysed into text, graphical or table output. 
    }
}

