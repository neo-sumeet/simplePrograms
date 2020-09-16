package trees;

public class SingleValueTree {
    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }

    private static class Counter{
        int count;
    }
    /*
        Complete the function below
    */
    static int findSingleValueTrees(TreeNode root){
        Counter counter = new Counter();
        isUVT(root,counter);
        return counter.count;
    }

//    static void findUVT(TreeNode node,Counter counter){
//
//        findUVT(node.left_ptr,counter);
//        findUVT(node.right_ptr,counter);
//        boolean lUVT = isUVT(root.left_ptr);
//        if(!lUVT){
//            return
//        }
//        boolean rUVT = isUVT(root.right_ptr);
//
//        Integer count = new Integer(0);
//        return count;
//    }

    static boolean isUVT(TreeNode node, Counter counter){
        if(node == null){
            return true;
        }

        boolean lUvt = isUVT(node.left_ptr, counter);

        boolean rUvt = isUVT(node.right_ptr, counter);

        // if both childs are not uvt, return false
        if(lUvt  != rUvt){
            return false;
        }

        // if left child is uvt and value are not same as root,        // if left child is uvt and value are not same as root, return false return false
        if(node.left_ptr != null && node.left_ptr.val != node.val){
            return false;
        }

        // if right child is uvt and value are not same as root, return false
        if(node.right_ptr != null && node.right_ptr.val != node.val){
            return false;
        }

        // at this point, we have concluded both left child and right child are uvt and either they have same value or they would be null
        // in either case not qualifies as UVT. return true

        counter.count++;
        return true;


    }

    static boolean isLeaf(TreeNode node){
        return node == null ? false : (node.left_ptr == null && node.right_ptr == null);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;

        TreeNode child1 = new TreeNode();
        child1.val = 5;

//        TreeNode child2 = new TreeNode();
//        child2.val = 5;
//        root.left_ptr = child1;
        root.right_ptr = child1;

//        TreeNode child3 = new TreeNode();
//        child3.val = 5;
//
//        TreeNode child4 = new TreeNode();
//        child4.val = 5;
//
//        child1.left_ptr = child3;
//        child1.right_ptr = child4;

//        TreeNode child5= new TreeNode();
//        child5.val = 5;
//
//        TreeNode child6 = new TreeNode();
//        child6.val = 5;
//
//        child2.left_ptr = child5;
//        child2.right_ptr = child6;

        System.out.println(findSingleValueTrees(root));

//        TreeNode singleNode = new TreeNode();
//        singleNode.val = 5;
//        System.out.println(findSingleValueTrees(singleNode));
    }



}
