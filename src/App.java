import java.io.IOException;
import java.lang.reflect.Array;
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
		
		String wantedPlayer = userInput.nextLine();
		
		System.out.println("Getting three point average for every season for player: " + wantedPlayer);
		

		try {
			Document doc = Jsoup.connect(baseUrl).get();
			
			Boolean playerFound = false;
			// Elements playerPage = doc.getElementsByAttribute("data-append-csv");
			
			for (Element player: doc.getElementsByAttribute("data-append-csv")) {
				// String playerName = player.text();
				// System.out.println(playerName);
				
				String playerName = player.text();
				// System.out.println(playerName);
				
				
				if (wantedPlayer.equals(playerName)) {
					String url = player.select("a").attr("href");
					
					String playerUrl = "https://www.basketball-reference.com" + url;
					
					playerFound = true;
					
					Document playerPage = Jsoup.connect(playerUrl).get();
					// System.out.println(playerPage.outerHtml());
					
					for (Element page: playerPage.select("table#per_game tr")) {
						String season = page.select("th.left").text();
						
						
						if (!season.equals("Career")) {
							String threePa = page.select("td[data-stat=fg3a_per_g]").text();
							System.out.println(season + " " + threePa);
						}
						
					}
				} 
			}
			
			if (playerFound.equals(false)) {
				System.out.println("No player with name " + wantedPlayer + " found");
			}
			
			
			
			
			 //System.out.printf("Title: %s\n", doc.title());
			// System.out.println(doc.outerHtml());
			
			
			
			
			
		} catch (IOException event) {
			event.printStackTrace();
		}
		
		
	}

}
