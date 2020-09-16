package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsOfBinaryTree {
    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }

    static List<List<Integer>> allPathsOfABinaryTree(TreeNode root){
        List<List<Integer>> leaftPathList = new ArrayList<>();
        List<Integer> singlePath = new ArrayList<>();

        allPathsOfABinaryTreeHelper(root,leaftPathList,singlePath);
        return leaftPathList;
    }

    private static void allPathsOfABinaryTreeHelper(TreeNode node, List<List<Integer>> leaftPathList,List<Integer> singlePath) {
        if(node == null){
            return;
        }
        singlePath.add(node.val);

        if(node.left_ptr == null && node.right_ptr == null){
            // add the single list to mega list
            leaftPathList.add(new ArrayList<>(singlePath));

        }else{

            // include left child
            if(node.left_ptr != null){
                allPathsOfABinaryTreeHelper(node.left_ptr,leaftPathList,singlePath);
            }
            // exclude left - include right child
            // remove left element first from sibgle path
            if(node.right_ptr != null){
                allPathsOfABinaryTreeHelper(node.right_ptr,leaftPathList,singlePath);
            }
        }
        singlePath.remove(singlePath.size() - 1);

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

        System.out.println(Arrays.asList(allPathsOfABinaryTree(root)));

    }
}
