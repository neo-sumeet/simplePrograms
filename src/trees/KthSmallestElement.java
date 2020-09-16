package trees;

public class KthSmallestElement {
    static class TreeNode
    {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int _val)
        {
            val = _val;
            left_ptr = null;
            right_ptr = null;
        }
    };

    private static class Counter {
        static int count;
    }

    static int kth_smallest_element(TreeNode root, int k) {
        Counter counter = new Counter();
        TreeNode treeNode = kth_smallest_element_helper(root, k, counter);
        return treeNode.val;
    }

    static TreeNode kth_smallest_element_helper(TreeNode root, int k, Counter counter) {
        if(root == null){
            return null;
        }
        TreeNode treeNode = kth_smallest_element_helper(root.left_ptr, k, counter);
        if(treeNode != null) return treeNode;
        counter.count++;
        System.out.println(root.val+ "---" +k+"---"+counter.count);

        if(counter.count == k){
            return root;
        }
        treeNode = kth_smallest_element_helper(root.right_ptr,k,counter);
        if(treeNode != null) return treeNode;
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode child1 = new TreeNode(4);
        TreeNode child2 = new TreeNode(6);
        root.left_ptr = child1;
        root.right_ptr = child2;

        System.out.println(kth_smallest_element(root,1));
    }
}
