package Algorithms.stacks_quest;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by Sebastian Börebäck on 2016-01-18.
 */
public class TheStack {

	String[] stackArray;
	int stackSize;

	int topOfStack = -1;

	TheStack(int stackSize) {
		this.stackSize = stackSize;

		stackArray = new String[stackSize];
		Arrays.fill(stackArray, "-1");
	}

	public void push(String input) {
		if (topOfStack + 1 < stackSize) {
			topOfStack++;

			stackArray[topOfStack] = input;
		}
		else
		{
			System.out.println("Sorry but the stack is full");

		}

		displayTheStack();

		System.out.println(MessageFormat.format("PUSH {0} was added to the stack",input));
	}

	private void displayTheStack() {
		for(int n = 0; n < 61; n++)System.out.print("-");

		System.out.println();

		for(int n = 0; n < stackSize; n++){

			System.out.format("| %2s "+ " ", n);

		}

		System.out.println("|");

		for(int n = 0; n < 61; n++)System.out.print("-");

		System.out.println();

		for(int n = 0; n < stackSize; n++){



			if(stackArray[n].equals("-1")) System.out.print("|     ");

			else System.out.print(String.format("| %2s "+ " ", stackArray[n]));

		}

		System.out.println("|");

		for(int n = 0; n < 61; n++)System.out.print("-");

		System.out.println();
	}

	public String pop() {
		if (topOfStack >= 0) {

			displayTheStack();

			System.out.println(MessageFormat.format("POP {0} Was removed from the stack", stackArray[topOfStack]));

			stackArray[topOfStack] = "-1";

			return stackArray[topOfStack--];
		}
		else {
			displayTheStack();

			System.out.println("Sorry but the stack is empty");
			return "-1";
		}
	}

	public String peek() {
		displayTheStack();

		System.out.println(MessageFormat.format("PEEK  {0} is att the top of the array", stackArray[topOfStack]));

		return stackArray[topOfStack];
	}

	public void pushMany(String multipleValues) {
		String[] tempString = multipleValues.split(" ");

		for (String item : tempString) {
			push(item);
		}

	}

	public static void main(String[] args) {
		TheStack theStack = new TheStack(10);

		theStack.push("10");
		theStack.push("15");

		theStack.peek();

		theStack.pop();
		theStack.displayTheStack();

		theStack.pushMany("1 2 3 4 5 55");

		theStack.displayTheStack();

		theStack.popAll();
		theStack.displayTheStack();
	}


	private void popAll() {
		for(int i = topOfStack; i >= 0; i--){
			pop();
		}
	}


}
