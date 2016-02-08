package poem;

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
		return reg.get(id).eval();
	}

	@Override
	public String toString() {
		return String.format("[Reference] %s", id);
	}
}
