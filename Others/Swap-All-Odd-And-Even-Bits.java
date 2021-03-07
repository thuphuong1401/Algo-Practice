https://www.geeksforgeeks.org/swap-all-odd-and-even-bits

Given a binary number, swaps its odd bits with its even bits.
Idea:
- Get all even bits by masking the number (&) with 0xaaaaaaa
- Get all odd bits by masking the number (&) with 0x5555555
- Shift right even bits by 1, shift left off bits by 1.
- Or (|) the shifting result.
