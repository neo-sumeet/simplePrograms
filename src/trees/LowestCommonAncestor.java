package trees;

public class LowestCommonAncestor {
    class Node {
        int data;
        Node left;
        Node right;
    }

    int lca(Node head, Node a, Node b)
    {
        Node node = lcaHelper(head, a, b);
        return node.data;
    }

    Node lcaHelper(Node node, Node a, Node b)
    {
        if(node == null){
            return null;
        }
        if(node.data == a.data || node.data == b.data){
            return node;
        }
        Node left = lcaHelper(node.left,a,b);
        Node right = lcaHelper(node.right,a,b);

       if(left != null && right != null){
           return node;
       }
       if(left != null){
           return left;
       }else{
           return right;
       }
    }


}
