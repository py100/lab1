package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exp1.Boundary;

public class ExpressionTest {
	Boundary bound;

	String excuteResult(String str) {
		bound.initCmd(str);
		return bound.excuteCmd();
	}

	@Before
	public void init() {
		bound = new Boundary();
	}

	@Test
	public void testInit1() {
		assertEquals("1*x+3+1*y", excuteResult("x+3+y"));
	}

	@Test
	public void testInit2() {
		assertEquals("1*x-10-1*y", excuteResult("x-5-5-y"));
	}

	@Test
	public void testInit3() {
		assertEquals("4+1*x", excuteResult("5+x+y+8-9-y"));
	}

	@Test
	public void testInit4() {
		assertEquals("30*x*y^2", excuteResult("x*5*6*y*y"));
	}

	@Test
	public void testInit5() {
		assertEquals("7*x+1*y^3", excuteResult("x*7+y*y*y"));
	}

	@Test
	public void testInit6() {
		assertEquals("1*x-5*y^2", excuteResult("x-y*y*5"));
	}

	@Test
	public void testInit7() {
		assertEquals("4*x^2+1*y-3*z^3", excuteResult("x*4*x+y-z*z*z*3"));
	}

	@Test
	public void testInit8() {
		assertEquals("6*x^4*y^2", excuteResult("x^4*6*y^2"));
	}

	@Test
	public void testInit9() {
		assertEquals("1*x^3+2*x*y^5", excuteResult("x^3+x*y^5*2"));
	}

	@Test
	public void testInit10() {
		assertEquals("1*x^3-2*x*y^5", excuteResult("x^3-x*y^5*2"));
	}

	@Test
	public void testInit11() {
		assertEquals("6*x^2*y^3+4-8*z^5", excuteResult("x^2*6*y^3+4-8*z^5"));
	}

	@Test
	public void testInit12() {
		assertEquals("Input error!!", excuteResult("xx*yy"));
	}

	@Test
	public void testInit13() {
		assertEquals("Input error!!", excuteResult("&*7"));
	}

	@Test
	public void testInit14() {
		assertEquals("Input error!!", excuteResult("x&y"));
	}

	@Test
	public void testInit15() {
		assertEquals("Input error!!", excuteResult("x+*y--z"));
	}

	@Test
	public void testInit16() {
		assertEquals("Input error!!", excuteResult("xx+x3"));
	}

	@Test
	public void testInit17() {
		assertEquals("Input error!!", excuteResult(" "));
	}

	@Test
	public void testInit18() {
		assertEquals("Input error!!", excuteResult("^x^3"));
	}

	@Test
	public void testInit19() {
		assertEquals("Input error!!", excuteResult("3^3"));
	}

	@Test
	public void testInit20() {
		assertEquals("Input error!!", excuteResult("3+x^"));
	}

	@Test
	public void testInit21() {
		assertEquals("Input error!!", excuteResult("x^x"));
	}

	@Test
	public void testInit22() {
		assertEquals("Input error!!", excuteResult("x+3-"));
	}

	@Test
	public void testInit23() {
		assertEquals("Input error!!", excuteResult("x*3+"));
	}

	@Test
	public void testInit24() {
		assertEquals("Input error!!", excuteResult("&+3"));
	}

	@Test
	public void testInit25() {
		assertEquals("Input error!!", excuteResult("*x+x*"));
	}
}
