package src;

//第二题：顺序扫描数组 时间复杂度O(n) 空间复杂度O(1)
public class Second1 {
    public static void main(String[] args) {
        int[] people = {0,1,2,2,2,1,2};
        System.out.println(numberOfWays(people));
    }
    public static int  numberOfWays(int[] people) {
        //cnt1代表扫描过程中遇到的有效‘01’组合个数
        int ans = 0, cnt1 = 0, cnt0 = 0;
        for(int tmp : people){
            if(tmp == 2){
                ans += cnt1;
            }else if(tmp == 1){
                cnt1+=cnt0;
            }else{
                cnt0++;
            }
        }
        return ans;
    }
}
