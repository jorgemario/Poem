package poem;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * OneOf consist of a group of Expressions that are evaluated by selecting one of the expressions randomly.
 *
 * Created by jorgemario on 2/2/16.
 */
public class OneOf implements Expression {

	private static final Random random = new Random();

	private final Expression[] expressions;

	public OneOf(Expression... expressions) {
		this.expressions = expressions;
	}

	@Override
	public String eval() {
		if (expressions.length == 0) {
			return "";
		}
		return expressions[random.nextInt(expressions.length)].eval();
	}

	@Override
	public String toString() {
		return String.format("[OneOf] %s", Arrays.asList(expressions).stream().map(exp -> exp.toString()).collect(
				Collectors.joining()));
	}
}
