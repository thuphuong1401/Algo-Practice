class MaxHeap {
    List<Integer> heap;
    
    public MaxHeap() {
        heap = new ArrayList<>();
    }
    
    public void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    public void add(int val) {
        heap.add(val);
        int currIndex = heap.size() - 1;
        int parentIndex = (currIndex - 1) / 2;
        
        while(heap.get(parentIndex) < heap.get(currIndex)) {
            swap(parentIndex, currIndex);
            currIndex = parentIndex;
            parentIndex = (currIndex - 1)/2;
        }
    }
    
    public int poll() {
        if(isEmpty()) {
            return -1;
        }
        int max = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        maxHeapify(0);
        return max;
    }
    
    public boolean isEmpty() {
        return heap.size() == 0;
    }
    
    public void maxHeapify(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int original = index;
        
        // swap heap[index] with its larger child
        if(leftChild < heap.size() && heap.get(leftChild) > heap.get(original)) {
            original = leftChild;
        }
        
        if(rightChild < heap.size() && heap.get(rightChild) > heap.get(original)) {
            original = rightChild;
        }
        
        if(original != index) {
            swap(original, index);
            maxHeapify(original);
        }
    }
    
}
