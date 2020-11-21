import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl = "https://www.nba.com/stats/";
		// WebClient client = new WebClient();
		try {
			Document doc = Jsoup.connect(baseUrl).get();
			
			System.out.printf("Title: %s\n", doc.title());
		} catch (IOException event) {
			event.printStackTrace();
		}
		
		
	}

}
