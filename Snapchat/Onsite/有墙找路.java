coding题目是一个矩阵里某些位置有墙，给一个出发点及目的地，求最短距离。
如果只需能否通过，那就DFS。要计算距离，那就BFS。 
follwup是现在墙可以打破，没打破一个cost为1，求cost最小的路线。
需要把每个node再加个成员变量cost，在终点取最小的cost，注意中途遇到访问过而且cost小的才不加。一定要画画图。


1.用DFS，判断能否通过
class Solution {
	public boolean hasPath(int[][] maze){
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		return findPath(maze, visited, 0, 0);
	}
	//注意这里模板，要有位置参数和一个判重的矩阵。
	public boolean findPath(int[][] maze, boolean[][] visited, int startX, int startY){
		if (maze[startX][startY] == 9) {
			return true;
		}
		if (maze[startX][startY] == 5) {
			return false;
		}
		int[] dx = {0,1,-1,0};
		int[] dy = {1,0,0,-1};
		visited[startX][startY] = true;
		for (int i = 0; i < 4; i++) {
			int xcur = startX + dx[i];
			int ycur = startY + dy[i];
			if (xcur < 0 || x >= maze.length || ycur < 0 || y >= maze[0].length) {
				continue;
			}
			if (!visited[xcur][ycur]) {
				if (findPath(maze, visited, xcur, ycur)) {
					return true;
				}				
			}
		}
		visited[startX][startY] = false;
		return false;
	}
}

2.用BFS拿到最短距离
注意要弄个set来保护BFS，注意step是一次扫一轮，而不是1个。

class Solution{
	int[] dx = {1,0,0,-1};
	int[] dy = {0,1,-1,0};
    public int shortestPath(int[][] maze){
        int row = maze.length;
        int col = maze[0].length;
        //别忘了这个
        boolean[][] visited = new boolean[row][col];
        int step = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(0,0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int idx = 0; idx < size; idx++){
                Node cur = queue.poll();
                visited[cur.rowNum][cur.colNum] = true;
                if (maze[cur.rowNum][cur.colNum] == 9) {
                    return step;
                }
                for (int i = 0; i < 4; i++) {
                    int rowNext = cur.rowNum + dx[i];
                    int colNext = cur.colNum + dy[i];
                    if (rowNext < 0 || colNext < 0 || rowNext >= maze.length || colNext >= maze[0].length) {
                        continue;
                    }
                    if (visited[rowNext][colNext] || maze[rowNext][colNext] == 5) {
                        continue;
                    }

                    queue.offer(new Node(rowNext, colNext));
                }
            }
            step += 1;
        }
        return -1;
    }
}
class Node{
	int rowNum;
	int colNum;
	public Node(int rowNum, int colNum){
		this.rowNum = rowNum;
		this.colNum = colNum;
	}
}