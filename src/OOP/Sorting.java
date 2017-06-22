package OOP;


public interface Sorting {
    public int[] doSort(int[] input, String property);
}

class BucketSort implements Sorting{
    private int[] listOfElements;
    public BucketSort(int[] elements){
        this.listOfElements=elements;
    }
    public int[] doSort(int[] input, String property){
        return listOfElements;
    }
}

class InsertionSort implements Sorting{
    private int[] listOfElements;
    public InsertionSort(int[] elements){
        this.listOfElements=elements;
    }
    public int[] doSort(int[] input, String property){
        return listOfElements;
    }
}

class SortingFactory{
}
