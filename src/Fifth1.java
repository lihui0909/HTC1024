// 第五题：BFS 时间复杂度O(log(x+y))
import java.util.*;

public class Fifth1 {
    static String[] dirs = {"N", "S", "E", "W"};

    public static void main(String[] args) {
        System.out.println(gridTravel(-2, 1));
    }

    //创建类记录点的信息，包括xy坐标、步数level、路径字符串
    static class Point {
        int x;
        int y;
        int level;
        StringBuffer sbr;

        public Point(int x, int y, int level, StringBuffer sbr) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.sbr = sbr;
        }
    }

    public static String gridTravel(int x, int y) {
        if ((x == 0 && y == 0) || (Math.abs(x) + Math.abs(y)) % 2 == 0) {
            return "";
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0, new StringBuffer("")));
        return process(x, y, queue);
    }

    private static String process(int x, int y, Queue<Point> queue) {
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.x == x && cur.y == y) {
                return cur.sbr.toString();
            }
            if ((cur.x != x && Math.abs(cur.x - x) < Math.pow(2,cur.level)) || (cur.y != y && Math.abs(cur.y - y) < Math.pow(2, cur.level))) {
                continue;
            }
            int[][] addStep = cur.level == 0 ? new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}} : new int[][]{{0, 2 * cur.level}, {0, -2 * cur.level}, {2 * cur.level, 0}, {-2 * cur.level, 0}};
            for (int j = 0; j < 4; j++) {
                if (cur.x * x < 0) {
                    if ((cur.x > 0 && j == 2) || (cur.x < 0 && j == 3)) {
                        continue;
                    }
                }
                if (cur.y * y < 0) {
                    if ((cur.y > 0 && j == 0) || (cur.y < 0 && j == 1)) {
                        continue;
                    }
                }
                queue.add(new Point(cur.x + addStep[j][0], cur.y + addStep[j][1],cur.level+1, new StringBuffer(cur.sbr).append(dirs[j])));
            }
        }
        return "";
    }
}
