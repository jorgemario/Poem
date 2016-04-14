package poem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgemario on 4/14/16.
 */
public class Application {
	public static void main(String[] args) {
		List<String> rules = new ArrayList<>();
		try (
			InputStream inputStream = Application.class.getResourceAsStream("/rules.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
		) {
			String line;
			while ((line = br.readLine()) != null) {
				rules.add(line);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error reading rules.txt file", e);
		}

		Poem poem = new Poem(rules);
		System.out.println(poem.poem());
	}
}
