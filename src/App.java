import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl = "https://www.basketball-reference.com/leagues/NBA_2020_per_game.html";
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter player name: ");
		
		String playerName = userInput.nextLine();
		// System.out.println(playerName);
		try {
			Document doc = Jsoup.connect(baseUrl).get();
			
			Elements playerPage = doc.getElementsByAttribute("data-append-csv");
			
			// System.out.printf("Title: %s\n", doc.title());
			// System.out.println(doc.outerHtml());
			// System.out.println(playerPage);
		} catch (IOException event) {
			event.printStackTrace();
		}
		
		
	}

}
