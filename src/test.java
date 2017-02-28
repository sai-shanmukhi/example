import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void testcon() {
		Hello h1 = new Hello();
		String result = h1.concatenate("one","two");
		assertEquals("onetwo",result);
	}
}
