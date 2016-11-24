package exp1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private static Scanner cin;

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("in1.txt");
		System.setIn(fis);
		cin = new Scanner(System.in);

		Boundary bound = new Boundary();
		String cmd;
		String result;
		while (cin.hasNext()) {
			cmd = cin.nextLine();
			bound.initCmd(cmd);
			result = bound.excuteCmd();
			System.out.println(result);
			if (result.compareTo("Input error!!") == 0)
				System.exit(0);
		}
		System.exit(0);
	}
}
