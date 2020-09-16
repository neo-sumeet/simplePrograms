package trees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HeightKAryTree {
    static class TreeNode
    {
        Vector<TreeNode> children = new Vector<TreeNode>(0);
        TreeNode()
        {
            children.clear();
        }
    };


    private static class MaxHeight {
        int height;
    }

    static int find_height(TreeNode root)
    {
        if(root == null) return 0;
        int height = 0;
        Queue queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();


            while(size-- > 0){
                TreeNode node = (TreeNode) queue.remove();
                boolean childAdded = false;
                for(TreeNode childnode : node.children){
                    queue.add(childnode);
                    if(!childAdded) childAdded = true;
                }
                if(childAdded)
                    height++;

            }

        }
        return height;
    }


}
