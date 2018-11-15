1. 建一个入度的数组
2. 建一个Map，维护这个图的入度，Map<Task, List<Task>> map这样。还是这种熟悉一些。

或者用DFS，需要Set和Stack来跳过访问过的Task，注意要递归。