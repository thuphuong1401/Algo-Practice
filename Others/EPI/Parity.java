package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class Parity {
	@EpiTest(testDataFile = "parity.tsv")
	public static short parity(long x) {
		short ans = 0;
		while(x != 0) {
			if((x & 0x1) == (short)1) {
				ans ^= 1;
			}
			x >>>= 1;
		}
		return ans;	
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "Parity.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
