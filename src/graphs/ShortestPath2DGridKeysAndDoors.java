package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class ShortestPath2DGridKeysAndDoors {

    static class GridPoint{
        int row;
        int col;
        char c;
        GridPoint parent;
        List<GridPoint> traversedList = new ArrayList<>();
        GridPoint(int row, int col, char c){
            this.row = row;
            this.col = col;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            GridPoint gridPoint = (GridPoint) o;
            return row == gridPoint.row &&
                col == gridPoint.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
    static int[][] find_shortest_path(String[] grid) {
        // 1. build graph
        int rows = grid.length;
        int cols = grid[0].length();
        Map<GridPoint, List<GridPoint>> graph = new HashMap<>();
        GridPoint startNode = null;
        // graphmap will be created as
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length();j++){
                GridPoint currPoint = new GridPoint(i,j,grid[i].charAt(j));
                if(startNode == null && currPoint.c == '@'){
                    startNode = currPoint;
                }
                // find neighbors
                List<GridPoint> gridPointList = new ArrayList<>();
                if(i - 1 >=0){
                    gridPointList.add(new GridPoint(i-1,j,grid[i-1].charAt(j)));
                }
                if(i + 1 < grid.length){
                    gridPointList.add(new GridPoint(i+1,j,grid[i+1].charAt(j)));
                }
                if(j-1 >=0){
                    gridPointList.add(new GridPoint(i,j-1,grid[i].charAt(j-1)));
                }
                if(j+1<grid.length){
                    gridPointList.add(new GridPoint(i,j+1,grid[i].charAt(j+1)));
                }
                graph.put(currPoint,gridPointList);

            }
        }

        // start bfs on startnode
        List<GridPoint> gridPointResult = new ArrayList<>();
        Map<Character,GridPoint> keyMap = new HashMap<>();
        Queue<GridPoint> queue = new LinkedList<>();
        queue.add(startNode);
        while(!queue.isEmpty()){
            GridPoint gridPoint = queue.poll();
        }
        return new int[0][0];
    }


}
