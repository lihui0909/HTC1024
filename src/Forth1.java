//第四题：前缀和+二分查找 时间复杂度O(n^2*logn)
public class Forth1 {
    public static void main(String[] args) {
        int[][] grid = {{2, 2}, {2, 2}};
        System.out.println(process(grid, 1));
        int[][] grid1 = {{1, 2, 3, 2}, {2, 4, 5, 3}, {6, 2, 3, 3}, {1, 4, 6, 1}};
        System.out.println(process(grid1, 15));
    }

    public static int process(int[][] grid, int price) {
        //创建二维前缀和数组preSum
        int n = grid.length;
        int[][] preSum = new int[n][n];
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] > price){
                    return 0;
                }
                preSum[i][j] = grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                preSum[i][j] += preSum[i][j - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i][j] += preSum[i-1][j];
            }
        }
        int res = n;
        // 二分查找前提是有序数组，所以需要将左顶点固定，在最内层循环中找恰好不大于price的边长，记为resTMP
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int maxSide = Math.min(n-i,n-j), minSide = 1;
                int midSide,resTmp = n;
                while(minSide <= maxSide){
                    midSide = (minSide + maxSide) / 2;
                    if(getTmpSum(preSum,i,j,midSide) > price){
                        maxSide = midSide-1;
                    } else if(getTmpSum(preSum,i,j,midSide) < price){
                        minSide = midSide+1;
                        resTmp = midSide;
                    } else {
                        resTmp = midSide;
                        break;
                    }
                }
                if(resTmp < res){
                    res = resTmp;
                }
            }
        }
        return res;

    }

    //getTmpSum 找到参数数组grid中以i，j为左上角元素，边长为tmpRes的正方形元素和
    private static int getTmpSum(int[][] preSum, int i, int j, int tmpRes) {
        if (i == 0 && j == 0) {
            return preSum[i + tmpRes - 1][j + tmpRes - 1];
        } else if (i == 0) {
            return preSum[i + tmpRes - 1][j + tmpRes - 1] - preSum[i + tmpRes - 1][j - 1];
        } else if (j == 0) {
            return preSum[i + tmpRes - 1][j + tmpRes - 1] - preSum[i - 1][j + tmpRes - 1];
        }
        return preSum[i + tmpRes - 1][j + tmpRes - 1] - preSum[i - 1][j + tmpRes - 1] - preSum[i + tmpRes - 1][j - 1] + preSum[i - 1][j - 1];
    }
}
