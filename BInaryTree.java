import java.util.Scanner;

public class BInaryTree {

    public BInaryTree (){
    }
    private static class Node{
         int value ;
        Node left ;
        Node right  ;
      public Node (int value){
        this.value= value ;
        }  
    }
    
    private Node root;

    public void populate (Scanner scanner){
        System.out.println("Enter a root node value  :-");
        int value = scanner.nextInt();
         root = new Node(value);
         populate( scanner , root  );
    }

    private void  populate (Scanner scanner , Node node ){
    
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = scanner.nextBoolean() ;
        if (left){
            System.out.println("Enter the value of left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left );
        }

        System.out.println("Do you want to enter right of " + node.value);
        boolean right = scanner.nextBoolean() ;
        if (right){
            System.out.println("Enter the value of right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right );
        }
    }
    
    public void display(){
        display(root, " ");
    }
   
    private void display (Node node , String indent ){
        if (node == null){
            return ;

        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
         display(node.right, indent + "\t");
    }


    public void betterDisplay (){
        betterDisplay(root , 0);

    }

    private void betterDisplay (Node node  , int leval){
        if (node == null){
            return ;
        }
        betterDisplay(node.right, leval+1);
        if (leval != 0 ){
            for (int i = 0; i < leval -1; i++) {
                System.out.print("|\t\t");     
            }
            System.out.println("|-------->" + node.value);     
        }
        else {
            System.out.println(node.value);
        }

        betterDisplay(node.left, leval+1);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BInaryTree tree = new BInaryTree() ;
        tree.populate(scanner);
        tree.display();
        tree.betterDisplay();
    }
}
