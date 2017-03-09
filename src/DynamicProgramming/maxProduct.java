package DynamicProgramming;

/**
 * Created by sumitachauhan on 3/4/17.
 */
public class maxProduct {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0];
        int result = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                max[i]=Math.max(nums[i], max[i-1]*nums[i]);
                min[i]=Math.min(nums[i], min[i-1]*nums[i]);
                System.out.println(nums[i] + ", "+max[i]+ ", " + min[i]);
            }else{
                max[i]=Math.max(nums[i], min[i-1]*nums[i]);
                min[i]=Math.min(nums[i], max[i-1]*nums[i]);
                System.out.println(nums[i] + ", "+max[i]+ ", " + min[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        maxProduct obj = new maxProduct();
        int[] a = {2, -4, -1};
        System.out.println(obj.maxProduct(a));
    }
}
