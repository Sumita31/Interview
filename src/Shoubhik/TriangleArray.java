package Shoubhik;

public class TriangleArray {

    //Implementation with one dimensional array
    private final int n;
    private final int arr[];

    public TriangleArray(int n) {
        this.n = n; // nXn array
        this.arr = new int[n*(n+1)/2];
    }

    //Lower triangle get method
    public int get(int x, int y) {
        if(x<y || x>n)
            throw new IllegalArgumentException("value of x can only be greater than or equal to y.");
        int loc = (x*(x+1)/2) +y;
        if(arr.length<loc)
            throw new IllegalArgumentException("no such element exist.");
        else return arr[loc];
    }

    //Lower triangle set method
    public void set(int x, int y, int val){
        if(x<y || x>n)
            throw new IllegalArgumentException("value of x can only be greater than or equal to y.");

        int loc = (x*(x+1)/2) +y;
        arr[loc]=val;
    }

    //Upper triangle get method
    public int getUpper(int r, int c) {
        if(c<r || c>n)
            throw new IllegalArgumentException("value of c can only be greater than or equal to r.");
        int loc = (c*(c+1)/2) +r;
        if(arr.length<loc)
            throw new IllegalArgumentException("no such element exist.");
        else return arr[loc];
    }

    //Upper triangle set method
    public void setUpper(int r, int c, int val){
        if(c<r || c>n)
            throw new IllegalArgumentException("value of c can only be greater than or equal to r.");

        int loc = (c*(c+1)/2) +r;
        arr[loc]=val;
    }
}
