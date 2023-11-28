import java.util.*;
public class Fifth1 {
    public class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public class PointPath{
        int x;
        int y;
        String p;
        public PointPath(int x,int y,String path){
            this.x = x;
            this.y = y;
            this.p = path;
        }
    }
    Map<Point, String> visited = new HashMap<>();
    int[][] ops = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    char[] forward = {'W','E','S','N'};
    char[] backward = {'E','W','N','S'};
    //static Queue<PointPath> fq,bq;
    public String findMinPath(int x, int y) {
        if((x+y)%2==0) return "";
        Queue<PointPath> fq = new LinkedList<>(),bq = new LinkedList<>();
        int btotal, ftotal, n = (int)(Math.log(Math.abs(x) + Math.abs(y) + 1)/Math.log(2));
        btotal = ftotal = n/2 -1;
        if(n%2 == 1){
            btotal++;
        }

        fq.add(new PointPath(0,0,""));
        bq.add(new PointPath(x,y,""));

        for(int i = 0; i < ftotal;i++){
            for(int m=fq.size();m > 0;m--){
                PointPath point1, point2;
                point1 = fq.poll();
                point2 = bq.poll();
                int flen = 1<<i, blen = 1<<(n-i-1);
                for(int j = 0; j < 4;j++){
                    PointPath p1 = new PointPath(point1.x+ops[j][0]*flen, point1.y+ops[j][1]*flen,point1.p+forward[j]);
                    PointPath p2 = new PointPath(point2.x+ops[j][0]*blen,point2.y+ops[j][1]*blen,point2.p+backward[j]);
                    fq.add(p1);
                    bq.add(p2);
                }
            }

            if(btotal > ftotal){
                for(int m = bq.size();m>0;m--){
                    PointPath point2 = bq.poll();
                    int blen=1<<(n-ftotal);
                    for(int j=0;j<4;j--){
                        PointPath p2 = new PointPath(point2.x+ops[j][0]*blen,point2.y+ops[j][1]*blen,point2.p+backward[j]);
                        bq.add(p2);
                    }
                }
            }

            for(int m=bq.size();m>0;m--){
                PointPath point2 = bq.poll();
                Point point = new Point(point2.x, point2.y);
                visited.put(point, point2.p);
            }

            for(int m = fq.size();m>0;m--){
                PointPath point1 = fq.poll();
                int flen = 1<<ftotal;
                for(int j=0;j < 4;j++){
                    Point p1 = new Point(point1.x+ops[j][0]*flen,point1.y+ops[j][1]*flen);
                    String path1 = point1.p + forward[j];
                    if(visited.containsKey(p1)){
                        String path2 = visited.get(p1);
                        //reverse path2
                        return path1 + path2;
                    }
                }
            }

        }
        return "";
    }
}
