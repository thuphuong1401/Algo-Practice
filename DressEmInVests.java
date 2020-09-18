import java.util.*;

public class Main {
	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int M = scan.nextInt();
    int X = scan.nextInt();
    int Y = scan.nextInt();
    int[] soldier = new int[N];
    int[] vest = new int[M];
    HashMap<Integer, Integer> output = new HashMap<Integer, Integer>();
    
    for(int i=0; i<N; i++) {
    	soldier[i] = scan.nextInt();
    }
    
    for(int i=0; i<M; i++) {
      vest[i] = scan.nextInt();
    }
    
    int i = 0, j = 0;
    while(i<N && j<M) {
      	if(vest[j] >= soldier[i] - X && vest[j] <= soldier[i] + Y) {
        	output.put(i+1, j+1);
          i++;
          j++;
        }
     		else if(vest[j] < soldier[i] - X) {
          j++;
        } 
      	else if(vest[j] > soldier[i] + Y) {
          i++;
        }
    }
    
    System.out.println(output.size());
    Iterator it = output.entrySet().iterator();
    while(it.hasNext()) {
    	Map.Entry mapElement = (Map.Entry)it.next(); 
      System.out.println(mapElement.getKey() + " " + mapElement.getValue());
    }
    
  }  
}
