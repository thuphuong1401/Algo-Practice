/*
https://onlinejudge.org/external/119/11935.pdf
*/
import java.util.*;
import java.io.*;
import java.text.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        double total = 0;
        double minTank = 0;
        double end = 0;
        double n = 0;
        double leakCount = 0;
        
        while(true) {
            String line = scan.nextLine();
            String[] input = line.split(" ");
            double start = Double.parseDouble(input[0]);
            total += (n / 100 + leakCount) * (start - end);
            minTank = Math.max(minTank, total);
            end = start;
            
            String event = input[1];
            if(event.equals("Fuel")) {
                n = Double.parseDouble(input[3]);
                if(n == 0) {
                    return;
                }
            } else if(event.equals("Leak")) {
                leakCount++;
            } else if(event.equals("Gas")) {
                total = 0;
            } else if(event.equals("Mechanic")) {
                leakCount = 0;
            } else if(event.equals("Goal")) {
                DecimalFormat df = new DecimalFormat("0.000");
                System.out.printf(df.format(minTank));
                System.out.println();
                total = 0;
                start = 0;
                end = 0;
                n = 0;
                minTank = 0;
                leakCount = 0;
            }
        }
        
	}
}


