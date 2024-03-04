import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNode {
    int val; 
    TreeNode left;
    TreeNode right ;
    TreeNode next;
    TreeNode(){}

    TreeNode (int val){
        this.val = val ;
    }

    TreeNode(int val , TreeNode left , TreeNode right ){
        this.val =val;
        this.left = left;
        this.right = right ;
        
    }
    TreeNode(int val , TreeNode left , TreeNode right , TreeNode next){
        this.val =val;
        this.left = left;
        this.right = right ;
        this.next = next;
    }
}

public class binarytreesQuestion {

    public static void main(String[] args) {
        
    }
    
    //BFS in trees 

    // list of list of all levels in tree solution :=
    public List<List<Integer>> levelOrder (TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }
        
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            List<Integer>currentLevel = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left ==  null){
                    queue.offer(currentNode.left);
                }

                if (currentNode.right ==  null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    // leveltrevaersal find the next element of targeted element 

    public TreeNode findSuccessor ( int target  , TreeNode root) {
        if (root == null){
            return null ;
        }
        Queue <TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root);

        while(!queue1.isEmpty()){
            TreeNode current = queue1.poll();

            if (current.left != null){
                queue1.offer(current.left);
            }

            if (current.right != null){
                queue1.offer(current.right);
            }

            if (current.val == target){
                break;
            }
        }
        return queue1.peek();
    }


    // zigzag treversal in BT  using BFS 

    public List<List<Integer>>zigzagtreversal (TreeNode root ){
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque= new LinkedList<>();
        deque.offer(root);

        boolean rev = false;

        while(!deque.isEmpty()){
           int len =  deque.size();
           List <Integer> current = new ArrayList<>(len);

           for (int i = 0; i <len; i++) {
               if (!rev){
                TreeNode currentNode = deque.pollFirst();
                current.add(root.val);

                if (currentNode.left != null){
                    deque.addLast(currentNode.left);
                }
                if (currentNode.right != null){
                    deque.addLast(currentNode.right);
                }
               }
               else{  
                TreeNode currentNode = deque.pollLast();
                current.add(root.val);
                if (currentNode.right != null){
                    deque.addFirst(currentNode.right);
                }
                if (currentNode.left != null){
                    deque.addFirst(currentNode.left);
                }
               }
           }
           rev = !rev;
           result.add(current);
        }
        return result;

    }

    // connect the bridge of levels return node 
    public TreeNode connectBrigTreeNode (TreeNode root ){
        if (root == null){
            return null ;
        }

        TreeNode leftMost = root;
        while (leftMost.left != null) {
            TreeNode current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next ;
            }
            leftMost = leftMost.left;
        }

        return root;
    }


    // right side view link list return all  node that are at last position in tree
    public List<Integer> RightView (TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int length = queue.size();
           
            for (int i = 0; i < length; i++) {
                TreeNode currentNode = queue.poll();
        
                if (i == length-1){
                    result.add(currentNode.val);
                }
                if (currentNode.left ==  null){
                    queue.offer(currentNode.left);
                }

                if (currentNode.right ==  null){
                    queue.offer(currentNode.right);
                }
            }
           
        }
        return result;
    }

    // the node is at same level but not have same parrent 

    public boolean isCousins (TreeNode root , int  x , int y ){
        TreeNode xx = find(root , x);
        TreeNode yy = find(root , y);


        return (level(root , xx, 0 )== level (root ,yy , 0) && !isSiblig (root , xx , yy));
    }

    private TreeNode find (TreeNode node , int x){
        if (node == null){
            return null;
        }

        if (node.val == x){
            return node ;
        }

        TreeNode n  = find(node.left, x);
        if(n== null){
            return null ;
        }

        return find(node.right, x);
    }

    private boolean isSiblig (TreeNode node , TreeNode xx, TreeNode yy){
        if (node == null) {
            return false ;
        }

        return (node.left == xx && node.right == yy) || (node.left == xx && node.right == yy ) 
        || (isSiblig(node.left, xx, yy)) || (isSiblig(node.right, xx, yy));
    }

    private int level (TreeNode node , TreeNode x , int intialLeval ){
        if (node  == null){
            return 0;
        }

        if (node == x){
            return intialLeval;
        }

        int l = level(node.left, x, intialLeval+1);
        if (l != 0){
            return l;
        }

        return level(node.right, x, intialLeval+1);
    }



    // DFS QUESTION  


    // logest path in tree or largest path 

    int diameter = 0;
    public int longDiameter (TreeNode root){
        height(root);
        return diameter -1;
    }
    private int height (TreeNode node){
        if (node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia) ;

        return Math.max(leftHeight, rightHeight) + 1 ;
    }


    // invert the tree 

    public void flatten (TreeNode root){
        TreeNode current = root ;
        while(current != null){
            if (current.left != null){
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = current.right;
                current.right = current.left ;
                current.left = null;
            }

            current = current.right;
        }
    }


    // valid BST tree 

    public boolean isBST (TreeNode root){
        return helper(root, null, null);
    }

    private boolean helper (TreeNode node , Integer low , Integer high ){
        if (node == null){
            return true ;
        }

        if (low != null && node.val <= low){
            return false;
        }
        
        if (high != null && node.val >= high){
            return false;
        }

        boolean leftTree = helper(node.left, low, node.val);
        boolean rightTree = helper(node.right, node.val , high);

        return true ;
    }



    // kth smallest node value :=
    public int kSmallest (TreeNode root, int k){
        return helperK(root , k).val ;
    }

    int count = 0;
    private TreeNode helperK(TreeNode node , int k){

        if (node == null){
            return null;
        }
        TreeNode left  = helperK(node.left, k);
        if (left != null){
            return left;
        }

        count ++;
        if (count == k ){
            return node ;
        }

        return helperK(node.right, k);
    }
}
