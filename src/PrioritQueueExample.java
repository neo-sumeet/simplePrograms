import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class PrioritQueueExample {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>( (Integer o1, Integer o2) -> {return  -1 * o1.compareTo(o2);});
        pq.add(3);
        pq.add(5);
        pq.add(1);
        pq.add(4);
        pq.add(2);
        pq.add(6);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
