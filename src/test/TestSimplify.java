package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exp1.Expression;

public class TestSimplify {
	
	Expression ex;
	
	@Before
	public void init() {
		System.out.println("before init");
		ex = new Expression();
		ex.init("x+2*y");
		//ex.show();
		System.out.println("after init");
	}
	
	@Test
	public void test() {
		ex.simplify('x', 1);
		String ans = "1+2*y";
		String tmp = ex.tostr();
		
		System.out.println("tmp = " + tmp);
		System.out.println("ans = " + ans);
		
		if (tmp.compareTo(ans) != 0) {
			fail("Wrong Answer");
		}
	}

}
