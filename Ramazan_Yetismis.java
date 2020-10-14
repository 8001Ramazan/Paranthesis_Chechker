/*
 * Author: Ramazan Yetiþmiþ
 * ID: 041701013
 * Date:November 11, 2018
 * Explanation:This program checks a string input that includes mathematical expressions such as includes two type of parenthesis ,which is entered by the user ,whether 
 * the parenthesis are correctly matched.In my algorithm, it takes the parenthesis to the stack only they are open type then looks the rest of the characters if it sees the
 * correct closing parenthesis it pops and they are matched, otherwise they are not.
 */


import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<11;i++) {//loops through 11 times to take math.expression.
			myFunction();//caling the main function.
			System.out.println();
		}
	}
	/**
	 * method prints the stack if it is empty throws exception
	 * @return void
	 */
	public static void printStack(myStack <Character> s) {
		if(s.isEmpty()) {
			throw new NoSuchElementException("Stack is empty");//if it is empty it cannot print
		}else {

			System.out.print("Stack Contents: [top]   ");
			for (Character value : s) {
				System.out.print(" "+ value);
			}
			System.out.print("   :[bottom]");
		}

	}
	/**
	 * method looks    parenthesis whether they are correctly matched.
	 * @return boolean  
	 */
	public static boolean match(char a,char b) {

		if (a=='(' && b==')') {//looks inputs type and returns if matched.
			return true;
		}
		else if(a=='[' && b==']') {//looks inputs type and returns if matched.
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * method looks a string input and fills the stack and looks if expression is correct and prints the output.
	 * @return void
	 */
	public static void myFunction() {
		System.out.print("Enter a mathematical expression:");
		Scanner input=new Scanner(System.in);//import sacanner
		String mathExpression=input.nextLine();//takes ýnput 
		myStack <Character> stack=new myStack<>();//declare Stack
		boolean flag1=true;//boolean for the conditions
		char toChar[]=mathExpression.toCharArray();//turn the string into char array
		//System.out.println(b);
		for(int i=0;i<toChar.length;i++) {
			if(toChar[i]=='(' || toChar[i]=='[') {
				//System.out.println(b[i]);
				stack.push(toChar[i]);//þf opnenning the add to stack
				printStack(stack);//print stack
				System.out.println();
			}

			else if(toChar[i]==']' || toChar[i]==')') {
				//try {
				if(!stack.isEmpty()) {//if stack has element
					char temp=stack.pop();//remove the last one
					if(match(temp,toChar[i])) {//if they are match match flag is true
						//
						//	System.out.println();
						flag1=true;
					}else {
						flag1=false;
						//break;
					}
					//}catch (Exception e) {
				}else {//if stack is and the paranthesis is closing one is exit from the loop
					flag1=false;
					break;

				}
			}
		}
		//System.out.println("stack is  "+stack.isEmpty());
		//System.out.println();
		//printStack(stack);
		//System.out.println();
		//	System.out.println("flag is "+flag1);
		if(stack.isEmpty()&&flag1) {
			System.out.println("Parentheses are correct.");
		}
		else if(!stack.isEmpty() && flag1){
			//printStack(stack);
			System.out.println("\nParentheses do not match: Final stack is not empty!");
		}else if(stack.isEmpty()&&flag1!=true){
			System.out.println("Parentheses do not match!");
		}
		else if(!stack.isEmpty()&&flag1!=true){
			System.out.println("\nParentheses do not match: Final stack is not empty!");
		}
	}
}

