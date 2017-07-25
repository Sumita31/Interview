package ByteByByte;

import java.util.HashSet;

/**
 * Created by sumitachauhan on 6/27/17.
 */
public class Consecutive {
    public int consecutive(int[] a) {
        // Put all the values into a HashSet
        HashSet<Integer> values = new HashSet();
        for (int i : a) {
            values.add(i);
        }

        // For each value, check if its the first in a sequence of consecutive
        // numbers and iterate through to find the length of the consecutive
        // sequence
        int maxLength = 0;
        for (int i : values) {
            // If it is not the leftmost value in the sequence, skip it
            if (values.contains(i - 1)) continue;
            int length = 0;

            // Iterate through sequence
            while (values.contains(i)) {
                length++;
                i++;
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Consecutive obj = new Consecutive();
        int[] input = {4, 2, 1, 6, 5};
        System.out.println(obj.consecutive(input));
    }
}
