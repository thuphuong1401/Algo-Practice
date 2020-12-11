    /*
    Original list: A -> B -> C -> D
    Reversed: null <- A <- B <- C <- D
    
    */
    
    public static Node reverse(Node root) {
        Node prev = null;
        Node temp = root;
        while(temp.next != null) {
            Node nextTemp = temp.next; // A chi sang B 
            temp.next = prev; // A chi sang null
            prev = temp; // tu null sang A
            temp = nextTemp; // tu A sang B
            
            // tum lai: keep track prev va temp. 
        }
    }
