package src;//第一题: 时间复杂度O(n) 空间复杂度O(n)
import java.util.*;
public class First {
    public static void main(String[] args) {
        int[] nums = {4,1,3,2};
        int[][] res = inverseNeighbor(nums);
        for (int[] arr : res){
            System.out.print(Arrays.toString(arr));
        }

    }
    public static int[][] inverseNeighbor(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[][]{};
        }
        List<int[]> resList = new ArrayList<>();
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < len;i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i < len;i++){
            if(map.containsKey(nums[i]-1) && map.get(nums[i]-1) > i){
                int[] resTemp = new int[]{nums[i],nums[i]-1};
                resList.add(resTemp);
            }
        }
        int[][] res = new int[resList.size()][2];
        Iterator<int[]> it = resList.iterator();
        int idx = 0;
        while(it.hasNext()){
            res[idx++] = it.next();
        }
        return res;
    }
}
