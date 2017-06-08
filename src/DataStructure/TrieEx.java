package DataStructure;
import java.util.HashMap;
import java.util.Map;


public class TrieEx {

    public static void main(String[] args) {
        TrieEx obj = new TrieEx();
        obj.add("Sumita");
        obj.add("Sum");
        obj.delete("Sumita");

        System.out.println(obj.search("Sum"));
        System.out.println(obj.search("Sumita"));

        obj.add("Chauhan");
        System.out.println(obj.search("Sumita"));
        System.out.println(obj.search("Chauhan"));
    }

    private class TrieNode
    {
        private Map<Character, TrieNode> children;
        private boolean endOfWord;

        public TrieNode()
        {
            children = new HashMap<>();
            endOfWord = false;
        }

    }

    private TrieNode root;

    public TrieEx()
    {
        root = new TrieNode();
    }

    public void add(String word)
    {
        char[] charArr = word.toCharArray();
        if(charArr.length<=0)
            return;
        TrieNode curr = root;

        for(int i=0; i<charArr.length; i++)
        {
           char ch = charArr[i];
           TrieNode node = curr.children.get(ch);
           if(node==null)
           {
               node=new TrieNode();
               curr.children.put(ch, node);
           }
           curr=node;
        }
        curr.endOfWord=true;
    }

    public void delete(String word)
    {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode curr, String word, int index)
    {
        //method to determine if the node should be deleted or just set end of word as false
        if(index == word.length())
        {
            if(curr.endOfWord)
            {
                curr.endOfWord=false;
                return curr.children.size()==0;
            }
            else return false;
        }

        char ch = word.charAt(index);
        TrieNode node = curr.children.get(ch);
        if(node == null) {
            return false;
        }
        boolean shouldDelete = delete(node, word, index+1);

        if(shouldDelete && curr.endOfWord!=true)
        {
            curr.children.remove(ch);
            return curr.children.size()==0;
        }
        return false;
    }

    public boolean search(String word)
    {
        char[] charArr = word.toCharArray();
        if(charArr.length<=0)
            return false;
        TrieNode curr = root;
        for(int i =0; i<charArr.length; i++)
        {
            char ch = charArr[i];
            TrieNode node = curr.children.get(ch);
            if(node!=null)
            {
                curr=node;
            }
            else return false;
        }
        return curr.endOfWord;
    }

}
