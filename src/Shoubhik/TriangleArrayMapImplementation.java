package Shoubhik;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class TriangleArrayMapImplementation {

    private final Map<KeyForTriangleArray, Integer> map;
    private final int n;

    public TriangleArrayMapImplementation(int n){
        this.n = n;
        this.map = new HashMap<>();
    }

    public int get(int x, int y){
        if(x<y || x>n)
            throw new IllegalArgumentException("value of x can only be greater than or equal to y.");
        KeyForTriangleArray key = new KeyForTriangleArray(x,y);
        //returns null if no such element exist.
        return map.get(key);
    }

    public void set(int x, int y, int val){
        if(x<y || x>n)
            throw new IllegalArgumentException("value of x can only be greater than or equal to y.");
        KeyForTriangleArray key = new KeyForTriangleArray(x,y);
        map.put(key,val);
    }
}

class KeyForTriangleArray{
    private int x, y;
    public KeyForTriangleArray(int x, int y){
        if(x<y)
            throw new IllegalArgumentException("value of x can only be greater than or equal to y.");
        this.x=x;
        this.y=y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean equals(Object o) {
        if(o == null || !(o instanceof KeyForTriangleArray)) {
            return false;
        }
        KeyForTriangleArray that = ((KeyForTriangleArray) o);
        return this.x == that.x && this.y == that.y;
    }
}
