package poem;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Sequence is a list of Expressions that are evaluated and added to the result.
 *
 * Created by jorgemario on 2/2/16.
 */
public class Sequence implements Expression {

	private final Expression[] expressions;

	public Sequence(Expression... expressions) {
		this.expressions = expressions;
	}

	@Override
	public String eval() {
		return String.join(" ",
				Arrays.asList(expressions).stream()
						.map(exp -> exp.eval())
						.collect(Collectors.toList())
		);
	}

	@Override
	public String toString() {
		return String.format("[Sequence] %s", Arrays.asList(expressions).stream().map(exp -> exp.toString()).collect(
				Collectors.joining()));
	}
}
