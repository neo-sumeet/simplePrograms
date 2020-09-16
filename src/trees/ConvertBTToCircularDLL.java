package trees;

public class ConvertBTToCircularDLL {

    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }


    private static class HeadTail {
        TreeNode first;
        TreeNode last;
    }
    /*
        Complete the function below
    */
    static TreeNode BTtoLL(TreeNode root){
        HeadTail headTail = new HeadTail();
        toLL(root, headTail);
        if(root != null) {
            headTail.first.left_ptr = headTail.last;
            headTail.last.right_ptr = headTail.first;
        }
        return headTail.first;
    }

    private static void toLL(TreeNode node, HeadTail headTail) {
        if(node == null){
            return;
        }
        toLL(node.left_ptr,headTail);
        if(headTail.first == null){
            headTail.first = node;

        }
        TreeNode prev = headTail.last;

        if(prev != null){
            prev.right_ptr = node;
            node.left_ptr = prev;
        }
        headTail.last = node;

        toLL(node.right_ptr,headTail);
    }

    public static void main(String[] args) {
        BTtoLL(null);
    }
}
