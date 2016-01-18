package Algorithms.LinkedList;

import java.text.MessageFormat;

/**
 * Created by Sebastian Börebäck on 2016-01-18.
 */
public class DoubleEndedLinkedList {

	Neighbor firstLink;
	Neighbor lastLink;

	public void insertInFirstPosition(String homeOwnerName, int houseNumber){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);


		if (isEmpty()) {
			lastLink = theNewLink;
		} else {
			firstLink.previous = theNewLink;//dbl link list
		}


		theNewLink.next = firstLink;
		firstLink = theNewLink;
	}

	public void insertInLastPosition(String homeOwnerName, int houseNumber){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		if (isEmpty()) {
			firstLink = theNewLink;
		} else {
			lastLink.next = theNewLink;
			theNewLink.previous = lastLink; // FOR DOUBLY LINKED LIST
		}

		lastLink = theNewLink;
	}

	public void insertInOrder(String homeOwnerName, int houseNumber){

		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		Neighbor previouseNeighbor = null;
		Neighbor currentNeighbor = firstLink;

		while ((currentNeighbor != null) && (houseNumber > currentNeighbor.houseNumber)) {

			previouseNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;
		}

		//if its last
		if (previouseNeighbor == null) {
			firstLink = theNewLink;
		} else {
			//if not last
			previouseNeighbor.next = theNewLink;
		}

		theNewLink.next = currentNeighbor;


	}


	public boolean insertAfterKey(String homeOwnerName, int houserNumber, int key) {

		Neighbor theNewLink = new Neighbor(homeOwnerName, houserNumber);

		Neighbor currentNeightbor = firstLink;

		while (currentNeightbor.houseNumber != key) {

			currentNeightbor = currentNeightbor.next;

			//didnt find the key
			if (currentNeightbor == null) {
				return false;
			}
		}

		//found it and its last.
		if (currentNeightbor == lastLink) {
			theNewLink.next = null;
			lastLink = theNewLink;
		} else {
			//is in the middle somewhere
			theNewLink.next = currentNeightbor.next;

			currentNeightbor.next.previous = theNewLink;
		}

		theNewLink.previous = currentNeightbor;
		currentNeightbor.next = theNewLink;

		return true;

	}


	public void display(){

		Neighbor theLink = firstLink;
		while (theLink != null) {
			theLink.display();
			System.out.println(MessageFormat.format("Next link: {0}",theLink.next ));

			theLink = theLink.next;
		}
	}

	public boolean isEmpty() {
		//TODO implement
		return (firstLink == null);
	}







	public static void main(String[] args) {
		DoubleEndedLinkedList theLinkedList = new DoubleEndedLinkedList();

		theLinkedList.insertInOrder("Mark evans",7);
		theLinkedList.insertInOrder("Pieer pope",9);
		theLinkedList.insertInOrder("matt dameon",6);
		theLinkedList.insertInOrder("john smith",4);

		theLinkedList.insertAfterKey("seb boreback", 10, 4);

		theLinkedList.display();

		System.out.println();


		NeighborIterator neighbors = new NeighborIterator(theLinkedList);

		neighbors.currentNeighbor.display();

		System.out.println(neighbors.hasNext());

		neighbors.next();

		neighbors.currentNeighbor.display();

		neighbors.remove();

		neighbors.currentNeighbor.display();

	}



}

//link class
class Neighbor {
	public String homeOwnerName;
	public int houseNumber;

	public Neighbor next;
	public Neighbor previous;


	public Neighbor(String homeOwnerName, int houseNumber) {
		this.homeOwnerName = homeOwnerName;
		this.houseNumber = houseNumber;
	}

	public void display() {
		System.out.println(homeOwnerName + ": " + houseNumber + " Privet Drive");
	}

	@Override
	public String toString() {
		return homeOwnerName;


	}
}

//Link iterator
class NeighborIterator{


	Neighbor currentNeighbor;
	Neighbor previouseNeighbor;

	DoubleEndedLinkedList theNeigbhbors;

	NeighborIterator(DoubleEndedLinkedList theNeighbors){
		this.theNeigbhbors = theNeighbors;

		currentNeighbor = theNeigbhbors.firstLink;
		previouseNeighbor= theNeigbhbors.lastLink;


	}

	public boolean hasNext(){
		if (currentNeighbor.next != null) {
			return true;
		}
		return false;
	}

	public Neighbor next(){
		if (hasNext()) {
			previouseNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;

			return currentNeighbor;
		}
		return null;
	}

	public void remove(){
		if (previouseNeighbor == null) {
			theNeigbhbors.firstLink = currentNeighbor.next;
		} else {
			previouseNeighbor.next = currentNeighbor.next;

			if (currentNeighbor.next == null) {
				currentNeighbor = theNeigbhbors.firstLink;
				previouseNeighbor = null;
			} else {
				currentNeighbor = currentNeighbor.next;
			}
		}
	}


}


