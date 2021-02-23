/*
https://codeforces.com/problemset/problem/448/C
Editorial is available for this problem
*/
/*
Cach lam:
- Đầu tiên ta sẽ đọc chiều cao của các tấm ván vào một mảng tên là a.
- Với bài này, chúng ta sẽ giải quyết bằng cách chia để trị (Divide and Conquer): Ta sẽ xem hàng rào như một phân đoạn các tấm ván [0,n−1]. Sau đó, ta sẽ sơn lần lượt 
các đường theo chiều ngang từ dưới lên nhiều nhất có thể cho đến khi một đường sơn của chúng ta sẽ không thể sơn qua mọi tấm ván trong đoạn này nữa. Lúc này, chúng ta 
sẽ có các phần tấm ván chưa được sơn nằm tách biệt nhau. Ta sử dụng đệ quy để tính số lần sơn tối thiểu đối với các phần này và trả về tổng của chúng.
Hàm tính số đường cọ tối thiểu strokesNeeded(left, right, paintedHeight) (left và right đại diện cho vị trí bắt đầu và kết thúc của phân đoạn đang xét, paintedHeight 
là chiều cao của phần ván trước đó đã được sơn):
  + Nếu left > right: trả về 0
  + Khởi tạo biến mini (dùng để lưu lại vị trí của miếng ván có độ cao nhỏ nhất) bằng left. Sau đó duyệt các phần tử từ left đến right để tìm vị trí phần tử nhỏ nhất.
Lúc này, số các đường sơn ngang tối đa mà ta có thể thực hiện là a[mini]- paintedHeight.
  + Tiếp theo, chúng ta tính kết quả nếu tiếp tục thực hiện đệ quy đối với các phân đoạn không liên kết với nhau (các phân đoạn sẽ không liên kết với nhau tại vị trí mini):
recursive = a[mini] - paintedHeight + strokesNeeded(left, mini-1, a[mini]) +strokesNeeded(mini + 1, right, a[mini])
Lưu ý là nếu một trong 2 đoạn [left, mini-1] hoặc [mini+1, right] rỗng thì ở lần đệ quy tiếp theo left > right và lần đệ quy đối với phân đoạn ấy sẽ trả về 0. Tức là:
Nếu [left, mini – 1] rỗng thì recursive = a[mini] - paintedHeight + 0 + strokesNeeded(mini + 1, right, a[mini])
Nếu [mini+1, right] rỗng thì recursive = a[mini] - paintedHeight + strokesNeeded(left, mini+1, a[mini]) + 0
Ngoài ra, ta còn phải kiểm tra xem rằng nếu ta sơn phân đoạn này hoàn toàn theo chiều dọc thì kết quả nhận được có nhỏ hơn là sơn ngang: allVertical = right - left + 1
Kết quả trả về sẽ là số nhỏ hơn trong hai cách sơn: return min(allVertical, recursive).

Hàm main:
Đọc n
Đọc n số trong hàng tiếp theo vào mảng a
In ra strokesNeeded(0, n-1, 0)
Độ phức tạp: O(n^2) với n là số lượng phần tử mảng a.
*/
import java.util.*;
import java.io.*;

class MyCode {
    private static int n;
    private static int fence[];
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        fence = new int[n];
        for(int i = 0; i < n; i++) {
            fence[i] = scan.nextInt();
        }
        int ans = strokesNeeded(0, n-1, 0);
        System.out.println(ans);
	}
    
    
    private static int strokesNeeded(int left, int right, int horizontalPaintedHeight) {
        if(left > right) {
            return 0;
        }
        
        int minHeight = left;
        for(int i = left; i <= right; i++) {
            if(fence[i] < fence[minHeight]) {
                minHeight = i;
            }
        }
        
        // if we tried all vertical strokes
        int allVertical = right - left + 1;
        
        // maximum number of horizontal strokes first then recursion
        int numStrokes = fence[minHeight] - horizontalPaintedHeight + strokesNeeded(left, minHeight - 1, fence[minHeight]) + strokesNeeded(minHeight+1, right, fence[minHeight]);
        
        return Math.min(allVertical, numStrokes);
    }
    
    
}


