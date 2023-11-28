///*
// 第五题 第二种解法：记忆化搜索
// 第一种解法没办法记录中间值，是因为总步数不确定，
// 所以这种解法先计算出了总步数，以便于构造中间值数组
// */
//import java.util.*;
//public class Fifth1 {
//    public static void main(String[] args) {
//        System.out.println(gridTravel(-2,1));
//    }
//    char[] pops = new char[]{'E','W','S','N'};
//    List<String> path = new ArrayList<>();
//    public static String gridTravel(int x, int y) {
//        // 如果x+y的值为偶数，没有合适的走法。因为1,2,4...2^n这个步长是等比数列，和一定为奇数
//        if((x+y)%2 == 0){
//            return "";
//        }
//        // 计算步数n，计算公式为 n = log2(|x|+|y|+1)
//        double n = Math.log(Math.abs(x) + Math.abs(y) + 1)/Math.log(2);
//        dfs()
//
//    }
//
//    /**
//     * dfs 递归方法
//     * @param i 本次是第几步
//     * @param x 终点x坐标
//     * @param y 终点y坐标
//     * @param curX 当前点x坐标
//     * @param curY 当前点y坐标
//     */
//    public static boolean dfs(int i, int x, int y, int curX, int curY, int n){
//        if(i == n){
//            return (curX == x && curY == y)? true : false;
//        }
//
//
//    }
//}
