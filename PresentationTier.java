/*
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

import java.util.Scanner;

public class PresentationTier {
	
	private final LogicTier logicTier; // link to the Logic Tier
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	public void start() {
		System.out.println("Welcome to the Book Search Application");
		System.out.println("Enter 1 to search for books by author");
		System.out.println("Enter 2 to search for the number of books published in a year");
		System.out.println("Enter 3 to quit");
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 3) {
			System.out.print("Enter choice: ");
			try {
				choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
					case 1:
						System.out.print("Enter author: ");
						String author = scanner.nextLine();
						showBookTitlesByAuthor(author);
						break;
					case 2:
						System.out.print("Enter year: ");
						int year = scanner.nextInt();
						showNumberOfBooksInYear(year);
						break;
					case 3:
						System.out.println("Goodbye!");
						break;
					default:
						System.out.println("Invalid choice");
				}
			} catch (Exception e) {
				System.out.println("Invalid input");
				scanner.nextLine();
			}
		}
	}

	public void showBookTitlesByAuthor(String author) {
		if (author == null || author.isEmpty()) {
			System.out.println("Error: Invalid author");
			return;
		}
		System.out.println(logicTier.findBookTitlesByAuthor(author));
	}

	public void showNumberOfBooksInYear(int year) {
		if (year < 0) {
			System.out.println("Error: Invalid year");
			return;
		}
		System.out.println(logicTier.findNumberOfBooksInYear(year));
	}
	

}
