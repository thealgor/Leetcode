class WordDictionary {

    //can also solve it by backtracking: https://leetcode.com/problems/add-and-search-word-data-structure-design/discuss/59554/My-simple-and-clean-Java-code

    public class TrieNode{
        Map<Character,TrieNode> children;
        boolean isLastChar;
        public TrieNode(Map<Character,TrieNode> children, boolean isLastChar){
            this.children=children;
            this.isLastChar = isLastChar;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(new HashMap(),false);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            curr = curr.children.computeIfAbsent(c,x->new TrieNode(new HashMap(), false));
        }
        curr.isLastChar=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Queue<TrieNode> queue = new LinkedList<>();
        TrieNode curr = root;
        queue.add(curr);
        for(char c: word.toCharArray()){
            int size = queue.size();
            boolean charPresent = false;
            for(int i = size-1; i>=0;i--){
                curr = queue.poll();
                if(c=='.'){
                    if(curr!=null){
                        queue.addAll(curr.children.values());
                    }
                }
                else{
                    if(curr.children.containsKey(c)){
                        queue.add(curr.children.get(c));
                    }

                }

            }
        }

        return queue.stream().anyMatch(n->n.isLastChar==true);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */