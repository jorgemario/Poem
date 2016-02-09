package poem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by jorgemario on 2/2/16.
 */
public class Poem implements Expression {

	private static final Pattern RULE = Pattern.compile("^\\s*([A-Z]+):\\s*(.+)$");

	private final RuleRegistry registry = new RuleRegistry();
	private final ExpressionFactory factory = new ExpressionFactory();

	public Poem(List<String> rules) {
		rules.forEach(rule -> {
			Matcher m = RULE.matcher(rule);
			if (m.find()) {
				registry.add("<" + m.group(1) + ">", factory.sequence(m.group(2)));
			} else {
				throw new RuntimeException(String.format("Invalid Rule \"%s\"", rule));
			}
		});
	}

	@Override
	public String eval() {
		Optional<Expression> root = registry.get("<POEM>");
		if (root.isPresent()) {
			return root.get().eval();
		} else {
			throw new RuntimeException("POEM Rule not found");
		}
	}

	/**
	 * To Create Expressions
	 */
	class ExpressionFactory {

		Expression get(String text) {
			if (text.startsWith("<")) {
				return reference(text);
			} else if (text.startsWith("$")) {
				return keyword(text);
			} else {
				return word(text);
			}
		}

		Expression reference(String text) {
			return new Reference(text.trim(), registry);
		}

		Expression keyword(String text) {
			return Keyword.of(text.trim());
		}

		Expression word(String wordText) {
			return new Word(wordText);
		}

		Expression sequence(String text) {
			List<Expression> list = Arrays.asList(text.split("\\s+")).stream()
					.map(s -> oneOf(s))
					.collect(Collectors.toList());
			return new Sequence(list.toArray(new Expression[list.size()]));
		}

		Expression oneOf(String text) {
			if (!text.contains("|")) {
				return factory.get(text);
			}
			List<Expression> list = Arrays.asList(text.split("\\|")).stream()
					.map(t -> get(t))
					.collect(Collectors.toList());
			return new OneOf(list.toArray(new Expression[list.size()]));
		}
	}

}
