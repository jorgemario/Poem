package poem;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by jorgemario on 2/3/16.
 */
public class RuleRegistry {
	private final Map<String, Expression> rules;

	public RuleRegistry() {
		rules = new HashMap<>();
	}

	public Optional<Expression> get(String ruleId) {
		return Optional.ofNullable(rules.get(ruleId));
	}

	public void add(String ruleId, Expression exp) {
		rules.put(ruleId, exp);
	}
}
