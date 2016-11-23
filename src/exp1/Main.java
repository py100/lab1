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

		Control ctrler = new Control();
		String cmd;
		String result;
		while (cin.hasNext()) {
			cmd = cin.nextLine();
			ctrler.initCmd(cmd);
			ctrler.excuteCmd();
			result = ctrler.output();
			System.out.println(result);
		}
		System.exit(0);
	}
}
