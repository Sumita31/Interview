package Shoubhik;

public class TriangleArray {

    //Implementation with one dimensional array
    private final int n;
    private final int arr[];

    public TriangleArray(int n) {
        this.n = n; // nXn array
        this.arr = new int[n*(n+1)/2];
    }

    public int get(int x, int y) {
        if(x<y || x>n)
            throw new IllegalArgumentException("value of x can only be greater than or equal to y.");
        int loc = (x*(x+1)/2) +y;
        if(arr.length<loc)
            throw new IllegalArgumentException("no such element exist.");
        else return arr[loc];
    }

    public void set(int x, int y, int val){
        if(x<y || x>n)
            throw new IllegalArgumentException("value of x can only be greater than or equal to y.");

        int loc = (x*(x+1)/2) +y;
        arr[loc]=val;
    }
}
