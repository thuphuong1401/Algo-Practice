package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
/*
Question: How to compute the parity of a very large number of 64-bit words?

Ans: use a look up table. Tl;dr: break a 64-bit word into 4 chunks of 16-bit. Calculate parity of each then XOR all four together.
1. Store parity of all 16-bit number. For instance: (0-0), (1-1), (2-1), (3-0), etc.
2. Break up word into 4 16-bit chunks. First chunk: (word >>>= (3 * 16)) & (bit mask), second chunk: (word >>>= (2 * 16)) & (bit mask in order 
to "masked" the first chunk), etc.
3. XOR all 4 result together.
*/
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
