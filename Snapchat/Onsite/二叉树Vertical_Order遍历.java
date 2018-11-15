就是leetcode原题

public class Solution{
	public List<List<Integer>> verticalBT(TreeNode root){
		int minV = 0;
		int maxV = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// 这里写错了一下，把队列里面的类型写成treeNode了。
		Queue<Integer> levelQ = new LinkedList<Integer>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}
		queue.offer(root);
		levelQ.offer(0);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			int curLev = levelQ.poll();
			// 这里添加进map更好，可以节省0的地方和两个子树的地方分别加。
			if (!map.containsKey(curLev)) {
				map.put(curLev, new ArrayList<Integer>());
			}
			map.get(curLev).add(cur.left.val);
			// 分别判断两个child
			if (cur.left != null) {
				queue.offer(cur.left);
				levelQ.offer(curLev-1);
				minV = Math.min(minV, curLev-1);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
				levelQ.offer(curLev+1);
				maxV = Math.max(maxV, curLev+1);
			}
		}
		for (int i = minV; i <= maxV; i++) {
			result.add(map.get(i));
		}
		return result;
	}
}