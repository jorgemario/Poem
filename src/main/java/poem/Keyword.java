package poem;

/**
 * Created by jorgemario on 2/2/16.
 */
public class Keyword implements Expression {

	public static final Keyword END = new Keyword("$END", "");
	public static final Keyword LINE_BREAK = new Keyword("$LINEBREAK", "\r\n");

	public static final Keyword of(String keyword) {
		if (END.id.equalsIgnoreCase(keyword)) {
			return END;
		} else if (LINE_BREAK.id.equalsIgnoreCase(keyword)) {
			return LINE_BREAK;
		}
		throw new RuntimeException(String.format("keyword %s not supported", keyword));
	}

	private final String id;
	private final String text;

	public Keyword(String id, String text) {
		this.id = id;
		this.text = text;
	}

	@Override
	public String eval() {
		return text;
	}

	@Override
	public String toString() {
		return String.format("[KEY] %s ", id);
	}
}
