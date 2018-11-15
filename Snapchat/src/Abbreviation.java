import java.util.HashMap;
import java.util.Map;

class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        int[] prefix = new int[dict.size()];
        String[] ans = new String[dict.size()];
        for (int i = 0; i < dict.size(); i++) {
            ans[i] = makeAbbre(dict.get(i), ++prefix[i]);
        }
        for (int i = 0; i < ans.length; i++) {
            while (true){
                HashSet<Integer> set = new HashSet();
                for (int j = i + 1; j < ans.length; j++) {
                    if (ans[i].equals(ans[j])) set.add(j);
                }
                if (set.isEmpty()) break;
                set.add(i);
                for (int s: set) {
                    ans[s] = makeAbbre(dict.get(s), ++prefix[s]);
                }
              }
        }
        return Arrays.asList(ans);
    }
    public String makeAbbre(String s, int k) {
        if (s.length() - k <= 2) return s;
        return s.substring(0, k) + (s.length() - k - 1) + s.charAt(s.length() - 1);
    }
}

／／下面这个是地里看到的

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    int numOfWords;
    
    public TrieNode() {
            this.children = new TrieNode[26];
    }
}

public class Solution {
	public static void main(String[] args) {
		String[] strs = {"aaaaa", "aabaa", "aaaca", "god", "geed"};
		Solution so = new Solution();
		String[] result = so.Encode(strs);
		for (String s : result) {
			System.out.println(s);
		}
	}
    public void insert(String s,TrieNode root) {
            
            TrieNode node = root;
            for (int i=0;i<s.length();i++) {
                    
                    char c = s.charAt(i);
                    if (node.children[c-'a'] == null) {
                            node.children[c-'a'] = new TrieNode();
                    }
                    
                    node = node.children[c-'a'];
                    node.numOfWords++;
            }
            
    }

    public String searchPrefix(String s, TrieNode root) {
            
            TrieNode node = root;
            String prefix = "";
            
            for (int i=0;i<s.length();i++) {
                    char c = s.charAt(i);
                    if (node.children[c-'a']!=null) {
                       node = node.children[c-'a'];
                    }
                    prefix+= c;
                    
                    if (node.numOfWords == 1) return prefix;
            }
            
            return prefix;
    }
    
    /* assume no duplicate in string array.*/
public String[] Encode(String[] strs) {
        
        Map<Integer,TrieNode> wordDict = new HashMap<Integer,TrieNode>();
        String[] encodeStrs = new String[strs.length];
        
        // Build trie.
        for (int i=0;i<strs.length;i++) {
                int len = strs[i].length();
                if (!wordDict.containsKey(len)) {
                        TrieNode root = new TrieNode();
                        wordDict.put(len, root);
                } 
                
                insert(strs[i],wordDict.get(len));
        }
        // compress each string.
        for (int i=0;i<strs.length;i++) {
                
                int len = strs[i].length();
                String prefix = searchPrefix(strs[i],wordDict.get(len));
                if (prefix.length()+2<len) encodeStrs[i] = prefix+""+len+strs[i].charAt(len-1);
                else encodeStrs[i] = strs[i];
        }
        
        return encodeStrs;
        
	}
}