package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exp1.Expression;
import exp1.Control;

public class TestSimplify {

	Expression ex;
	Control con;

	@Before
	public void init() {
		con = new Control();
	}

	@Test
	public void test1() {
		ex = new Expression();
		con.init("y*y");
		ex.setAn(con.an);
		ex.simplify('y', 2);
		ex.merge();
		System.out.println(ex.tostr());
		if (ex.tostr().compareTo("4") != 0) {
			fail("Wrong Answer");
		}
	}

	@Test
	public void test2() {
		ex = new Expression();
		con.init("x*x");
		ex.setAn(con.an);
		ex.simplify('y', 2);
		ex.merge();
		System.out.println(ex.tostr());
		if (ex.tostr().compareTo("1*x^2") != 0) {
			fail("Wrong Answer");
		}
	}

	@Test
	public void test3() {
		ex = new Expression();
		con.init("x+y*y");
		ex.setAn(con.an);
		ex.simplify('y', 2);
		ex.merge();
		System.out.println(ex.tostr());
		if (ex.tostr().compareTo("1*x+4") != 0) {
			fail("Wrong Answer");
		}
	}

	@Test
	public void test4() {
		ex = new Expression();
		con.init("5");
		ex.setAn(con.an);
		ex.simplify('y', 2);
		ex.merge();
		System.out.println(ex.tostr());
		if (ex.tostr().compareTo("5") != 0) {
			fail("Wrong Answer");
		}
	}

	@Test
	public void test5() {
		ex = new Expression();
		con.init("x+x*x+x*x*x*y");
		ex.setAn(con.an);
		ex.simplify('x', 2);
		ex.merge();
		System.out.println(ex.tostr());
		if (ex.tostr().compareTo("6+8*y") != 0) {
			fail("Wrong Answer");
		}
	}
}
