package trees;

public class IsBST {
    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }

    static boolean isBST(TreeNode root){

        return isBSTHelper(root,null,null);
    }

    private static boolean isBSTHelper(TreeNode node, TreeNode lower, TreeNode higher) {
        if(node == null){
            return true;
        }

        boolean leftBST = isBSTHelper(node.left_ptr, node, higher);
        boolean rightBST = isBSTHelper(node.right_ptr, lower, node);

        if(lower != null && node.val > lower.val){
            return false;
        }

        if(higher != null && node.val < higher.val){
            return false;
        }

        return leftBST && rightBST;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 300;

        TreeNode child1 = new TreeNode();
        child1.val = 200;

        TreeNode child2 = new TreeNode();
        child2.val = 400;
        root.left_ptr = child1;
        root.right_ptr = child2;

        TreeNode child3 = new TreeNode();
        child3.val = 100;
//
        TreeNode child4 = new TreeNode();
        child4.val = 400;
//
        child1.left_ptr = child3;
        child1.right_ptr = child4;

//        TreeNode child5= new TreeNode();
//        child5.val = 5;
//
//        TreeNode child6 = new TreeNode();
//        child6.val = 5;
//
//        child2.left_ptr = child5;
//        child2.right_ptr = child6;

        System.out.println(isBST(root));

    }
}
