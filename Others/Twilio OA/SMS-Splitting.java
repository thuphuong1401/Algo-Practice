import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'segments' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING message as parameter.
     */


    public static List<String> segments(String message) {
        String[] words = message.split(" ");
        List<String> answer = new ArrayList<>();
        
        // handle message with less then 160 characters
        String messageWithNoSpace = message.replaceAll("\\s+", "");
        int numCharacters = messageWithNoSpace.length();
        if(numCharacters < 160) {
            for(String word : words) {
                answer.add(word + " ");
            }
            return answer;
        }
        
        int numSegments = numCharacters / 160 + 1;
        int segmentIndex = 1;
        int numWords = words.length;
        int currCharacterCount = 0;
        
        for(int i = 0; i < numWords; i++) {
            String curr = words[i];
            if(currCharacterCount < 160) {
                answer.add(curr);
                currCharacterCount += curr.length();
            } else {
                String suffix = "(" + segmentIndex + "/" + numSegments + ")";
                currCharacterCount = 0;
                answer.add(suffix);
                answer.add(curr);
                segmentIndex++;
            }   
        }
        
        String end = "(" + segmentIndex + "/" + numSegments + ")";
        answer.add(end);
        
        return answer;
        

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String message = bufferedReader.readLine();

        List<String> result = Result.segments(message);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
