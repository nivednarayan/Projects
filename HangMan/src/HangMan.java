import java.util.*;
public class HangMan {
    String[] words = {
            "apple", "banana", "car", "dog", "elephant", "fish", "grape", "house", "ice", "jump",
            "kite", "lemon", "monkey", "night", "orange", "pencil", "queen", "river", "sun", "tree",
            "umbrella", "violin", "window", "yellow", "zebra", "ball", "chair", "door", "egg", "flower",
            "beacon", "cascade", "drought", "endeavor", "fortress", "glimpse", "harvest", "ingenious",
            "jubilant", "landmark", "mystic", "notion", "oracle", "ponder", "quaint", "reckon",
            "sovereign", "tangible", "venture", "wistful", "book", "clock", "desk", "fan", "glass", "hat", "iron", "jar", "key", "lamp",
            "map", "notebook", "oven", "plate", "quilt", "radio", "shoe", "table", "vase", "wallet",
            "ant", "bear", "cat", "duck", "eagle", "fox", "goat", "horse", "iguana", "jaguar",
            "koala", "lion", "mouse", "newt", "owl", "penguin", "rabbit", "snake", "tiger", "wolf",
            "avocado", "bread", "cake", "donut", "egg", "fries", "garlic", "honey", "ice cream", "jam",
            "kiwi", "lasagna", "mango", "noodle", "oatmeal", "pizza", "quiche", "rice", "salad", "taco",
            "airport", "beach", "cafe", "desert", "embassy", "forest", "garden", "hospital", "island", "jungle",
            "kingdom", "library", "museum", "nation", "ocean", "park", "quarry", "resort", "stadium", "temple",
            "antenna", "battery", "computer", "drone", "email", "firewall", "gadget", "hardware", "internet", "joystick",
            "keyboard", "laptop", "modem", "network", "output", "printer", "query", "router", "software", "tablet",
            "aurora", "brook", "canyon", "desert", "earth", "flower", "glacier", "hill", "island", "jungle",
            "kelp", "lake", "mountain", "nest", "oasis", "pond", "quake", "reef", "stream", "tundra",
            "algorithm", "boulevard", "chronicle", "democracy", "elephant", "fantastic", "generation", "hemisphere", "incredible", "juxtapose",
            "knowledge", "legendary", "mysterious", "necessary", "obligation", "philosophy", "quintessence", "revelation", "symphony", "tremendous",
            "university", "vulnerable", "wonderful", "xenophobia", "yesterday", "zoologist", "accomplishment", "benevolent", "collaboration", "determination"
    };

    String[] hangman = {
            """
          +---+
          |   |
              |
              |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
              |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
          |   |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|   |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|\\  |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|\\  |
         / \\  |
              |
        =========
        """
    };


    int random = (int) (Math.random() * words.length); // random number
    int n = words[random].length(); // length of the word
    char[] guess = new char[n]; // array to store the guess
    String s = words[random]; // word

    Map<Character, Integer> count = new HashMap<>(); // Map to store the count of each character
    public void count(){
        for (char ch : s.toCharArray()){
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
    }

    List<Character> guessed = new ArrayList<>(); // list of already guessed characters

    public void initialize(){
        Arrays.fill(guess, '_');
    }

    public void guessEntireWord(String word){
        for (char c : word.toCharArray()){
            if (!guessed.contains(c)){
                guessed.add(c);
                if (count.containsKey(c)){
                    for (int i = 0; i < n; i++){
                        if (s.charAt(i) == c)
                            guess[i] = c;
                    }
                }
            }
        }
    }

    public void guessCharacter(char c){
        guessed.add(c);
        if (count.containsKey(c)){
            for (int i = 0; i < n; i++){
                if (s.charAt(i) == c){
                    guess[i] = c;
                }
            }
        }
        print();
    }

    public boolean check(){
        return s.equals(new String(guess));
    }
    public boolean isGuessed(char c){
        return guessed.contains(c);
    }
    public boolean isValid(char c){
        return count.containsKey(c);
    }
    public void print(){
        for(char c : guess){
            System.out.print(c);
        }
        System.out.println();
    }

    public void printHangMan(int wg){
        System.out.println(hangman[wg]);
    }
}
