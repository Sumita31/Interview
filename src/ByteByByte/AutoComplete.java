package ByteByByte;

import java.util.*;

public class AutoComplete {
    private class Node{
        String prefix;
        Map<Character, Node> children;
        boolean isWord;
        public Node(String prefix){
            this.prefix=prefix;
            this.children=new HashMap<>();
        }
    }
    public Node trie;
    public AutoComplete(){
        this.trie=new Node("");
    }
    public void insertWord(String s){
        Node curr=trie;
        for(int i=0; i<s.length(); i++){
            if(!curr.children.containsKey(s.charAt(i))){
                curr.children.put(s.charAt(i), new Node(s.substring(0, i+1)));
            }
            curr=curr.children.get(s.charAt(i));
            if(i==s.length()-1){
                curr.isWord=true;
            }
        }
    }

    public List<String> getWordsForPrefix(String prefix){
        Node curr=trie;
        List<String> res=new LinkedList<>();
        for(char c:prefix.toCharArray()){
            if(curr.children.containsKey(c)){
                curr=curr.children.get(c);
            }else return res;
        }
        findAllWords(curr,res);
        return res;
    }
    private void findAllWords(Node n, List<String> result){
        if(n.isWord) result.add(n.prefix);
        for(char c: n.children.keySet()) {
            findAllWords(n.children.get(c), result);
        }
    }

    public static void main(String[] args) {
        AutoComplete obj = new AutoComplete();
        obj.insertWord("abc");
        obj.insertWord("abd");
        obj.insertWord("abg");
        obj.insertWord("b");
        obj.insertWord("bcd");
        obj.insertWord("bcg");
//        List<String> res = obj.getWordsForPrefix("ab");
//        for(String s:res){
//            System.out.println(s);
//        }
        List<String> res = obj.getWordsForPrefix("b");
        for(String s:res){
            System.out.println(s);
        }
    }
}
