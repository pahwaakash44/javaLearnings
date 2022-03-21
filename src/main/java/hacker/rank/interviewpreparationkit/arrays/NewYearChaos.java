package hacker.rank.interviewpreparationkit.arrays;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewYearChaos
{
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        
        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                
                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                
                NewYearChaosResult.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        bufferedReader.close();*/
        
        NewYearChaosResult.minimumBribes(Arrays.asList(2,1,5,3,4));
    }
}

class NewYearChaosResult {
    
    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */
    
    /**
     * Scenarios:
     *  1. no bribes provided
     *  2. 1 <= bribes <= 2
     *  3. bribes > 2, Too chaotic
     * @param queue new year queue
     */
    public static void minimumBribes(List<Integer> queue) {
        // Write your code here
        // 2,1,5,3,4
        int bribe = 0;
        
        // clone the array and sort the cloned array
        List<Integer> sortedQueue = new ArrayList<>(queue);
        Collections.sort(sortedQueue);
        System.out.println("queue: " + queue);
        System.out.println("sortedQueue: " + sortedQueue);
        
        // now get the position difference of the elements
        // if for each element the diff > 2 print Too chaotic and break
        
        
        /*
          1. iterate over sorted elements
          2. check position of i th element sortedQueue in the queue
          3. if the position of the i th element doesn't match - get position diff = unsortedQueuePosition - sortedQueuePosition
          4. now increment the i to  unsortedQueuePositionOfIthElement + 1;
          5. again steps 2 to 4 till i < queue.size()
         */
        
        /*for ()
        {
        
        }*/
        
        System.out.println(bribe);
    }
    
    private static int oldWay(List<Integer> queue, int bribe, List<Integer> sortedQueue)
    {
        for (int element : sortedQueue)
        {
            int diff = queue.indexOf(element) - sortedQueue.indexOf(element);
            System.out.printf("element: %d, indexOfQueue: %d, indexOfSortedQueue: %d diff: %d%n",
                    element, queue.indexOf(element), sortedQueue.indexOf(element) ,diff);
            if (diff > 2)
            {
                System.out.println("Too chaotic");
                return -1;
            }
            bribe += diff;
        }
        return bribe;
    }
    
}