class Trie {


    public class TrieNode{
        Map<Character,TrieNode> map;
        boolean isLastNode;
        public TrieNode(Map<Character,TrieNode> map, boolean isLastNode){
            this.map = map;
            this.isLastNode = isLastNode;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(new HashMap<>(), false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = curr.map.get(ch);
            if(node == null){
                node = new TrieNode(new HashMap<>(), false);
                curr.map.put(ch, node);
            }
            curr = node;
        }
        curr.isLastNode = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!curr.map.containsKey(ch))
                return false;
            curr = curr.map.get(ch);
        }
        return curr.isLastNode;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!curr.map.containsKey(ch))
                return false;
            curr = curr.map.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */