package LeetCode;

/**
 * Created by sumitachauhan on 2/23/17.
 */
public class WordCount {

    public int wc(String input)
    {
        input = input.trim();
        String[] words = input.split("[^a-zA-Z0-9]+");
        return words.length;
    }

    public static void main(String[] args) {
        WordCount obj = new WordCount();
        String str = " My name is Sumita Chauhana. 1234 what is your name?/" +
                "And where do you live";
        System.out.println(obj.wc(str));
    }
}
