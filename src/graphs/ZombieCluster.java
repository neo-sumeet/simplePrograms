package graphs;

import java.util.ArrayList;
import java.util.List;

public class ZombieCluster {

    public static int zombieCluster(List<String> zombies) {
        // Write your code here
        int[] zombieVisited = new int[zombies.size()];
        int component = 0;
        for(int i = 0;i<zombieVisited.length;i++){
            if(zombieVisited[i] == 0){
                component++;
                dfs(zombieVisited,i,i,component,zombies);
            }
        }
        return component;
    }

    static void dfs(int[] zombieVisited, int rootNode, int nodeIndex, int component,List<String> zombies){
        if(zombieVisited[nodeIndex] == 0) {
            if(zombies.get(rootNode).charAt(nodeIndex) == '1') {
                zombieVisited[nodeIndex] = component;
            }
        }
        for(int i = nodeIndex+1;i<zombies.size();i++){
            if(zombieVisited[i] == 0){
                dfs(zombieVisited,nodeIndex,i,component,zombies);
            }
        }
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1100");
        stringList.add(    "1110");
                stringList.add("0110");
                        stringList.add("0001");
        System.out.println(zombieCluster(stringList));
    }
}
