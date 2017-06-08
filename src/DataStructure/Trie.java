package DataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sumitachauhan on 5/24/17.
 */
public class Trie {

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.add("Sumita");
        obj.add("Sum");
        obj.delete("Sumita");

        System.out.println(obj.search("Sum"));
        System.out.println(obj.search("Sumita"));

        obj.add("Chauhan");
        System.out.println(obj.search("Sumita"));
        System.out.println(obj.search("Chauhan"));
    }
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void add(String word){
        char[] wordArr = word.toCharArray();

        if(wordArr.length<=0)
            return;

        TrieNode curr = root;

        for(int i=0; i<wordArr.length; i++){
            char ch = wordArr[i];
            TrieNode node = curr.children.get(ch);

            if(node==null){
                node=new TrieNode();
                curr.children.put(ch, node);
            }
            curr=node;
        }
        curr.isEndOfWord=true;
    }


    public boolean search(String word){
        char[] wordArr = word.toCharArray();
        if(wordArr.length==0)
            return false;
        TrieNode curr = root;
        for(int i=0; i<wordArr.length; i++){
            char ch = wordArr[i];
            TrieNode node = curr.children.get(ch);
            if(node == null)
                return false;
            curr=node;
        }
        return curr.isEndOfWord;
    }

    public void delete(String word){
        System.out.println(delete(root, word, 0));
    }

    private boolean delete(TrieNode curr, String word, int index){

        if(index == word.length()){
            if(curr.isEndOfWord)
            {
                curr.isEndOfWord = false;
                //shoould delete the node completely
                return curr.children.size()==0;
            }
            else return false;
        }
        char ch = word.charAt(index);
        TrieNode node = curr.children.get(ch);
        if (node==null){
            return false;
        }

        boolean shouldDelete = delete(node, word, index+1);
        if(shouldDelete && !curr.isEndOfWord){
            curr.children.remove(ch);
            return curr.children.size()==0;
        }
        return false;
    }



}
