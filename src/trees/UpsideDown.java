package trees;

import java.util.ArrayList;
import java.util.List;

public class UpsideDown {
    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }


    /*
        Complete the function below
    */
    static TreeNode flipUpsideDown(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left_ptr == null || root.right_ptr == null){
            return root;
        }
        TreeNode newRoot = flipUpsideDown(root.left_ptr);
        root.left_ptr.left_ptr = root.right_ptr;
        root.left_ptr.right_ptr = root;
        root.left_ptr = null;
        root.right_ptr = null;
        return  newRoot;

    }

    static void upsideDownPostOrder(TreeNode node, List<TreeNode> postOderList){
        if(node == null){
            return;
        }
        upsideDownPostOrder(node.left_ptr,postOderList);
        upsideDownPostOrder(node.right_ptr,postOderList);
        postOderList.add(node);
    }

}
