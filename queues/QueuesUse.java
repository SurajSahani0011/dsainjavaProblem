package queues;

public class QueuesUse {

    public static void main(String[] args){

       // QueuesUsingArray queue = new QueuesUsingArray();
       QueueUsingLL<Integer> queue = new QueueUsingLL<>();
        int arr[] = {10,20,30,40,50};
        for(int elem : arr){
         //   try {
                queue.enqueue(elem);
          //  } catch (QueueFullException e){

            }
      //  }

        while (! queue.isEmpty()) {
            try{
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {
                // Will never reach here
            }
            
        }
    }
    
}
