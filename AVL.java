public class AVL {
    class Node {
        private int value ;
        private int height; 
        private Node left ;
        private Node right ;

        

        public  Node (int value ){
            this.value = value ;
        }

        public int getvalue(){
            return value ;
        }

        private Node root ;

        public void  AVL (){

            
        }

        public int height (Node node){
            if (node== null){
                return -1 ;
            }
            return node.height ;
        } 

        public boolean isEmpty (){
            return root == null ;
        }

       

    public void insert (int value ){
        root = insert(value , root );
        
    }

    private Node insert (int value  , Node node ){
        if (node == null){
            node = new Node(value) ;
            return node ;
        }

        if (value < node.value){
            node.left = insert( value, node.left);

        }

        if (value > node.value){
            node.right = insert(value, node.right);

        }

        node.height = Math.max(height(node.left) , height(node.right)) + 1 ;

        return rotate(node);

    }

    public Node  rotate (Node node ){

        if (height(node.left) - height(node.right)  > 1){
            if (height(node.left.left) - height (node.left.right) > 0){
                return rightRotate (node) ;
            }

            if (height(node.left.right) - height (node.left.right) < 0 ) {
                node.left = leftRotate (node.left);

                return rightRotate (node) ;
            }
        }

        if (height(node.left) - height(node.right)  < -1){
            if (height(node.right.left) - height (node.right.right) > 0){
                node.right = rightRotate(node);
                return leftRotate(node)  ;
            }

            if (height(node.right.left) - height (node.right.right) < 0 ) {
                
                return leftRotate(node) ;
            }
        }


        return node ;

    }


    public Node rightRotate (Node p){
        Node c = p.left ;
        Node t = c.right ;

        c.right = p ;
        p.left = t  ;

        p.height = Math.max(height(p.left),height ( p.right)+1) ;
        c.height = Math.max(height(p.left),height ( p.right) +1) ;
        return c ;
    }

    public Node leftRotate (Node c){
      Node p = c.right ;
      Node t = c.left ;

      p.left = c ;
      c.right = t ;

      p.height = Math.max(height(p.left),height ( p.right)+1) ;
      c.height = Math.max(height(p.left),height ( p.right) +1) ;
        return p ;



    }


    public boolean balanced (){
        return balanced(root); 
    }

    private boolean balanced (Node node){
        if ( node == null){
            return true ;
        }
        return Math.abs(height(node.left) - height (node.right)) <= 1  && balanced(node.left) && balanced(node.right) ;
    }

    public void populate (int [] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]); 
        }
    }


    public void display (){
            display(root  , "Root Node :");
        }

    public void display (Node node , String details){
            if (node == null){
                return ;            
            }
            System.out.println(details + node.value);

            display(node.left, "Left child of " + node.getvalue() + " : ");
            display(node.right, "Right child of " + node.getvalue() + " : ");
        }



        // preOrder treversal :=

    public void preOrder (){
        preOrder(root);
    }

    private void preOrder (Node node){
        if (node ==null){
            return ;

        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

        // InOrder treveersal : =

        public void InOrder  (){
            InOrder(root);
        }
        
        private void InOrder (Node node){
            if (node == null ){
                return ;

            }
            InOrder(node.left);
            System.out.println(node.value + " ");
            InOrder(node.right);

        }

        // post order treversal :=

        public void postOrder(){
            postOrder(root);
        }

        private void postOrder (Node node){
            if (node == null){
                return ;

            }
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.value + " ");
        }
    }



    
}
