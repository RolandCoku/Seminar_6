/*
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private final DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}

	public String findBookTitlesByAuthor(String author) {
		StringBuilder sb = new StringBuilder();
		try {
			for (Book b : dataTier.getAlLBooks()) {
				String authorName = b.getAuthor();
				if (authorName.toLowerCase().contains(author.toLowerCase())) {
					sb.append(b.getTitle()).append("\n");
				}
			}
		} catch (Exception e) {
			return "Error retrieving data";
		}
		return sb.toString();
	}

	public String findNumberOfBooksInYear(int year) {
		int count = 0;
		try {
			for (Book b : dataTier.getAlLBooks()) {
				if (b.getPublicationYear() == year) {
					count++;
				}
			}
		} catch (Exception e) {
			return "Error retrieving data";
		}
		return String.valueOf(count);
	}
	

}
