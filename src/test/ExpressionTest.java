package test;
import static org.junit.Assert.*;
import org.junit.Test;
import exp1.Expression;
public class ExpressionTest {
	Expression expression;
	
	@Test
	public void testInit1() {
		expression = new Expression();
		expression.init("x+3+y");
		expression.adjust();
		expression.merge();
		assertEquals("1*x+3+1*y",expression.tostr());
	}

	@Test
	public void testInit2() {
		expression = new Expression();
		expression.init("x-5-5-y");
		expression.adjust();
		expression.merge();
		assertEquals("1*x-10-1*y",expression.tostr());
	}

	@Test
	public void testInit3() {
		expression = new Expression();
		expression.init("5+x+y+8-9-y");
		expression.adjust();
		expression.merge();
		assertEquals("4+1*x",expression.tostr());
	}
	
	@Test
	public void testInit4() {
		expression = new Expression();
		expression.init("x*5*6*y*y");
		expression.adjust();
		expression.merge();
		assertEquals("30*x*y^2",expression.tostr());
	}

	@Test
	public void testInit5() {
		expression = new Expression();
		expression.init("x*7+y*y*y");
		expression.adjust();
		expression.merge();
		assertEquals("7*x+1*y^3",expression.tostr());
	}

	@Test
	public void testInit6() {
		expression = new Expression();
		expression.init("x-y*y*5");
		expression.adjust();
		expression.merge();
		assertEquals("1*x-5*y^2",expression.tostr());
	}

	@Test	
	public void testInit7() {
		expression = new Expression();
		expression.init("x*4*x+y-z*z*z*3");
		expression.adjust();
		expression.merge();
		assertEquals("4*x^2+1*y-3*z^3",expression.tostr());
	}

	@Test
	public void testInit8() {
		expression = new Expression();
		expression.init("x^4*6*y^2");
		expression.adjust();
		expression.merge();
		assertEquals("6*x^4*y^2",expression.tostr());
	}

	@Test
	public void testInit9() {
		expression = new Expression();
		expression.init("x^3+x*y^5*2");
		expression.adjust();
		expression.merge();
		assertEquals("1*x^3+2*x*y^5",expression.tostr());
	}

	@Test
	public void testInit10() {
		expression = new Expression();
		expression.init("x^3-x*y^5*2");
		expression.adjust();
		expression.merge();
		assertEquals("1*x^3-2*x*y^5",expression.tostr());
	}

	@Test
	public void testInit11() {
		expression = new Expression();
		expression.init("x^2*6*y^3+4-8*z^5");
		expression.adjust();
		expression.merge();
		assertEquals("6*x^2*y^3+4-8*z^5",expression.tostr());
	}

	@Test
	public void testInit12() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("xx*yy"));
	}

	@Test
	public void testInit13() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("&*7"));
	}

	@Test
	public void testInit14() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("x&y"));
	}

	@Test
	public void testInit15() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("x+*y--z"));
	}

	@Test
	public void testInit16() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("xx+x3"));
	}

	@Test
	public void testInit17() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init(" "));
	}
	
	@Test
	public void testInit18() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("^x^3"));
	}

	@Test
	public void testInit19() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("3^3"));
	}
	
	@Test
	public void testInit20() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("3+x^"));
	}
	
	@Test
	public void testInit21() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("x^x"));
	}
	
	@Test
	public void testInit22() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("x+3-"));
	}
	
	@Test
	public void testInit23() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("x*3+"));
	}
	
	@Test
	public void testInit24() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("&+3"));
	}

	@Test
	public void testInit25() {
		expression = new Expression();
		assertFalse("Input error!!", expression.init("*x+x*"));
	}
}



	
		