先写接口！
要求要有put和get功能，另外还要有size。
while循环要及时break掉。
一般TreeNode会先给出。

class MyMap{
	TreeNode root;
	int count;
	public MyMap(){
		root = null;
		count = 0;
	}
	public void put(int key, int value){
		count++;
		if (root == null) {
			root = new TreeNode(key, value);
			return;
		}
		TreeNode cur = root;
		while (cur != null) {
			if (cur.key < key) {
				if (cur.right != null) {
					cur = cur.right;
				}
				else {
					cur.right = new TreeNode(key, value);
					break; //注意在这里break掉，否则死循环，因为cur指针没有动。
				}
			}
			else if (cur.key > key) {
				if (cur.left != null) {
					cur = cur.left;
				}
				else {
					cur.left = new TreeNode(key, value);
					break;
				}
			}
			else{
				cur.value = value;
				count--;
				return;
			}
		}

	}

	public int get(int key){
		if (root == null) {
			return -1;
		}
		TreeNode cur = root;
		while (cur != null) {
			if (cur.key < key) {
				if (cur.right != null) {
					cur = cur.right;
				}
				else {
					return -1;
				}
			}
			else if (cur.key > key) {
				if (cur.left != null) {
					cur = cur.left;
				}
				else {
					return -1;
				}
			}
			else {
				return cur.value;
			}
		}
		return -1;
	}

	public int size(){
		return count;
	}
}
