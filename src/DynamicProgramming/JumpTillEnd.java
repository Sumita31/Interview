package DynamicProgramming;

/**
 Given an array of non-negative integers, you are initially positioned at the first index of the array.
 Each element in the array represents your maximum jump length at that position.
 Determine if you are able to reach the last index.
 For example:
 A = [2,3,1,1,4], return true.
 A = [3,2,1,0,4], return false.
 */
public class JumpTillEnd {

    public boolean canJump(int[] steps)
    {
        if(steps.length <= 1)
            return true;

        int maxStep = steps[0];


        for(int i=0; i<steps.length-1; i++)
        {
            if(steps[i] == 0 && maxStep < i)
                return false;

            if(i+steps[i] > maxStep)
                maxStep = i+steps[i];

            if(maxStep >= steps.length-1)
                return true;

        }

        return false;
    }

    public static void main(String[] args) {
        JumpTillEnd obj = new JumpTillEnd();
        int[] ar = {3,2,1,0,4};
        System.out.println(obj.canJump(ar));
    }
}
