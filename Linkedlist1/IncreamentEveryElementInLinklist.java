package Linkedlist1;

import java.util.Scanner;

class DoubleNode{
  Node<Integer> head;
  Node<Integer> tail;
  DoubleNode(){

  }
  DoubleNode(Node<Integer> head, Node<Integer> tail){
    this.head = head;
    this.tail = tail;
  }
}

public class IncreamentEveryElementInLinklist {
    public static Node<Integer> createLinkedList(){
        Node<Integer> n1= new Node<>(10);
        Node<Integer> n2= new Node<>(20);
        Node<Integer> n3= new Node<>(30);
        Node<Integer> n4= new Node<>(40);
        n1.next=n2;
        //System.out.println("n1 "+n1+ " data "+ n1.data+" next "+n1.next);
        n2.next=n3;
        //System.out.println("n2 "+n2+ " data "+ n2.data+" next "+n2.next);
        n3.next=n4;
        //System.out.println("n3 "+n3+ " data "+ n3.data+" next "+n3.next);
        //System.out.println("n4 "+n4+ " data "+ n4.data+" next "+n4.next);
        return n1;
    
        }
    
      public static void print(Node<Integer> head){
    
          Node<Integer> temp = head;
          while(temp!= null){
            System.out.print(temp.data+" ");
            temp=temp.next;
          }
          System.out.println();
    
          //System.out.println("Print"+head);
          //System.out.println(head.data);
          //System.out.println(head.next);
          //System.out.println(head.next.data);
          //System.out.println(head.next.next.data);
      }
    
      public static void increment(Node<Integer> head){
       // head = new Node<Integer>(100);
        //head.data++;
        Node<Integer> temp = head;
        while(temp != null){
          temp.data++;
          temp = temp.next;
        }
        System.out.println();
    
    
      }


      public static Node<Integer> takeInput(){
       
      Scanner s= new Scanner(System.in);
      int data = s.nextInt();
      Node<Integer> head = null, tail = null;
      while(data != -1){
        // Make this node as head node
        Node<Integer> currentNode = new Node<Integer>(data);
        if(head==null){
          //Make this node as head node and tail node
          head=currentNode;
          tail=currentNode;
        }else{
          // Node<Integer> tail = head;
          // while(tail.next!=null){
          //     tail= tail.next;
          // }
          // //Now tail will refer to last node
          // //Connect current node after last nopde
          tail.next= currentNode;
          tail = currentNode; //tail = tail.next;
        }
       
        data=s.nextInt();
    }
    return head;
  }

  
      
      public static void insert(Node<Integer> head, int elem, int pos){
        Node<Integer> nodeToBeInserted = new Node<Integer>(elem);

        if(pos == 0){
          nodeToBeInserted.next = head;
          head = nodeToBeInserted;

        }else{

            int count = 0;
        Node<Integer> prev = head;
        while(count <pos -1 && prev != null){
          count++;
          prev = prev.next;
        }
        if(prev != null){
          nodeToBeInserted.next = prev.next;
         prev.next = nodeToBeInserted;

        }

        }
        print(head);

     
         
       
      }


      public static void printRecursive(Node<Integer> head){
        if(head == null){
          return;

        }
        System.out.print(head.data +" ");
        printRecursive(head.next);
      }

      public static Node<Integer> insertRecursive(Node<Integer> head, int elem, int pos ){

        if(head == null && pos > 0){
          return head;
        }

        if(pos == 0){
          Node<Integer> newNode = new Node<>(elem);
          newNode.next = head;
          return newNode;
        }else{
          // Node<Integer> smallerHead = insertRecursive(head.ext, elem, pos - 1);
          // head.next = smallerHead;
          head.next = insertRecursive(head.next, elem, pos - 1);
          return head;
        }
      }


      public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos){

        if (head == null) {
          return head;
        }

        if (pos == 0){
          return head.next;
        }

        Node<Integer> smallHead = deleteNodeRec(head.next, pos - 1);
        head.next = smallHead;

        return head;
      }


      /*
       * Time complexity : O(n)
       * Space Complexity: O(n)
       * Where 'n' is size of the Singly Link List
       */

       public static Node<Integer> reverseRec(Node<Integer> head) {

        if (head == null || head.next == null) {
          return head;
        }

        Node<Integer> smallHead = reverseRec(head.next);
        head.next.next = head;
        head.next = null;

        return smallHead;
       }


       public static DoubleNode reverseRBetter(Node<Integer> head){
        DoubleNode ans;
        if(head == null || head.next == null){
          ans = new DoubleNode(head, head);
          // ans.head = head;
          // ans.tail = head;
          return ans;
        }
        //This double node will have both head and tail of reverse LL
        DoubleNode smallAns = reverseRBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;
        ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
       }

       public static Node<Integer> reverseRBest(Node<Integer> head){
        if(head == null || head.next == null){
          return head;
        }
        Node<Integer> smallHead = reverseRBest(head.next);
        Node<Integer> reverseTail = head.next;
        reverseTail.next = head;
        head.next = null;
        return smallHead;
       }


       public static Node<Integer> reverseRBetter1(Node<Integer> head){
        DoubleNode ans = reverseRBetter(head);
        return ans.head;
       }

       public static Node<Integer> midpoint(Node<Integer> head){

        Node<Integer> slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
          slow = slow.next;
          fast = fast.next.next;
        }
        return slow;
       }

       public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){

        if(head1 == null){
          return head2;
        }
        if(head2 == null){
          return head1;
        }

        Node<Integer> t1 = head1, t2 = head2;
        Node<Integer> head = null, tail = null;

        if(t1.data <= t2.data){
          head = t1;
          tail = t1;
          t1 = t1.next;
        }else{
          head = t2;
          tail = t2;
          t2 = t2.next;
        }

        while (t1 != null && t2 != null) {
          if(t1.data <= t2.data){
            tail.next = t1;
            tail = t1;
            t1 = t1.next;
          }else{
             tail.next = t2;
            tail = t2;
            t2 = t2.next;

          }
          
        }
        // One list is over
        if(t1 != null){
          //first list is remaining
          tail.next = t1;
        }else{
          tail.next = t2;
        }
        return head;
    }

    /*do merge linklist ko alag alag karna ka code */


    /*
   * Time Complexity : O(n * log n)
   * Space Complexity : O(log n)
   * Where 'n' is size of the Singly Linkedlist
   */

   private static Node<Integer> findMind(Node<Integer> head) {
    if (head == null){
      return head;
    }

    Node<Integer> slow = head;
    Node<Integer> fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      
    }

     return slow;
   }

   private static Node<Integer> merge1(Node<Integer> head1, Node<Integer> head2){
    if(head1 == null){
      return head2;
    }
    if(head2 == null){
      return head1;
    }

    Node<Integer> newHead = null, newTail = null;

    if (head1.data < head2.data) {
      newHead = head1;
      newTail = head2;
      head2 = head2.next;
    }

    while (head1 != null && head2 != null) {

      if (head1.data < head2.data) {
        newTail.next = head1;
        newTail = newTail.next;
        head1 = head1.next;
      }else {
       newTail.next = head2;
       newTail = newTail.next;
       head2 = head2.next;
        
      }
      
    }

    if (head1 != null){
      newTail.next = head1;
    }
    if (head2 != null) {
      newTail.next = head2;
    }

    return newHead;
   }

   public static Node<Integer> mergeSort(Node<Integer> head) {

    if (head == null || head.next == null) {
      return head;
    }

    Node<Integer> mid = findMind(head);

    Node<Integer> half1 = head;
    Node<Integer> half2 = mid.next;
    mid.next = null;

    half1 = mergeSort(half1);
    half2 = mergeSort(half2);

    Node<Integer> finalHead = merge1(half1, half2);

    return finalHead;
   }
  

      
      
      public static void main(String[] args){



        // Node<Integer> head = takeInput();
        // Node<Integer> mid = findMind(head);
        // print(mid);

      
        // Node<Integer> head1 = takeInput();
        //  Node<Integer> head2 = takeInput();
        //  Node<Integer> head = merge(head1, head2);
        //  print(head);



        // Node<Integer> head = takeInput();
        // Node<Integer> mid = midpoint(head);
        // System.out.println(mid.data);


        //  Node<Integer> head = takeInput();
        //  head = reverseRBest(head);
        //  print(head);


        //  Node<Integer> head = takeInput();
        //  head = reverseRBetter1(head);
        //  print(head);


        //  Node<Integer> head = takeInput();
        //  DoubleNode ans = reverseRBetter(head);
        //  print(ans.head);

        //  Node<Integer> head = takeInput();
        //  head = reverseRec(head);
        //  print(head);
         
        
         

        //  Node<Integer> head = takeInput();
        //  head = deleteNodeRec(head, 1);
        //  print(head);


        // Node<Integer> head = takeInput();
        // head = insertRecursive(head, 20, 2);
        // printRecursive(head);

        // Node<Integer> head = takeInput();
        // printRecursive(head);

        // Node<Integer> head = takeInput();
        // insert(head, 80, 4);
        // print(head);
    
          // Node<Integer> head = createLinkedList();
          // increment(head);
          // print(head);
          //Node<Integer> n1= new Node<>(10);
          //System.out.println(n1);
          //System.out.println(n1.data);
          //System.out.println(n1.next);
    
    
    
      }
    
}
