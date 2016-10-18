//======================================================================
// CS I : # <Austin Colby>
// Semester : # <Spring 2014>
//
// # <Austin Colby>
// # <Section 12>
//
// Description:
// Creates a calculator that allows variable storage
//  
//======================================================================
import java.util.Scanner;
import java.util.*;

public class MemCalc 
{
	private static HashMap<String, Double> map = new HashMap<String, Double>();

	public static boolean isNumeric(String str)  
	{  
	try  
	{  
		double d = Double.parseDouble(str);  
	}  
	catch(NumberFormatException nfe)  
	{  
		return false;  
	}  
	return true;  
	}
	
	
	public static void main(String[] args){
	
	//creates a scanner to read user input
	Scanner scan = new Scanner(System.in);
	System.out.println("Command line calculator with memory by Austin Colby."); 
			
		//infinite loop for calculator
		while(true){
			System.out.print("% "); 
			String[] input = scan.nextLine().split(" ");
		//Way to big of an if statement !!!
			 if(input[0].equals("quit") || input[0].equals(" ")){
				break;
			} else if(input[0].equals("clear")){
				 map.clear();
				 System.out.println("  " + map);
			} else if(input[0].equals("var")){
				System.out.println("  " + map);
			} else if(input.length <= 1 && (map.get(input[0]) != null) && !isNumeric(input[0])){
				System.out.println("  " + map.get(input[0]));	
			} else if(input.length <= 1 && isNumeric(input[0])){
				System.out.println("  " + Double.parseDouble(input[0]));
			} else if(input.length <= 1 && !isNumeric(input[0])){
				System.out.println("  " + input[0] + " :" + "is not found");
			} else if(input.length <= 3 && (input[0].equals(" ") || (isNumeric(input[0]) && (input[1].equals("+") || input[1].equals("-") 
			  || input[1].equals("*") || input[1].equals("/")))))
			{ 
				System.out.println("Error");
				System.out.println("Please print variables first then numbers");
				System.exit(0);
			} else if (input.length == 5 && !isNumeric(input[0]) && !isNumeric(input[4])){
				System.out.println("Error");
				System.out.println("Please print variables first then numbers");
				System.exit(0);
			//statements for placing into map and basic math functions
			} else if(input.length <= 3 && input[1].equals("=") && !isNumeric(input[2])){
				map.put(input[0], map.get(input[2]));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 3 && input[1].equals("=")){
				map.put(input[0], Double.parseDouble(input[2]));
				System.out.println("  " + map.get(input[0]));
			}  else if(input.length <= 3 && input[1].equals("+") && isNumeric(input[0])){
				double temp = Double.parseDouble(input[0]) + Double.parseDouble(input[2]);
				System.out.println("  " + temp);
			} else if(input.length <= 3 && input[1].equals("-") && isNumeric(input[0])){
				double temp = Double.parseDouble(input[0]) - Double.parseDouble(input[2]);
				System.out.println("  " + temp);
			} else if(input.length <= 3 && input[1].equals("*") && isNumeric(input[0])){
				double temp = Double.parseDouble(input[0]) * Double.parseDouble(input[2]);
				System.out.println("  " + temp);
			} else if(input.length <= 3 && input[1].equals("/") && isNumeric(input[0])){
				double temp = Double.parseDouble(input[0]) / Double.parseDouble(input[2]);
				System.out.println("  " + temp);
			} else if(input.length <= 3 && input[1].equals("+") && !isNumeric(input[0]) && isNumeric(input[2])){
				double temp = map.get(input[0]) + Double.parseDouble(input[2]);
				System.out.println("  " + temp);
			} else if(input.length <= 3 && input[1].equals("-") && !isNumeric(input[0])&& isNumeric(input[2])){
				double temp = map.get(input[0]) -  Double.parseDouble(input[2]);
				System.out.println("  " + temp);
			} else if(input.length <= 3 && input[1].equals("*") && !isNumeric(input[0])&& isNumeric(input[2])){
				double temp = map.get(input[0]) * Double.parseDouble(input[2]);
				System.out.println("  " + temp);
			} else if(input.length <= 3 && input[1].equals("/") && !isNumeric(input[0])&& isNumeric(input[2])){
				double temp = map.get(input[0]) /  Double.parseDouble(input[2]);
				System.out.println("  " + temp);
			} else if(input.length <= 3 && input[1].equals("+") && !isNumeric(input[0]) && !isNumeric(input[2])){
				double temp = map.get(input[0]) + map.get(input[2]);
				System.out.println("  " + temp);
			} else if(input.length <= 3 && input[1].equals("-") && !isNumeric(input[0])&& !isNumeric(input[2])){
				double temp = map.get(input[0]) -  map.get(input[2]);
				System.out.println("  " + temp);
			} else if(input.length <= 3 && input[1].equals("*") && !isNumeric(input[0])&& !isNumeric(input[2])){
				double temp = map.get(input[0]) *  map.get(input[2]);
				System.out.println("  " + temp);
			} else if(input.length <= 3 && input[1].equals("/") && !isNumeric(input[0])&& !isNumeric(input[2])){
				double temp = map.get(input[0]) /  map.get(input[2]);
				System.out.println("  " + temp);
			//statements for placing into map and basic math functions for 5 length input
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("+")&& !isNumeric(input[2]) && !isNumeric(input[4])){
				map.put(input[0], (map.get(input[2]) + map.get(input[4])));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("-")&& !isNumeric(input[2]) && !isNumeric(input[4])){
				map.put(input[0], (map.get(input[2]) - map.get(input[4])));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("*")&& !isNumeric(input[2]) && !isNumeric(input[4])){
				map.put(input[0], (map.get(input[2]) * map.get(input[4])));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("/")&& !isNumeric(input[2]) && !isNumeric(input[4])){
				map.put(input[0], (map.get(input[2]) / map.get(input[4])));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("+")&& !isNumeric(input[2]) && isNumeric(input[4])){
				map.put(input[0], ( map.get(input[2]) + Double.parseDouble(input[4])));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("-")&& !isNumeric(input[2]) && isNumeric(input[4])){
				map.put(input[0],  ( map.get(input[2]) - Double.parseDouble(input[4])));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("*")&& !isNumeric(input[2]) && isNumeric(input[4])){
				map.put(input[0], ( map.get(input[2]) * Double.parseDouble(input[4])));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("/")&& !isNumeric(input[2]) && isNumeric(input[4])){
				map.put(input[0],  ( map.get(input[2]) / Double.parseDouble(input[4])));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("+")&& isNumeric(input[2]) && isNumeric(input[4])){
				map.put(input[0],  (Double.parseDouble(input[2])) + Double.parseDouble(input[4]));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("-")&& isNumeric(input[2]) && isNumeric(input[4])){
				map.put(input[0],  (Double.parseDouble(input[2])) - Double.parseDouble(input[4]));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("*")&& isNumeric(input[2]) && isNumeric(input[4])){
				map.put(input[0],  (Double.parseDouble(input[2])) * Double.parseDouble(input[4]));
				System.out.println("  " + map.get(input[0]));
			} else if(input.length <= 5 && input[1].equals("=") && input[3].equals("/")&& isNumeric(input[2]) && isNumeric(input[4])){
				map.put(input[0],  (Double.parseDouble(input[2])) / Double.parseDouble(input[4]));
				System.out.println("  " + map.get(input[0]));
			//statements for getting variables from map for 5 and basic math functions
			} else if(input.length <= 5 && input[3].equals("+") && !isNumeric(input[0])){
				double temp = Double.parseDouble(input[2]) + Double.parseDouble(input[4]);
				System.out.println("  " + temp);
			} else if(input.length <= 5 && input[3].equals("-") && !isNumeric(input[0])){
				double temp =  Double.parseDouble(input[2]) - Double.parseDouble(input[4]);
				System.out.println("  " + temp);
			} else if(input.length <= 5 && input[3].equals("*") && !isNumeric(input[0])){
				double temp =  Double.parseDouble(input[2]) * Double.parseDouble(input[4]);
				System.out.println("  " + temp);
			} else if(input.length <= 5 && input[3].equals("/") && !isNumeric(input[0])){
				double temp = Double.parseDouble(input[2]) / Double.parseDouble(input[4]);
				System.out.println("  " + temp);
			} else if(input.length <= 5 && input[3].equals("+") && !isNumeric(input[0])){
				double temp = map.get(input[2]) + Double.parseDouble(input[4]);
				System.out.println("  " + temp);
			} else if(input.length <= 5 && input[3].equals("-") && !isNumeric(input[0])){
				double temp =  map.get(input[2]) - Double.parseDouble(input[4]);
				System.out.println("  " + temp);
			} else if(input.length <= 5 && input[3].equals("*") && !isNumeric(input[0])){
				double temp =  map.get(input[2]) * Double.parseDouble(input[4]);
				System.out.println("  " + temp);
			} else if(input.length <= 5 && input[3].equals("/") && !isNumeric(input[0])){
				double temp = map.get(input[2]) / Double.parseDouble(input[4]);
				System.out.println("  " + temp);
			//statements for getting variables from map for 5 and basic math functions
			} else if(input.length <= 5 && input[3].equals("+") && !isNumeric(input[0])){
				double temp = map.get(input[2]) + map.get(input[4]);
				System.out.println("  " + temp);
			} else if(input.length <= 5 && input[3].equals("-") && !isNumeric(input[0])){
				double temp = map.get(input[2]) -  map.get(input[4]);
				System.out.println("  " + temp);
			} else if(input.length <= 5 && input[3].equals("*") && !isNumeric(input[0])){
				double temp = map.get(input[2]) *  map.get(input[4]);
				System.out.println("  " + temp);
			} else if(input.length <= 5 && input[3].equals("/") && !isNumeric(input[0])){
				double temp = map.get(input[2]) /  map.get(input[4]);
				System.out.println("  " + temp);	
			}
		}
	}
}