package CrackingCodingInterview;

/**
 * Created by sumitachauhan on 2/17/17.
 */
public class StackWithArray {
    private int stackSize;
    private int[] totalArray;
    private int[] stackPointer = {0,0,0};

    public StackWithArray(int size)
    {
        stackSize = size;
        totalArray = new int[stackSize*3];
    }

    void push(int stackNumber, int value)
    {
        int index = (stackNumber-1) * stackSize + stackPointer[stackNumber-1]+1;
        stackPointer[stackNumber-1]++;
        totalArray[index] = value;
    }

    int pop(int stackNum) {
        int index = (stackNum-1) * stackSize + stackPointer[stackNum-1];
        stackPointer[stackNum-1]--;
        int value = totalArray[index];
        totalArray[index] = 0;
        return value;
    }

    public static void main(String[] args) {
        StackWithArray obj = new StackWithArray(30);
        obj.push(1, 10);
        obj.push(1, 11);
        obj.push(1, 12);
        obj.push(1, 13);
        obj.push(2, 20);
        obj.push(3, 30);
        System.out.println(obj.pop(1));

    }
}
