package src;

//第四题：前缀和+暴力 时间复杂度O(n^3)
public class Forth {
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
        // 暴力得结果
        for (int sideLen = 2; sideLen <= n; sideLen++) {
            for (int i = 0; i < n - sideLen; i++) {
                for (int j = 0; j < n - sideLen; j++) {
                    if (getTmpSum(preSum, i, j, sideLen) > price) {
                        return sideLen - 1;
                    }
                }
            }
        }
        return n;

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
