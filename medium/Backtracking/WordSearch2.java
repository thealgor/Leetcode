
//backtracking the visited and stringbuilder are the most important steps in this problem.
class Solution {

    char[][] b;
    Trie t;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        t = new Trie();
        b=board;

        for(String word: words){
            t.insert(word);
        }

        Set<String> visited;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                visited = new HashSet<String>();
                StringBuilder sb = new StringBuilder();
                dfs(i,j,visited, sb, result);
            }
        }
        return result;

    }

    public void dfs(int u, int v, Set<String> visited, StringBuilder sb, List<String> result){
        char c = b[u][v];
        sb.append(c);

        visited.add(u+","+v);
        String str = new String(sb);

        if(!t.startsWith(str))
            return;

        if(t.search(str)){
            if(!result.contains(str))
                result.add(str);
        }

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        for(int i=0;i<dx.length;i++){
            int x = u+dx[i];
            int y = v+dy[i];
            if(x<0||y<0||x>b.length-1|| y>b[0].length-1||visited.contains(x+","+y))
                continue;

            dfs(x,y,visited,sb,result);

            //backtracking
            visited.remove(x+","+y);
            sb.setLength(sb.length()-1);

        }
    }


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
}