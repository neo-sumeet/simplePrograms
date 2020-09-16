package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class MergerTwoBST {
    private static class Node {


        int key;

        Node left;

        Node right;

        Node(int k) {

            key = k;

            left = null;

            right = null;

        }
    }


    public static void inorderTraversal(Node node, List<Node> list){
        if(node == null){
            return;
        }
        inorderTraversal(node.left,list);
        list.add(node);
        inorderTraversal(node.right,list);
    }

    public static Node mergeTwoBSTs(Node root1, Node root2) {
        // Write your code here
        List<Node> listTree1 = new ArrayList<>();
        List<Node> listTree2 = new ArrayList<>();
        inorderTraversal(root1,listTree1);
        inorderTraversal(root2,listTree2);

        List<Node> mergedList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < listTree1.size() && j < listTree2.size()){
            if(listTree1.get(i).key <= listTree2.get(j).key){
                mergedList.add(listTree1.get(i));
                i++;
            }else{
                mergedList.add(listTree2.get(j));
                j++;
            }
        }

        if(i < listTree1.size()){
            mergedList.addAll(listTree1.subList(i,listTree1.size()));
        }
        if(j< listTree2.size()){
            mergedList.addAll(listTree2.subList(j,listTree2.size()));
        }

        return buildTree(mergedList,0,mergedList.size()-1);
    }

    private static Node buildTree(List<Node> mergedList, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        Node node = mergedList.get(mid);
        node.left = buildTree(mergedList,start,mid-1);
        node.right = buildTree(mergedList,mid+1,end);
        return node;
    }


    public static void main(String[] args) {
//            Node root = new Node();
//            root.key = 300;
//
//            Node child1 = new Node();
//            child1.data = 200;
//
//            Node child2 = new Node();
//            child2.data = 400;
//            root.left = child1;
//            root.right = child2;
//
//            Node child3 = new Node();
//            child3.data = 100;
////
//            Node child4 = new Node();
//            child4.data = 400;
////
//            child1.left = child3;
//            child1.right = child4;

//        Node child5= new Node();
//        child5.val = 5;
//
//        Node child6 = new Node();
//        child6.val = 5;
//
//        child2.left_ptr = child5;
//        child2.right_ptr = child6;


    }
}
