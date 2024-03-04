import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GRAPHS {
    static class Edge {
        int src ;
        int des  ;
        int weight ;


        public Edge(int s , int d , int w){
            this.des = d ;
            this.src = s ;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList <Edge> graph []){
        for (int i = 0 ; i <graph.length ; i++){
            graph[i] = new ArrayList<Edge>();
        }
       graph[0].add(new Edge(0, 2 , 2));
       graph[1].add(new Edge(1, 2 , 0));
       graph[1].add(new Edge(1, 3 , 10));

       graph[2].add(new Edge(2, 0 , 2));
        graph[2].add(new Edge(2, 1 , 10));
        graph[2].add(new Edge(2, 3 , -1));
  
        graph[3].add(new Edge(3, 1 , 0 ));
        graph[3].add(new Edge(3, 2, -1));
    }

    public static void BFS (ArrayList <Edge> graph[] , int V , boolean [] visited , int start){
       Queue <Integer> q = new LinkedList<>();
      
       q.add(start);
       while (!q.isEmpty()) {
        int curr = q.remove();
            if (visited[curr]==false){
                System.out.print(curr + " ");
                visited[curr] = true ;
                for (int index = 0; index < graph[curr].size(); index++) {
                    Edge e = graph[curr].get(index);
                    q.add(e.des);

                }
            }
        
       }

    }
    public static void DFS (ArrayList <Edge> graph[], int curr ,boolean visited[]){
        System.out.print(curr + " ");
        visited[curr] = true ;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[e.des] == false ){
            DFS(graph, e.des, visited);  
        }
    }
    }

    
    public static void AllPath(ArrayList < Edge> graph[], int curr ,boolean visited[] , String path , int target){
        if (curr == target){
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.des]){
                visited[curr] = true;

                AllPath(graph, e.des, visited, path + e.des, target);
                visited[curr]= false ;
            }
        }
    }
    public static boolean CycleDetection (ArrayList <Edge> graph [] , int curr ,boolean visited[] , boolean rec[] ){
        visited[curr] = true;
        rec[curr] = true ;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.des]){
                return true ;
            }
            else if (!visited[e.des]){
                if (CycleDetection(graph, e.des, visited, rec)){
                    return true ;
                }
            } 
                
        }
        rec[curr]= false ;
        return false ;

    }

    public static boolean isCycleDetection (ArrayList <Edge> graph [] , int curr ,boolean visited[] , int parent ){
        visited[curr] = true;
      
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[curr] && e.des != parent ){
                return true ;
            }
            else if (!visited[e.des]){
                if (isCycleDetection(graph, e.des, visited, parent)){
                    return true ;
                }
            } 
                
        }
        return false ;
    }

    public static void topSort (ArrayList < Edge > graph [] , int  v){
        boolean visited [] = new boolean[v] ;
        Stack <Integer > stack = new Stack<>() ;
        for (int i = 0; i < v; i++) {
            if (!visited[i]){
                topSortUtil(graph, i, visited, stack);
            }
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }


    private static void topSortUtil (ArrayList <Edge> graph [] ,int curr , boolean visited[], Stack<Integer > stack  ){
        visited[curr] = true  ;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e =graph[curr].get(i);

            if(!visited[e.des]){
                topSortUtil(graph, e.des, visited, stack);
            }
        }

        stack.push(curr);
    }

    

    public static void main(String[] args) {
        /*int V = 4 ;
        ArrayList <Edge> graph [] = new ArrayList[V];
        createGraph(graph);

        // 2's neighbours 
        for (int i = 0; i < graph[2].size() ; i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.des + " ");
        }*/

       /*  int V = 4 ;
        ArrayList <Edge> graph [] = new ArrayList[V];
        createGraph(graph);
        boolean visited [] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i]==false){
                 BFS(graph, V , visited , i) ;
            }
            
        }
        System.out.println();
       */
        /*int V = 4 ;
        ArrayList <Edge> graph [] = new ArrayList[V];
        createGraph(graph);
        boolean visited [] = new boolean[V];
            
        for (int i = 0; i < V; i++) {
            if (visited[i]==false){
                DFS(graph, i, visited);
            }      
        }
        System.out.println();
       
*/
        int V = 4 ;
        ArrayList <Edge> graph []= new ArrayList[V];
        createGraph(graph);
       

      /*   int target = 3;
        int source = 0;
        AllPath(graph, source,new boolean  [V], "0", target);
        */

        //System.out.println(CycleDetection(graph, 0, new boolean[V], new boolean[V]));
       
      // topSort(graph, V);


    //  System.out.println(isCycleDetection(graph, 0,new boolean[V], -1)) ;

    }   


}
