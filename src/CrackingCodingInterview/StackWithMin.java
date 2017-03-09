package CrackingCodingInterview;

/**
 * Created by sumitachauhan on 2/17/17.
 */
public class StackWithMin {

    NodeWithMin stack;
    StackWithMin(int value, int min)
    {
        stack = new NodeWithMin(value,min);
    }

    public void push(int value)
    {
        int newMin = Math.min(value, min());
        push(new NodeWithMin(value, newMin));
    }

    public int min()
    {
//        if (this.isEmpty())
//        {
//            return Integer.MAX_VALUE;
//        }
//        else
//        {
//            return peek().min;
//        }
        return 0;
    }

    public void push(NodeWithMin node)
    {

    }



}
