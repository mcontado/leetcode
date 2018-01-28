package test;

import static org.junit.Assert.*;

import org.junit.Test;

import easy.NumberComplement;

public class NumberComplementTest {

	@Test
	public void testFindComplement() {
		assertEquals(0, NumberComplement.findComplement(1));
		assertEquals(2, NumberComplement.findComplement(5));
		assertEquals(1, NumberComplement.findComplement(6));
		
	}

}
