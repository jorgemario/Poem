package poem;

/**
 * Created by jorgemario on 2/2/16.
 */
public class Word implements Expression {

	private final String text;

	public Word(String text) {
		this.text = text;
	}

	@Override
	public String eval() {
		return text;
	}

	@Override
	public String toString() {
		return String.format("[Word] %s", text);
	}
}
