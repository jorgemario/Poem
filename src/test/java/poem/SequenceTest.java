package poem;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by jorgemario on 2/2/16.
 */
public class SequenceTest {

	@Test
	public void words() throws Exception {
		String result = new Sequence(new Word("hola"), new Word("que"), new Word("tal")).eval();
		assertEquals("hola que tal", result);
	}

}
