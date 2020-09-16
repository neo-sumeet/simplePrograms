package trees;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PostOrderWithoutRecursion {

    private static Stack<Integer> resultStack = new Stack<>();
    private static Stack<TreeNode> operationalStack = new Stack<>();

    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }

    static int[] postorderTraversal(TreeNode root){
        if(root == null) return new int[0];
        operationalStack.push(root);

        while(!operationalStack.isEmpty()){
            TreeNode node = operationalStack.pop();
            resultStack.push(node.val);
            if(node.left_ptr != null){
                operationalStack.push(node.left_ptr);
            }
            if(node.right_ptr != null){
                operationalStack.push(node.right_ptr);
            }
        }

        int[] intArray = new int[resultStack.size()];
        int i = 0;
        while (!resultStack.isEmpty()){
            intArray[i++] = resultStack.pop();
        }

        return intArray;
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

        System.out.println(Arrays.asList(postorderTraversal(root)));

    }
}
