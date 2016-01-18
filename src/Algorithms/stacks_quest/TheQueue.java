package Algorithms.stacks_quest;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by Sebastian Börebäck on 2016-01-18.
 */
public class TheQueue {

	private String[] queueArray;

	int queueSize;
	int front,rear, numberOfItems = 0;

	public TheQueue(int queueSize) {
		this.queueSize = queueSize;

		queueArray = new String[queueSize];

		Arrays.fill(queueArray, "-1");

	}

	public void insert(String input) {
		if (numberOfItems + 1 <= queueSize) {
			queueArray[rear]= input;

			rear++;
			
			numberOfItems++;

			System.out.println(MessageFormat.format("Insert {0} was added to the que", input));
		}
		else
		{
			System.out.println("Sorry but the que is Full");

		}
	}

	public void remove() {
		if (numberOfItems > 0) {
			System.out.println(MessageFormat.format("Rmove {0} was removed ",queueArray[front] ));

			queueArray[front] = "-1";
			front++;
			numberOfItems--;
		}
		else {
			System.out.println("But the que is empty");
		}
	}

	public void peek() {
		System.out.println(MessageFormat.format("The first item is {0} of the queue", queueArray[front]));

	}

	public void displayTheQueue(){

		for(int n = 0; n < 61; n++)System.out.print("-");

		System.out.println();

		for(int n = 0; n < queueSize; n++){

			System.out.format("| %2s "+ " ", n);

		}

		System.out.println("|");

		for(int n = 0; n < 61; n++)System.out.print("-");

		System.out.println();

		for(int n = 0; n < queueSize; n++){


			if(queueArray[n].equals("-1")) System.out.print("|     ");

			else System.out.print(String.format("| %2s "+ " ", queueArray[n]));

		}

		System.out.println("|");

		for(int n = 0; n < 61; n++)System.out.print("-");

		System.out.println();

		// Number of spaces to put before the F

		int spacesBeforeFront = 3*(2*(front+1)-1);

		for(int k = 1; k < spacesBeforeFront; k++)System.out.print(" ");

		System.out.print("F");

		// Number of spaces to put before the R

		int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);

		for(int l = 0; l < spacesBeforeRear; l++)System.out.print(" ");

		System.out.print("R");

		System.out.println("\n");

	}

	public void priorityInsert(String input) {
		int i;

		if (numberOfItems == 0) {
			insert(input);
		} else {
			for (i = numberOfItems; i >= 0; i--) {

				if (Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {
					queueArray[i + 1] = queueArray[i];
				} else break;
			}
			queueArray[i+1] = input;
			rear++;

			numberOfItems++;
		} 
	}



	public static void main(String[] args) {
		TheQueue theQueue = new TheQueue(10);

		theQueue.priorityInsert("10");
		theQueue.priorityInsert("15");
		theQueue.priorityInsert("11");
		theQueue.priorityInsert("11");
		theQueue.priorityInsert("11");
		theQueue.priorityInsert("15");

		theQueue.displayTheQueue();

//		theQueue.remove();
		theQueue.displayTheQueue();

		theQueue.peek();


	}
}
