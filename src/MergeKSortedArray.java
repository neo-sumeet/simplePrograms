import java.util.PriorityQueue;

public class MergeKSortedArray {
    static class ArrayNode {
        int arrayPos;
        int value;
        int index;

        ArrayNode(int value, int arrayPos,int index){
            this.value = value;
            this.arrayPos = arrayPos;
            this.index = index;
        }


    }
    /*
     * Complete the mergeArrays function below.
     */
    static int[] mergeArrays(int[][] arr) {
        /*
         * Write your code here.
         */
        if(arr.length == 0){
            return new int[0];
        }
        //  ArrayNode[] arrayNodeArray = new ArrayNode[arr.length];
        //  for(int i = 0;i<arr.length;i++){
        //     arrayNodeArray[i] = new arrayNode(arr[i],i);
        //  }

        PriorityQueue<ArrayNode> pq = new PriorityQueue<>(arr.length,(an1, an2) -> an1.value - an2.value);

        // initialize priority queue
        initializePriorityQueue(arr,pq);
        int totalLen=(arr.length * arr[0].length);

        int[] output = new int[totalLen];
        for(int i=0;i<totalLen;i++){
            output[i] = extractMinAndAdd(pq,arr);
        }

        return output;

    }

    static void initializePriorityQueue(int[][] arr, PriorityQueue<ArrayNode> pq){
        for(int i=0;i<arr.length;i++){
            pq.add(new ArrayNode(arr[i][0],i,0));
        }
    }

    static int extractMinAndAdd(PriorityQueue<ArrayNode> pq, int[][] arr){
        ArrayNode out = pq.poll();
        int arrayPos = out.arrayPos;
        int index = out.index;
        int value = out.value;

        if(index < arr[arrayPos].length - 1){
            index++;
            pq.add(new ArrayNode(arr[arrayPos][index],arrayPos,index));
        }
        return value;
    }
}
