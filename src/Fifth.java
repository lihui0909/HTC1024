//第五题：dfs+回溯 时间复杂度O(n!)
import java.util.ArrayList;
import java.util.List;

public class Fifth {
    static List<String> resArray = new ArrayList<>();
    static String[] dirs = {"N","S","E","W"};

    public static void main(String[] args) {
        System.out.println(gridTravel(7,10));
    }

    public static String gridTravel(int x, int y) {
        // 如果 终点 x 和 y的距离和为偶数，不可能走到
        if ((x == 0 && y == 0) || (Math.abs(x)+Math.abs(y))%2 == 0) {
            return "";
        }
        StringBuilder path = new StringBuilder();
        process(path, x, y, 0, 0, 0);

        int minPathNum = Integer.MAX_VALUE;
        String res = "";
        for(String s : resArray){
            if(s.length() < minPathNum){
                res = s;
            }
        }
        return res;
    }

    private static void process(StringBuilder path, int x, int y, int curX, int curY, int i) {
        if (curX == x && curY == y) {
            resArray.add(path.toString());
            return;
        }
        //终止条件：当x或y坐标与终点不相等，且距离小于下一步的步长，这种情况无法走到终点，直接返回。
        if((curX != x &&  Math.abs(curX - x) < 2*i) || ( curY != y && Math.abs(curY - y) < 2 * i)){
            return;
        }


        int[][]  addStep = i == 0 ? new int[][]{{0,1},{0,-1},{1,0},{-1,0}} : new int[][]{{0,2*i},{0,-2*i},{2*i,0},{-2*i,0}};
        // 遍历四个方向的每一种情况+回溯
        for(int j = 0; j < 4;j++){
            // 防止出现这种情况：x或y坐标，当前位置与终点异号，但仍朝反方向走。
            if(curX * x < 0){
                if((curX > 0 && j == 2) || (curX < 0 && j == 3)){
                    continue;
                }
            }
            if(curY * y < 0){
                if((curY > 0 && j == 0) || (curY < 0 && j == 1)){
                    continue;
                }
            }
            String s = dirs[j];
            process(path.append(s), x, y, curX+addStep[j][0], curY + addStep[j][1], i + 1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
