//第二题：逆序扫描数组 时间复杂度O(n) 空间复杂度O(1)
public class Second {
    public static void main(String[] args) {
        int[] people = {0,1,2,2,2,1,2};
        System.out.println(numberOfWays(people));
    }
    public static int  numberOfWays(int[] people) {
        //cnt1代表扫描过程中遇到的有效‘12’组合个数
        int ans = 0, cnt1 = 0, cnt2 = 0;
        for(int i = people.length-1;i >= 0 ;i--){
            if(people[i] == 0){
                ans += cnt1;
            }else if(people[i] == 1){
                cnt1+=cnt2;
            }else{
                cnt2++;
            }
        }
        return ans;
    }
}
