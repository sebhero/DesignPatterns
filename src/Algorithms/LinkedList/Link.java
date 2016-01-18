package Algorithms.LinkedList;

import java.text.MessageFormat;

/**
 * Created by Sebastian Börebäck on 2016-01-18.
 */
public class Link {

	public String bookName;
	public int millionSold;
	
	public Link next;

	public Link(String bookName, int millionSold) {
		this.bookName = bookName;
		this.millionSold = millionSold;
	}

	public void display() {
		System.out.println(MessageFormat.format("{0} : {1},000,000", bookName, millionSold));
	}

	@Override
	public String toString() {
		return bookName;
	}

	public static void main(String[] args) {
		LinkList theLinkList = new LinkList();

		theLinkList.insertFirstLink("Don quixote", 500);
		theLinkList.insertFirstLink("Figthclub", 200);
		theLinkList.insertFirstLink("A tale of two cities", 50);
		theLinkList.insertFirstLink("The lord of the rings", 150);
		theLinkList.insertFirstLink("Harry potter 1", 250);

		theLinkList.display();

		System.out.println("Remove first item: harry potter");
		//remove harry potter
		theLinkList.removeFirst();
		theLinkList.display();

		System.out.println();
		System.out.println("Find book: the lord of the rings");
		System.out.println();
		System.out.println(theLinkList.find("The lord of the rings").bookName+" was found");

		System.out.println();
		System.out.println("Remove don quixote");
		System.out.println();
		theLinkList.removeLink("Don quixote");


	}

}

class LinkList{
	public Link firstLink;

	public LinkList() {
		firstLink = null;
	}

	public boolean isEmpty() {
		return (firstLink == null);
	}

	public void insertFirstLink(String bookName, int millionSold) {
		Link newLink = new Link(bookName, millionSold);

		newLink.next = firstLink;

		firstLink = newLink;
	}

	public Link removeFirst() {
		Link linkRefrence = firstLink;

		if (!isEmpty()) {
			firstLink = firstLink.next;
		} else {
			System.out.println("Empty link list");
		}

		return linkRefrence;
	}

	public void display() {
		Link theLink = firstLink;

		while (theLink != null) {

			theLink.display();
			System.out.println(MessageFormat.format("Next link: {0}", theLink.next));

			theLink = theLink.next;

			System.out.println();

		}
	}

	public Link find(String bookName) {
		Link theLink = firstLink;

		if (!isEmpty()) {
			while (theLink.bookName != bookName) {


				if (theLink.next == null) {
					System.out.println("Didnt find book");
					return null;
				} else {
					theLink = theLink.next;
				}
			}
		} else {
			System.out.println("Empty LinkedList");

		}

		return theLink;
	}

	public Link removeLink(String bookName) {
		Link currentLink = firstLink;
		Link previouseLink = firstLink;

		while (currentLink.bookName != bookName) {

			if (currentLink.next == null) {
				return null;
			} else {
				previouseLink = currentLink;

				currentLink = currentLink.next;
			}
		}

		if (currentLink == firstLink) {

			firstLink = firstLink.next;

		} else {
			previouseLink.next = currentLink.next;
		}

		return currentLink;

	}
}
