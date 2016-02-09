package poem;

import java.util.Optional;

/**
 * A Reference refers to a Rule.
 * It's not evaluated at construction time but at eval() time.
 *
 * Created by jorgemario on 2/2/16.
 */
public class Reference implements Expression {

	private final String id;
	private final RuleRegistry reg;

	public Reference(String id, RuleRegistry reg) {
		this.id = id;
		this.reg = reg;
	}

	@Override
	public String eval() {
		Optional<Expression> exp = reg.get(id);
		if (exp.isPresent()) {
			return exp.get().eval();
		} else {
			throw new RuntimeException(String.format("ERROR Reference \"%s\" not found", id));
		}
	}

	@Override
	public String toString() {
		return String.format("[REF] %s ", id);
	}
}
