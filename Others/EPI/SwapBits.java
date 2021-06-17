package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class SwapBits {
	@EpiTest(testDataFile = "swap_bits.tsv")
	public static long swapBits(long x, int i, int j) {
		short ithBit = (short) ((x >> i) & 1);
		short jthBit = (short) ((x >> j) & 1);
		if(ithBit == jthBit) {
			return x;
		} else {
			long ithMask = (1L << i);
			x ^= ithMask;
			long jthMask = (1L << j);
			x ^= jthMask;
		}
		return x;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "SwapBits.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
