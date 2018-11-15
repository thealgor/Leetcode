上来建三个Set，White，Gray，Black三个，分别代表没动过的，正在访问的，和没有下一个的尽头的点的集合。

从White里面拿一个点，进DFS（点，三个Set）注意DFS需要返回一个boolean 方法。
DFS里面先移动set，然后找它的neighbor，看如果已经在set里面了，就continue。注意如果是Gray set要返回，因为已经有环了！
判断完所有的neighbor了之后，挪进黑的set里面。
可以在下面写一个Move Set的方法方便调用。