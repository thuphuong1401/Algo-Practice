    lowerBound: phan tu dau tien >= gia tri tim kiem
    upperBound: phan tu dau tien < gia tri tim kiem
    
    
    1 2 4 5 7 8    x=3
    
    BFfirst,
    BFlast, 
    upperBound, lowerBound
    
    
    binarySearch:
    
    //length = n;
    int low = 0, high = n-1;
    while(low < high) {
        int mid = low + (high - low)/2;
        if(arr[mid] == x) {
            return mid;
        } else if(arr[mid] < x) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    } 
    
    1 3 => x = 1
    
    arr[mid] = 3
    arr[mid] > x => high = mid - 1 = 1 - 1 = 0
    low = 0, high = 0
    
    
    /*
    Mang vi du: 1 2 2 2 4 5 6 6 7
    */
    
    BFfirst: search the first occurence of x
    int low = 0, high = n-1;
    while(low <= high) {
        int mid = low + (high - low)/2;
        /*
        Ghi nhớ: 2 điều kiện:
        - 1: mid = 0, tức là không còn số nào bên tay trái nữa (đây là phần tử đầu tiên của mảng, chắc chắn
        nó là 1st occurence)).
        - 2: arr[mid-1] != x, tức là số đằng trước x khác x, nghĩa là x là 1st occurence
        */
        if((mid == 0 || arr[mid - 1] != x) && arr[mid] == x) { 
            return mid;
        } else if(arr[mid] >= x) {
            high = mid - 1;
        } else {
            low = mid + 1; 
        }
    }
    
    
    BFLast: search for the last occurence of x
    int low = 0, high = n-1;
    while(low <= high) {
        int mid = low + (high - low)/2;
        if((mid == n-1 || arr[mid + 1] != x) && arr[mid] == x) { 
            return mid;
        } else if(arr[mid] <= x) {
            low = mid + 1;
        } else {
            high = mid - 1; 
        }
    }
    
    Luu y: so can tim co the k thuoc mang
    lowerBound: phan tu dau tien >= gia tri tim kiem
    upperBound: phan tu dau tien > gia tri tim kiem
    
    upperBound: phan tu dau tien < gia tri tim kiem
    
    int low = 0, high = n-1;
    while(low <= high) {
        int mid = low + (high - low)/2;
        
    }
    
    upperBound:
    vi du: arr = [7, 8], x = 4 => mid = 0
    int low = 0, high = n-1;
    while(low <= high) {
        int mid = low + (high - low)/2;
        if(arr[mid] > x && (mid == 0 || (arr[mid-1] <= x)) {
            return mid;
        } else if(arr[mid] <= x) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    
    
    lowerBound
    while(low <= high) {
        int mid = low + (high - low)/2;
        if(arr[mid] >= x && (mid == 0 || (arr[mid-1] < x)) {
            return mid;
        } else if(arr[mid] < x) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    
        
}


