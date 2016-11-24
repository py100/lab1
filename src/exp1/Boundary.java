package exp1;

public class Boundary {
	public Expression exp;
	public String cmd;
	public Control con;
	public String output() {
		if (exp == null) {
			System.err.println("empty expression");
			return null;
		} else {
			return exp.tostr();
		}
	}

	public void initCmd(String str) {
		cmd = str.toLowerCase();
	}

	public String excuteCmd() {
		if (cmd == null) {
			System.err.println("empty command");
			return "Input error!!";
		}

		if (exp == null && cmd.charAt(0) == '!') {
			System.err.println("empty expression");
			return "Input error!!";
		}
		if (cmd.charAt(0) == '!') {
			// simplify
			if (cmd.charAt(1) == 's') {
				String[] tmp = cmd.split("\\s");

				if (!tmp[0].equals("!simplify")) {
					System.err.println("Input Error!!\nNo such operation!!");
					return "Input error!!";
					// continue;
				}
				tmp = tmp[1].split(",");
				for (int i = 0; i < tmp.length; i++) {
					tmp[i] = tmp[i].replace(" ", "");
					String[] tosimp = tmp[i].split("=");
					if (tosimp.length != 2
							|| tosimp[0].length() != 1
							|| (!(tosimp[0].charAt(0) >= 'a' && tosimp[0]
									.charAt(0) <= 'z'))) {
						System.err
								.println("Input Error!!\nNo such operation!!");
						return "Input error!!";
					}
					char tmpchar = tosimp[0].charAt(0);
					int dig = 1;
					try {
						dig = Integer.parseInt(tosimp[1]);
					} catch (Exception err) {
						System.err.println("Input Error");
						return "Input error!!";
					}
					exp.simplify(tmpchar, dig);
					exp.merge();
				}
			} else if (cmd.charAt(1) == 'd') { // d/dy
				if (cmd.length() != 5 || !cmd.substring(1, 4).equals("d/d")) {
					System.err.println("Input Error!!\nNo such operation!!");
					return "Input error!!";
				}
				char cmdchar = cmd.charAt(4);
				if (!(cmdchar >= 'a' && cmdchar <= 'z')) {
					System.err.println("Input Error!!\nNo such operation!!");
					return "Input error!!";
				}
				exp.deri(cmdchar);
				exp.merge();
			} else {
				System.err.println("Input Error!!\nNo such operation!!");
				return "Input error!!";
			}
			exp.show();
		} else { // get expression
			if (exp == null)
				exp = new Expression();
			if (!con.init(cmd)) {
				System.err.println("Input Error!!dddd");
				return "Input error!!";
				// continue;
			}
			exp.adjust();
			exp.merge();
			exp.show();
		}

		return exp.tostr();
	}
}
