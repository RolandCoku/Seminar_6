/*
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataTier {
	
	private final String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}

	public List<Book> getAlLBooks() throws Exception {
		List<Book> books = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split("	");
				books.add(new Book(tokens[0], tokens[1], Integer.parseInt(tokens[2])));
			}
		} catch (IOException e) {
			throw new Exception("Error retrieving data");
		}
		return books;
	}


}
