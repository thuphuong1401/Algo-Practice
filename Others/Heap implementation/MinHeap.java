class MinHeap {
    List<Long> heap;
    
    public MinHeap() {
        heap = new ArrayList<>();
    }
    
    public void swap(int i, int j) {
        long temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    public void add(long val) {
        heap.add(val);
        // percolate up. Same with max heapify
        int currIndex = heap.size() - 1;
        int parentIndex = (currIndex - 1) / 2;
        
        while(parentIndex >= 0 && heap.get(parentIndex) > heap.get(currIndex)) {
            swap(parentIndex, currIndex);
            currIndex = parentIndex;
            parentIndex = (currIndex - 1)/2;
        }
        
    }
    
    public boolean isEmpty() {
        if(heap.size() == 0) {
            return true;
        }
        return false;
    }
    
    public long poll() {
        if(!isEmpty()) {
            long min = heap.get(0);
            swap(heap.size() - 1, 0);
            heap.remove(heap.size() - 1);
            minHeapify(0);
            return min;
        } else {
            return -1 * 1L;
        }
    }
    
    public long peek() {
        if(!isEmpty()) {
            return heap.get(0);
        } else {
            return -1 * 1L;
        }
    }
    
    // swap heap[index] with its smallest child
    public void minHeapify(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int smallerChild = index;
        
        if(leftChild < heap.size() && heap.get(leftChild) < heap.get(smallerChild)) {
            smallerChild = leftChild;    
        }
        
        if(rightChild < heap.size() && heap.get(rightChild) < heap.get(smallerChild)) {
            smallerChild = rightChild;
        }
            
        if(smallerChild != index) {
            swap(smallerChild, index);
            minHeapify(smallerChild);
        }
    }
    
    
}
