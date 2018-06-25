package Trees;

class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {



        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<Integer> stack = new Stack<Integer>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<Integer>();
        boolean reverseOrder = false;

        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node!=null)
                System.out.println(node.val);
            if(node==null && !queue.isEmpty() ){//next element is not null
                queue.add(null);
                if(!reverseOrder){
                    result.add(list);
                    reverseOrder=true;
                }
                else{
                    list = reverseStack(stack);
                    result.add(list);
                    reverseOrder=false;
                    list = new ArrayList<Integer>();
                }
                continue;
            }
            else{

                if(node==null)
                    continue;

                if(!reverseOrder){
                    list.add(node.val);
                }
                else{
                    stack.add(node.val);
                }
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }

        }

        if(!reverseOrder){
            result.add(list);
        }
        else{
            list = reverseStack(stack);
            result.add(list);
        }

        return result;
    }

    public List<Integer> reverseStack(Stack<Integer> stack){
        List<Integer> list = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
