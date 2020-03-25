package com.java.recruitme;

import org.junit.Assert;
import org.junit.Test;

public class IntegerToRomanTest {

	@Test(expected = IllegalArgumentException.class)
	public void numberGreaterThanFiveThousand() {
		ConvertIntegerToRoman convertIntegerToRoman = new ConvertIntegerToRoman();
		convertIntegerToRoman.getRomanLetter(5000);
	}

	@Test
	public void getRomanValue1() {
		ConvertIntegerToRoman convertIntegerToRoman = new ConvertIntegerToRoman();
		String res = convertIntegerToRoman.getRomanLetter(4000);
		Assert.assertEquals("MMMM", res);
	}
}
