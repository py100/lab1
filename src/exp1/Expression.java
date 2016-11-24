package exp1;

import java.util.ArrayList;

public class Expression {

	ArrayList<Node> an;
	String str;
	
	
	
	public void setAn(ArrayList<Node> an) {
		this.an = an;
	}

	public void show() {
		for (int i = 0; i < an.size(); i++) {
			if (i != 0 && an.get(i).var >= 0) {
				System.out.print("+");
			}
			an.get(i).showNode1();
		}

		if (an.size() == 0) {
			System.out.print("0");
		}
		System.out.println();
	}

	public void adjust() {
		for (int i = 0; i < an.size(); i++) {
			an.get(i).adjust();
		}
	}

	public void merge() {
		ArrayList<Node> atmp = new ArrayList<Node>();
		Node nd1;
		Node nd2;
		for (int i = 0; i < an.size(); i++) {
			nd1 = an.get(i);
			for (int j = i + 1; j < an.size(); j++) {
				nd2 = an.get(j);
				if (nd2.str.compareTo(nd1.str) == 0) {
					nd1.var += nd2.var;
					nd2.var = 0;
					an.set(j, nd2);
				}
			}
			if (nd1.var != 0) {
				atmp.add(nd1);
			}
		}
		an = atmp;
	}

	public void simplify(char ch, int dig) {
		ArrayList<Node> tmp = new ArrayList<Node>();
		for (int i = 0; i < an.size(); i++) {
			tmp.add(an.get(i).simplify(ch, dig));
		}
		an = tmp;
	}

	void deri(char ch) {
		ArrayList<Node> tmp = new ArrayList<Node>();
		for (int i = 0; i < an.size(); i++) {
			tmp.add(an.get(i).deri(ch));
		}
		an = tmp;
	}

	public String tostr() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < an.size(); i++) {
			if (i != 0 && an.get(i).var >= 0) {
				sb.append("+");
			}
			sb.append(an.get(i).tostr1());
		}

		if (an.size() == 0) {
			sb.append("0");
		}
		return sb.toString();
	}

}
