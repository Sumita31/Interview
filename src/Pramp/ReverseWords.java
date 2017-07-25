package Pramp;

/**
 * Created by sumitachauhan on 7/23/17.
 */
public class ReverseWords {
    public String reverse(char[] arr){
        if(arr==null || arr.length<0) throw new IllegalArgumentException();
        int start=0, end=arr.length-1;
        while(end>=start){
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

        int counter=0, first=0;
        while(first<arr.length){
            if(arr[first]==' ' || first==arr.length-1){
                int wstart=counter; int wend=first-1;
                if(first==arr.length-1){
                    wend=first;
                }
                while(wend>=wstart){
                    char temp=arr[wstart];
                    arr[wstart]=arr[wend];
                    arr[wend]=temp;
                    wstart++;
                    wend--;
                }
                counter=first+1;
            }
            first++;
        }
        return String.copyValueOf(arr);
    }

    public static void main(String[] args) {
        char[] arr = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};

        ReverseWords obj = new ReverseWords();
        System.out.println(obj.reverse(arr));
    }
}
