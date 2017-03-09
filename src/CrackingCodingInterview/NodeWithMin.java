package CrackingCodingInterview;

/**
 * Created by sumitachauhan on 2/17/17.
 */
public class NodeWithMin {
    private int value;
    private int min;
    private NodeWithMin node = null;


    public NodeWithMin(int v, int min)
    {
        this.value = v;
        this.min = min;
    }
}
