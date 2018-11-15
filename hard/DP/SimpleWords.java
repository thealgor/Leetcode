public class SimpleWords {
    public static void main(String[] args){
        SimpleWords sw = new SimpleWords();
        String[] input = new String[]{"chat","ever","snapchat","snap","salesperson","per","person","sales","son","whatsoever","what","so"};
        sw.findSimpleWords(input);
    }
    public void findSimpleWords(String[] input) {
        HashSet<String> set = new HashSet<String>();
        for (String str : input) {
            set.add(str);
        }
        for (String str : input) {
            set.remove(str);
            if(isSimpleWord(str,set)) {
                System.out.println(str);
            }
            set.add(str);
        }
    }
    public boolean isSimpleWord(String word, HashSet<String> set) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(word.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return !dp[word.length()];
    }
}
