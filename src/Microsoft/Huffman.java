package Microsoft;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Huffman {
    public static void main(String[] args) {
        String test = "missisipiriver";
        int[] charSet = new int[26];
        for(char c: test.toCharArray()){
            int idx = c - 'a';
            charSet[idx]++;
        }
        Huffman obj = new Huffman();
        HuffmanNode root=obj.buildTree(charSet);
        obj.printCode(root, new StringBuffer());
    }

    public HuffmanNode buildTree(int[] freq){
        HuffmanSorter comperator= new HuffmanSorter();
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(26, comperator);
        for (int i = 0; i < freq.length; i++) {
            if ((freq[i] > 0)) {
                pq.offer(new HuffmanNode(freq[i], (char)('a' + i)));
            }
        }
        assert pq.size()>0;

        while(pq.size()>1){
            HuffmanNode one=pq.poll();
            HuffmanNode two=pq.poll();
            HuffmanNode parent, left , right;
            if(comperator.compare(one, two) < 0) {
                left = one;
                right = two;
            }
            else {
                left = two;
                right = one;
            }
            parent = new HuffmanNode(left.frequency + right.frequency, left.charValue);
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }
        return pq.poll();
    }

    public void printCode(HuffmanNode root, StringBuffer prefix){
        assert root != null;
        // traverse left
        if(root.left==null && root.right==null){
            System.out.println(root.charValue + "\t" + root.frequency + "\t" + prefix);
        }
        else {
            prefix.append('0');
            printCode(root.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            printCode(root.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    private class HuffmanNode {
        Integer frequency;
        Character charValue;
        HuffmanNode left;
        HuffmanNode right;
        public HuffmanNode(int frequency, char c){
            this.charValue=c;
            this.frequency=frequency;
        }

        public String toString() {
            return charValue + ":" + frequency;
        }

    }

    static class HuffmanSorter implements Comparator<HuffmanNode> {

        public int compare(HuffmanNode o1, HuffmanNode o2) {
            int result = o1.frequency.compareTo(o2.frequency);
            if(result == 0 ) {
                result = o1.charValue.compareTo(o2.charValue);
            }
            return result;
        }
    }
}
