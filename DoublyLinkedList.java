public class DoublyLinkedList {

    
Node head ;
    public void FirstInsert(int val ){
        Node node = new Node(val );
        node.next = head ;
        node.previous = null ;

        if ( head != null){
            head.previous = node ;
        }

        head = node ;
    }


    public void LastInsert(int val){
        Node node = new Node(val);
        Node last = head ;

        node.next = null ;

        if (head== null){
            node.previous = null ;
            head = node  ;
            return ; 
        }

        while (last.next  != null){
            last = last.next ;

        }
        last.next= node ;
        node.previous = last ;
    }

    // finding element 
    public Node find (int value){
        Node node = head ;
        while (node != null){
            if (node.val == value){
                return node ;

            }
        }
        node = node.next ;
        return null ;
    }




    public void Insert (int after , int val ){
        Node p = find(after);

        if (p == null ){
            System.out.println( "node is not found ");
            return;
        }

        Node node = new Node(val);
        
        node.next = p.next ;
        p.next = node  ;
        node.previous = p ;
         if (node.next != null){
            node.next.previous = node  ;

         }
    
    }


        
          
    public void Display (){
        Node node = head ;
        Node last = null ;
          // forward 
        while(node != null){
            System.out.print(node.val+ " -> " );
             last = node ;
            node = node.next ;
           
        }
        System.out.println("End");

        // reverse 

        System.out.println("Print in reverse");
        while(last != null){
            System.out.print(last.val + " -> ");
            last= last.previous ;
        }
        System.out.println("Start");

    }

  
           
    
    

    

    // lntializing the Linked List 
   private class Node  {
    int val ;
    Node next ;
    Node previous ;

    public Node (int val){
        this.val = val ;

    }
     public Node (int val , Node next , Node previous){
        this.val = val ;
        this.next = next ;
        this.previous = previous ;

    }


    }

}

