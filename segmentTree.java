public class segmentTree {

  
    public static void main(String[] args) {
        int [] arr  = {3,8,7,6,-2 ,-8 ,4 , 9} ;
        segmentTree st  = new segmentTree(arr) ;

    }

    public static  class  Node {
        int data ;
        int startInterval ;
        int endInterval ;
        Node left ;
        Node right ;

    public Node (int startInterval , int endInterval ){
        this.startInterval= startInterval ;
        this.endInterval = endInterval  ;

    }
    }
    
    Node root  ;
       // tree meaking 
    public  segmentTree(int[] arr) {
        this.root = constructor (arr , 0 , arr.length -1);
    
    }
                // conditions 
    private Node constructor (int [] arr , int start , int end){
        if (start == end ){
            Node leaf  = new Node(start , end);
            leaf.data = arr[start];
            return leaf ;
        }

        Node node = new Node(start, end);
        int mid = (start+ end) / 2 ;

        node.left = this.constructor(arr, start, mid);
        node.right = this.constructor(arr, mid+1, end) ;

        node.data = node.left.data + node.right.data ;

        return node ;

    }


    public void display (){
        display(root);
    }
    
    private void display (Node node ){
        String st = "";

        if (node.left != null){
            st = st + "Interval = [" + node.left.startInterval + "-" + node.left.endInterval + "] and data is " + node.left.data  + " => " ;
        }
        else  {
             st= st + "there is no left child " ;

        }

         st = st + "Interval = [" + node.left.startInterval + "-" + node.left.endInterval + "] and data is " + node.data  + " <= " ;
        
        if (node.right != null){
            st = st + "Interval = [" + node.left.startInterval + "-" + node.right.endInterval + "] and data is " + node.right.data  + " => " ;
        }
        else  {
             st= st + "there is no right  child " ;

        }

        System.out.println( st);

        if (node.left != null){
            display(node.left);
   
        }

        if (node.right != null){
            display(node.right);
        }
    }
    

    // finding query :=

    public int query (int qStart , int qEnd){
        return query(this.root , qStart, qEnd);
    }

    private int query (Node node  ,int qStart , int qEnd){
        // completely inside 
        if (node.startInterval >= qStart && node.endInterval <= qEnd) {
            return node.data ;

        }
        // completely outside 
        else if (node.startInterval > qStart || node.endInterval < qEnd){
            return 0 ;

        }
        else{
            return this.query(node.left, qStart, qEnd) + this.query(node.right, qStart, qEnd);

        }

    }

    public void update1 (int index , int value){
        this.root.data = update2( this.root ,index, value);

    }

    private int update2 (Node node ,int index , int value){
        if (index >= node.startInterval && index <= node.endInterval){
            if (index == node.startInterval && index == node.endInterval){
                node.data =value ;
                return node.data ;
            }
            else {
                int leftAns = update2( node.left ,index, value);
                int rightAns = update2( node.right ,index, value);
                node.data = leftAns + rightAns ;
                 return node.data ;
                 
            }
        }

        return node.data ;


    }

   
}
