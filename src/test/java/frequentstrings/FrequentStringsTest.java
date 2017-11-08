package frequentstrings;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class FrequentStringsTest {

	@Test
	public void test1() {
		FrequentStrings fs = new FrequentStrings(new String[] { "a", "a", "b", "c", "b", "b" });
		assertEquals(Arrays.asList("b", "a", "c"), fs.sortedByFrequency());
	}

	@Test
	public void test2() {
		FrequentStrings fs = new FrequentStrings(new String[] { "a", "a", "b", "c", "b", "b" });
		fs.remove("b");
		assertEquals(Arrays.asList("a", "b", "c"), fs.sortedByFrequency());
	}

	@Test
	public void test3() {
		FrequentStrings fs = new FrequentStrings();
		fs.add("shrdlu");
		assertTrue(fs.contains("shrdlu"));
	}

	@Test
	public void test4() {
		FrequentStrings fs = new FrequentStrings();
		fs.add("shrdlu");
		fs.add("shrdlu");
		assertEquals(2, fs.getCount("shrdlu"));
		fs.remove("shrdlu");
		assertTrue(fs.contains("shrdlu"));
		assertEquals(1, fs.getCount("shrdlu"));
	}

	@Test
	public void test5() {
		FrequentStrings fs1 = new FrequentStrings();
		fs1.add("etaoin");
		fs1.add("shrdlu");
		FrequentStrings fs2 = new FrequentStrings();
		fs2.add("shrdlu");
		fs2.add("etaoin");
		assertTrue(fs1.equals(fs2));
		assertTrue(fs2.equals(fs1));
		assertTrue(fs1.hashCode() == fs2.hashCode());
	}

	@Test
	public void test6() {
		FrequentStrings fs1 = new FrequentStrings();
		fs1.add("etaoin");
		fs1.add("shrdlu");
		FrequentStrings fs2 = new FrequentStrings();
		fs2.add("shrdlu");
		fs2.add("etaoin");
		fs2.add("shmoldu");
		assertTrue(!fs1.equals(fs2));
		assertTrue(!fs2.equals(fs1));
	}

	@Test
	public void test7() {
		FrequentStrings fs = new FrequentStrings(
				new String[] { "lorem", "ipsum", "lorem", "ipsum", "dolor", "et", "summit", "ipsum" });
		assertEquals(Arrays.asList("ipsum", "lorem", "dolor", "et", "summit"), fs.sortedByFrequency());
	}

}
