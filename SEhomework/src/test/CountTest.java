package test;

import static org.junit.Assert.*;

//import org.junit.Before;
import org.junit.Test;

import src.Count;

import org.junit.Ignore;

public class CountTest {

	
	@Ignore
	public void setUp() throws Exception {
	}

	@Test
	public void testCountChar() {
		assertEquals(6,Count.CountCharacter("C:\\Users\\Dell\\Desktop\\test100.txt"));
	}

	@Test
	public void testCountWord() {
		assertEquals(2,Count.CountWord("C:\\Users\\Dell\\Desktop\\test\\test3.txt"));
	}
	
		
	@Test
	public void testCountLine() {
		assertEquals(1,Count.CountLine("C:\\Users\\Dell\\Desktop\\test\\test3.txt"));
	}
}
