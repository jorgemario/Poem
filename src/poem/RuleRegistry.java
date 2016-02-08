package poem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jorgemario on 2/3/16.
 */
public class RuleRegistry {
	private final Map<String, Expression> rules;

	public RuleRegistry() {
		rules = new HashMap<>();
	}

	public Expression get(String ruleId) {
		return rules.getOrDefault(ruleId, Keyword.of("$END"));
	}

	public void add(String ruleId, Expression exp) {
		rules.put(ruleId, exp);
	}
}
