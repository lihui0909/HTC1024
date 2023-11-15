package src;//第三题：全排列解法，未完待续
import java.util.Arrays;

public class Third1 {
    public static void main(String[] args) {
        int[] snacks = {5,5,4,5,3,2,3,1,3};
        System.out.println(Arrays.toString(calPossibility(snacks)));
        int[] ss = {5,5,5};
        System.out.println(Arrays.toString(calPossibility(ss)));
    }
    public static int[] calPossibility(int[] snacks){
        int n = snacks.length/3;
        int[] ans = new int[n+1];
        Arrays.sort(snacks);
//        do{
//            int allDiffCnt = 0, allSameCnt = 0;
//            for(int i = 0; i < n;i++){
//                if(snacks[i*3]==snacks[i*3+1] && snacks[i*3]==snacks[i*3+2]){
//                    allSameCnt++;
//                } else if(snacks[i*3]!=snacks[i*3+1] && snacks[i*3+1]!=snacks[i*3+2] && snacks[i*3+2] != snacks[i*3])
//                    allDiffCnt++;
//            }
//            if(allDiffCnt+allSameCnt == n){
//                ans[allSameCnt]=1;
//            }
//        }while()
        return ans;
    }
}
