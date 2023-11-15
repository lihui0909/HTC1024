//第五题：dfs+回溯 时间复杂度O(n!)
import java.util.ArrayList;
import java.util.List;

public class Fifth {
    static List<String> resArray = new ArrayList<>();
    static String[] dirs = {"N","S","E","W"};

    public static void main(String[] args) {
        System.out.println(gridTravel(-2,1));
    }

    public static String gridTravel(int x, int y) {
        if (x == 0 && y == 0) {
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
        if ((x * curX < 0) || (y * curY < 0)) {
            return;
        }
        if (Math.abs(curX) > Math.abs(x) || Math.abs(curY) > Math.abs(y)){
            return;
        }

        if (curX == x && curY == y) {
            resArray.add(path.toString());
            return;
        }
        int[][]  addStep = i == 0 ? new int[][]{{0,1},{0,-1},{1,0},{-1,0}} : new int[][]{{0,2*i},{0,-2*i},{2*i,0},{-2*i,0}};
        // 遍历四个方向的每一种情况+回溯
        for(int j = 0; j < 4;j++){
            String s = dirs[j];
            process(path.append(s), x, y, curX+addStep[j][0], curY + addStep[j][1], i + 1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
