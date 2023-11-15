package src;//第三题：时间复杂度 O(n)
import java.util.*;

public class Third {
    public static void main(String[] args) {
        int[] snacks = {5,5,4,5,3,2,3,1,3};
        System.out.println(Arrays.toString(calPossibility(snacks)));
        int[] ss = {5,5,5};
        System.out.println(Arrays.toString(calPossibility(ss)));
    }
    public static int[] calPossibility(int[] snacks){
        int n = snacks.length/3;
        int[] ans = new int[n+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        // 大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int snack : snacks){
            map.put(snack,map.getOrDefault(snack,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            queue.add(entry.getValue());
        }


        // 如果糕点中数量最多的糕点类型，个数不大于n，说明可以每行最多放一个，存在n行都不重复的方案
        if(queue.peek() <= n){
            ans[0] = 1;
        }
        // 如果糕点中数量最多的糕点类型，个数不大于3，说明不会有存在任何一排完全相同的糕点的方案，直接返回ans
        if(queue.peek() < 3) return ans;

        // 遍历填结果数组ans
        for(int i = 1; i <= n;i++){
            // 如果当前糕点中数量最多的糕点类型，个数大于3，说明可以用这个类型凑出一排相同的糕点
            if(queue.peek() >= 3){
                int maxNum = queue.poll();

                // 将该类型的糕点个数减去3之后再放入有序队列
                if(maxNum > 0) queue.add(maxNum-3);
                // 判断用上面的类型增加一排相同糕点后，剩下的糕点是否可以存在足够的种类全相异地填补其他行
                if(queue.peek() <= (n-i)){
                    ans[i]++;
                }
            } else {
                break;
            }
        }
        return ans;
    }
}
