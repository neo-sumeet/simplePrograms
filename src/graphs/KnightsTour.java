package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KnightsTour {


    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        // Write your code here.
        int[] visited = new int[rows*cols];
//        Arrays.fill(visited,-1);
        int nodeToFind = end_row*cols + end_col;

        // Part 2
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start_row * cols+ start_col);
        visited[start_row * cols+ start_col] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node == nodeToFind){
                return visited[node];
            }
            for(Integer neighbor : getNeighbors(node,rows,cols)){

                if(visited[neighbor] == 0){
                    queue.add(neighbor);
                    visited[neighbor] = visited[node] + 1;
                }

            }
        }
        return -1;
    }


    static List<Integer> getNeighbors(int node,int rows, int cols){
//        System.out.println("Finidng neigboors of "+node);
        int rowNum = node / cols;
        int colNum = node % cols;
        List<Integer> neighbor = new ArrayList<>();
        // 8 possible neighbors
        // go up
        if(rowNum - 2 >= 0){
            if(colNum - 1 >= 0){
                neighbor.add((rowNum - 2) * cols + colNum - 1);
            }
            if(colNum + 1 < cols){
                neighbor.add((rowNum - 2) * cols + colNum + 1);
            }
        }
        // go down
        if(rowNum + 2 < rows){
            if(colNum - 1 >= 0){
                neighbor.add((rowNum + 2) * cols + colNum - 1);
            }
            if(colNum + 1 < cols){
                neighbor.add((rowNum + 2) * cols + colNum + 1);
            }
        }

        // go left
        if(colNum - 2 >= 0){
            if(rowNum - 1 >= 0){
                neighbor.add((rowNum - 1) * cols + colNum - 2);
            }
            if(rowNum + 1 < rows){
                neighbor.add((rowNum + 1) * cols + colNum - 2);
            }
        }

        // go right
        if(colNum + 2 < cols){
            if(rowNum - 1 >= 0){
                neighbor.add((rowNum - 1) * cols + colNum + 2);
            }
            if(rowNum + 1 < rows){
                neighbor.add((rowNum + 1) * cols + colNum + 2);
            }
        }

        return neighbor;

    }

    public static void main(String[] args) {
        System.out.println("Found "+find_minimum_number_of_moves(5,5,0,0,4,1));
    }
}
