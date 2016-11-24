package test;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.opencsv.CSVReader;

import exp1.Expression;
import exp1.Control;
public class TestSimplify {

	Expression ex;
	Control con;

	@Test
	public void test1() {
		ex = new Expression();
		con.init("y*y");
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
		ex.simplify('x', 2);
		ex.merge();
		System.out.println(ex.tostr());
		if (ex.tostr().compareTo("6+8*y") != 0) {
			fail("Wrong Answer");
		}
	}
}
