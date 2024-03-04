import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Graphs_Sorting {
        static class Edge {
            int src ;
            int des  ;
            int weight ;
    
    
            public Edge(int s , int d , int wt){
                this.des = d ;
                this.src = s ;
                this.weight = wt;
            }
        }
    
        public static void createGraph(ArrayList <Edge> graph []){
            for (int i = 0 ; i <graph.length ; i++){
                graph[i] = new ArrayList<Edge>();
            }
    
        /*    graph[0].add(new Edge(0, 2 , 2));
            graph[0].add(new Edge(0, 3 , 2));
            
           graph[1].add(new Edge(1, 2 , 0));
           graph[1].add(new Edge(1, 3 , 10));
    
           graph[2].add(new Edge(2, 0 , 2));
            graph[2].add(new Edge(2, 1 , 10));
            graph[2].add(new Edge(2, 3 , 3));
      
            graph[3].add(new Edge(3, 1 , 2 ));
            graph[3].add(new Edge(3, 2,  4)); */
            
            //for kaju 
            graph[0].add(new Edge(0, 2 , 2));
            graph[0].add(new Edge(0, 3 , 2));
            
           graph[1].add(new Edge(1, 0 , 0));
          
    
    
            graph[2].add(new Edge(2, 1 , 10));
        
      
            graph[3].add(new Edge(3, 4 , 2 ));
           

        }
    
    public static class Pair implements Comparable <Pair> {
        int node  ;
        int dist ;

        public Pair (int n , int d){
            this.dist = d;
            this.node = n ;
        }

        @Override 
        public int compareTo (Pair p2){
            return this.dist - p2.dist ;
        }
    }

    public static void dijkstra (ArrayList <Edge> graph [] , int src , int V){
            PriorityQueue <Pair> pq = new PriorityQueue<> () ;
            int dist [] = new int[V];

            for (int index = 0; index < V; index++) {
                if (index != src) {
                    dist[index]= Integer.MAX_VALUE ;             
                }
            }
            boolean visited [] = new boolean[V] ;
            pq.add(new Pair(0, 0)) ;

            while (!pq.isEmpty()){
                Pair curr =pq.remove() ;
                if (!visited [curr.node]){
                    visited[curr.node] = true ;
                }
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src ;
                    int v = e.des ;

                    // relxatation
                    if (dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight ;
                        pq.add(new Pair(v , dist[v]));
                    }
                
                }
            }
            for (int i = 0; i <V; i++) {
                System.out.print(dist[i] + " ");  
            }
            System.out.println();

    }

    public static void bellmanFord (ArrayList < Edge > graph [] , int src  , int V ){
        int dist []= new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src){
                dist[i] = Integer.MAX_VALUE ;               
            }        
        }
        for (int index = 0; index < V-1; index++) {
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < graph[k].size(); i++) {
                    Edge e = graph[k].get(i) ;
                    int u = e.src;
                    int v = e.des ;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]){
                        dist[v] = dist[u] + e.weight ;
                    }
                }    
            }           
        }
        for (int index = 0; index < dist.length; index++) {
            System.out.print(dist[index] + " ");  
        }
        System.out.println();
    }


    public static void primsAlgo (ArrayList < Edge > graph [] , int V){
        PriorityQueue < Pair > pq = new PriorityQueue<>();
             pq.add(new Pair(0,0)) ;
        boolean visited [] = new boolean[V] ;
        int sumCost = 0 ;

            // consider the pair dist = cost of weight 

            while (!pq.isEmpty()){
                Pair curr = pq.remove() ;
                if(!visited[curr.node]){
                    visited[curr.node] = true;
                    sumCost += curr.dist ;
                    for (int i = 0; i < graph [curr.node].size(); i++) {
                        Edge e = graph [curr.node].get(i);
                        if (!visited[e.des]){
                            pq.add(new Pair(e.des, e.weight)) ;
                        }
                        
                    }  

                }

            }
        
            System.out.println("minimum cost of MST is :-  " +  sumCost);

    }
    public static void kajurajasAlgo (ArrayList <Edge > graph [] , int V){
        
        // step 1 
        Stack < Integer> stack = new Stack<>();
        boolean visited [] = new boolean[V] ;

        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                topSort (graph , i , visited ,stack) ;
            }
            
        }
        // step 2

        ArrayList <Edge> Transpose [] = new ArrayList [V];
        for (int i = 0 ; i <graph.length ; i++){
            visited[i] = false ; // for reuse of visited in step 3 
            Transpose[i] = new ArrayList<Edge>();
            }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j <graph[i].size(); j++) {
                Edge e = graph[i].get(j) ;  // e.src(i) -> e.des
                Transpose[e.des].add( new Edge(e.des, e.src, e.weight));
                // dont change weight it is not useful in this algo
            }
        }

        // step 3 
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(!visited[curr]) {
                dfs1(Transpose, curr, visited);
                System.out.println();
            }

        }
    }

    private static void dfs1(ArrayList<Edge> graph [] , int curr  , boolean visited [] ){
        visited[curr] =true ;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.des]){
                dfs1(graph, e.des, visited);
            } 
        }
    }

    private static void topSort (ArrayList<Edge> graph [] , int curr  , boolean visited [] , Stack <Integer> stack){
        visited [curr] =true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.des]){
                topSort(graph, e.des, visited, stack);
            }
        }
        stack.push(curr);
    }


    public static void getBridge (ArrayList<Edge> graph [] , int V){
        int dt [] = new int[V] ;
        int low []= new int[V] ;
        boolean visited[]= new boolean [V] ;
        int time  = 0 ;
        for (int i = 0; i < V; i++) {
            dfs2 (graph, i , visited, dt ,low , time , -1);
            
        }
        }

    private static void dfs2  (ArrayList<Edge > graph [] , int curr ,
     boolean visited[] ,int dt [] , int low [] , int time , int parent){

        visited[curr] =true ;
        dt[curr]= low[curr]= ++ time ;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get (i);
            if (e.des == parent) {
                continue ;
            }
            else if (!visited[e.des]){
                dfs2(graph, e.des, visited, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.des]);
                if (dt[curr] < low[e.des]){
                    System.out.println("bridge is ::-" + curr +"----" + e.des);
                }
            }
            else{
                  low[curr] = Math.min(low[curr], dt[e.des]);
            }
            
        }
    }

    public static void grtAP (ArrayList<Edge> graph [] , int V){
        boolean visited [] = new boolean[V] ;
        boolean Ap [] = new boolean[V] ;
        int time = 0 ;
        int dt [] = new int[V] ;
        int low [] = new int[V];

        for (int index = 0; index < V; index++) {
            if(!visited[index]){
                dfs3 (graph , index , -1 , visited , dt , low , time , Ap) ;
            }           
        }

        for (int i = 0; i < V; i++) {
            if (Ap[i]){
                System.out.println( "Ap :- " +i);
            }
            
        }


    }

    private static void dfs3 (ArrayList<Edge > graph [] , int curr , int parent,
     boolean visited[] ,int dt [] , int low [] , int time , boolean Ap []) {
        visited[curr] =true ;
        dt[curr] = low[curr] = ++ time ;
        int child = 0 ;

        for (int i = 0; i <graph[curr].size(); i++) {
            Edge e = graph [curr].get(i);
            int neigh = e.des ;
            if (parent == neigh){
                continue ;
            }
            else if (visited[neigh]){
                low[curr] = Math.min(low[curr], dt[neigh]);              
            }
            else {
               dfs3(graph, neigh, curr, visited, dt, low, time, Ap);
                low[curr] = Math.min(low[curr], low[neigh]); 
                if (dt[curr] <= low[neigh] && parent != -1){
                  Ap[curr] = true ; 
                }  
                child ++ ;
            }
            
        }

        if (parent == -1 && child >1){
            Ap[curr]= true ;
        }
    }
    public static void main(String[] args) {
         //int V = 4 ;
              int V = 5;
         ArrayList <Edge> graph[] = new ArrayList [V];
         createGraph(graph);
        //dijkstra(graph, 0, V);
        //bellmanFord(graph, 0, V);
        //primsAlgo(graph, V); 

       // kajurajasAlgo(graph, V);
        //getBridge(graph, V);
        grtAP(graph, V);

        
    }
}
