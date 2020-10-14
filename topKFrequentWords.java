/*
https://leetcode.com/problems/top-k-frequent-words/
*/


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> stringFreq = new HashMap<>();
        
    
    for(int i = 0; i < words.length; i++) {
        if(!stringFreq.containsKey(words[i])) {
            stringFreq.put(words[i], 1);
        } else {
            stringFreq.put(words[i], stringFreq.get(words[i]) + 1);
        }
    }
    
    Queue<String> maxHeap = new PriorityQueue<>(Collections.reverseOrder((a, b) -> compareFreq(stringFreq, a, b)));
    for(String i : stringFreq.keySet()) {
        maxHeap.add(i);
    }
    List<String> result = new ArrayList<>();
    for(int i = 0; i < k; i++) {
        result.add(maxHeap.poll());
    }
    return result;
    }
    
    private int compareFreq(Map<String, Integer> stringFreq, String a, String b) {
        if(stringFreq.get(a) > stringFreq.get(b)) {
            return 1; 
        }
        if(stringFreq.get(a) < stringFreq.get(b)) {
            return -1;
        } 
        if (a != b) {
            return b.compareTo(a);
        }
        
        return 0;
    }
}
