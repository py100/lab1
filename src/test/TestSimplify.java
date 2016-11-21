package test;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.opencsv.CSVReader;

import exp1.Expression;

public class TestSimplify {

	Expression ex;
	

	@Test
	public void test1() {
		ex = new Expression();
		ex.init("y*y");
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
		ex.init("x*x");
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
		ex.init("x+y*y");
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
		ex.init("5");
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
		ex.init("x+x*x+x*x*x*y");
		ex.simplify('x', 2);
		ex.merge();
		System.out.println(ex.tostr());
		if (ex.tostr().compareTo("6+8*y") != 0) {
			fail("Wrong Answer");
		}
	}
}
/*@Test
public void test() throws IOException {
	CSVReader cin = new CSVReader(new FileReader("input.csv"));

	Expression ex = new Expression();

	String[] nextLine;
	while ((nextLine = cin.readNext()) != null) {
		// nextLine[] is an array of values from the line
		int n = nextLine.length;
		ex.init(nextLine[0]);

		for (int i = 1; i < n - 1; i++) {
			String[] tmp = nextLine[i].split("=");
			ex.simplify(tmp[0].charAt(0), Integer.valueOf(tmp[1]));
		}
		ex.merge();

		System.out.println(ex.tostr());
		System.out.println(nextLine[n - 1]);
		if (ex.tostr().compareTo(nextLine[n - 1]) != 0) {
			fail("Wrong Answer");
		}
	}
	cin.close();
}*/