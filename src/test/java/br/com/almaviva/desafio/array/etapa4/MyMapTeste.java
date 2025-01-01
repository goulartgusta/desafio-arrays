package br.com.almaviva.desafio.array.etapa4;

import org.junit.jupiter.api.Test;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.*;

public class MyMapTeste {

	@Test
	public void testAmpliarArray() {
		MyMap<Integer, String> map = new MyMap<>();
		for (int i = 0; i < 15; i++) {
			map.put(i, "Value " + i);
		}
		for (int i = 0; i < 15; i++) {
			assertEquals("Value " + i, map.get(i));
		}
		assertEquals(15, map.size());
	}

	@Test
	public void testPutAndGet() {
		MyMap<String, Integer> map = new MyMap<>();
		assertNull(map.put("One", 1));
		assertEquals(1, map.get("One"));
		assertNull(map.get("Two"));
		assertEquals(1, map.size());
	}

	@Test
	public void testPutIfAbsent() {
		MyMap<String, Integer> map = new MyMap<>();
		assertNull(map.putIfAbsent("One", 1));
		assertEquals(1, map.putIfAbsent("One", 2));
	}

	@Test
	public void testRemove() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		assertEquals(1, map.remove("One"));
		assertNull(map.remove("Two"));
	}

	@Test
	public void testRemoveWithValue() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		assertTrue(map.remove("One", 1));
		assertFalse(map.remove("One", 2));
		assertFalse(map.remove("Two", 1));
	}

	@Test
	public void testReplace() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		assertEquals(1, map.replace("One", 2));
		assertNull(map.replace("Two", 2));
	}

	@Test
	public void testReplaceWithValue() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		assertTrue(map.replace("One", 1, 2));
		assertFalse(map.replace("One", 1, 3));
		assertFalse(map.replace("Two", 2, 3));
	}

	@Test
	public void testReplaceAll() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		map.put("Two", 2);
		map.replaceAll((key, value) -> value * 2);
		assertEquals(2, map.get("One"));
		assertEquals(4, map.get("Two"));
	}

	@Test
	public void testContainsKey() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		assertTrue(map.containsKey("One"));
		assertFalse(map.containsKey("Two"));
	}

	@Test
	public void testContainsValue() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		assertTrue(map.containsValue(1));
		assertFalse(map.containsValue(2));
	}

	@Test
	public void testForEach() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		map.put("Two", 2);
		StringBuilder result = new StringBuilder();
		map.forEach((key, value) -> result.append(key).append(value));
		assertTrue(result.toString().contains("One1"));
		assertTrue(result.toString().contains("Two2"));
	}

	@Test
	public void testCompute() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		assertEquals(2, map.compute("One", (key, value) -> value + 1));
		assertEquals(1, map.compute("Two", (key, value) -> value == null ? 1 : value + 1));
	}

	@Test
	public void testComputeIfAbsent() {
		MyMap<String, Integer> map = new MyMap<>();
		assertEquals(1, map.computeIfAbsent("One", key -> 1));
		assertEquals(1, map.computeIfAbsent("One", key -> 2));
	}

	@Test
	public void testComputeIfPresent() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		assertEquals(2, map.computeIfPresent("One", (key, value) -> value + 1));
		assertNull(map.computeIfPresent("Two", (key, value) -> value + 1));
	}

	@Test
	public void testMerge() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		assertEquals(3, map.merge("One", 2, Integer::sum));
		assertEquals(2, map.merge("Two", 2, Integer::sum));
	}

	@Test
	public void testKeysAndValues() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		map.put("Two", 2);

		Object[] keys = map.keys();
		Object[] values = map.values();

		assertArrayEquals(new Object[] { "One", "Two" }, keys);
		assertArrayEquals(new Object[] { 1, 2 }, values);
	}

	@Test
	public void testToString() {
		MyMap<String, Integer> map = new MyMap<>();
		map.put("One", 1);
		map.put("Two", 2);
		assertEquals("{One=1, Two=2}", map.toString());
	}
}
