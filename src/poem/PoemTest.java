package poem;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by jorgemario on 2/3/16.
 */
public class PoemTest {

	@Test
	public void generatePoem() throws Exception {
		Poem poem = new Poem(Arrays.asList(new String[] {
				"POEM: <LINE> <LINE> <LINE> <LINE> <LINE> <LINE>",
				"LINE: <NOUN>|<PREPOSITION>|<PRONOUN> $LINEBREAK",
				"ADJECTIVE: black|white|dark|light|bright|murky|muddy|clear <NOUN>|<ADJECTIVE>|$END",
				"NOUN: heart|sun|moon|thunder|fire|time|wind|sea|river|flavor|wave|willow|rain|tree|flower|field|meadow|pasture|harvest|water|father|mother|brother|sister <VERB>|<PREPOSITION>|$END",
				"PRONOUN: my|your|his|her <NOUN>|<ADJECTIVE>",
				"VERB: runs|walks|stands|climbs|crawls|flows|flies|transcends|ascends|descends|sinks <PREPOSITION>|<PRONOUN>|$END",
				"PREPOSITION: above|across|against|along|among|around|before|behind|beneath|beside|between|beyond|during|inside|onto|outside|under|underneath|upon|with|without|through <NOUN>|<PRONOUN>|<ADJECTIVE>"
		}));
		System.out.println(poem.eval());
	}

}
