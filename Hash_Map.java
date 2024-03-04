import java.util.*;


public class Hash_Map {
static class HashMap<K,V>{
        private class Node {
            K key ;
            V value ;

        public Node (K key , V value ){
            this.key = key ;
            this.value= value;
        }
    }
        private int n ;
        private int N ;
        private LinkedList <Node> bucket[];

    public HashMap(){
        this.N = 4 ;
        this.bucket = new LinkedList [4];
        for (int i=0 ; i <4 ;i++){
            this.bucket[i] = new LinkedList<>();
        }
    }

            // put fuction 
    public void put (K key , V value ){
        int bn = hashFunction (key) ;
        int nn = SearchInLL (key , bn);
        if (nn == -1){
            bucket[bn].add (new Node (key, value));
            n++ ;
        }

        else {
            Node Data = bucket[bn].get(nn);
            Data.value = value ;
        }

        double lambda = (double) n/N ;
        if (lambda > 2.0){
            reHash();
        }
        
    }
    private int hashFunction (K key){
        int bn = key.hashCode() ;
        return Math.abs(bn) % N ;
    }
    private int SearchInLL (K key , int bn){
        LinkedList <Node> l = bucket[bn];

        for (int i = 0 ; i < l.size() ; i++){
            if (l.get(i).key == key){
                return i ;
            }  }

        return -1 ;
    }
    private void reHash(){
        LinkedList <Node> oldBucket [] = bucket ;
        bucket = new LinkedList[N*2] ;

        for (int i= 0 ; i <bucket.length ; i++ ){
            bucket[i]= new LinkedList<>();
        }

        for (int i = 0 ; i < oldBucket.length ; i++){
            LinkedList <Node> l = oldBucket[i];
                for (int j = 0 ; j < l.size() ; j++){
                    Node node = l.get(j);
                    put(node.key, node.value);
                }
        }
    }




    // 2 
    public boolean containsKey (K key){
        int bn = hashFunction (key) ;
        int nn = SearchInLL (key , bn);
        if  ( nn != -1) {
            Node Data = bucket[bn].get(nn);
           return true ;
        }
        return false;
    }

    //3
    public V remove (K key){
         int bn = hashFunction (key) ;
        int nn = SearchInLL (key , bn);
        if  ( nn != -1) {
            Node Data = bucket[bn].remove(nn);
            n--;
           return Data.value ;
        }
        return null;
    }
//4
    public V get(K key){
        int bn = hashFunction (key) ;
        int nn = SearchInLL (key , bn);
        if  ( nn != -1) {
            Node Data = bucket[bn].get(nn);
           return Data.value ;
        }
        return null;
    }
//5
    public ArrayList<K> keySet(){
        ArrayList < K> keys = new ArrayList<>();

        for (int i =0 ; i<bucket.length ;i++){
            LinkedList< Node> l = bucket[i];
            for (int j =0 ; j <l.size() ; j++){
                Node node = l.get(i);
                keys.add(node.key);
            }
        }
        return keys ;
    }
//5
    public boolean isEmpty(){
        return n == 0 ;
    }
 
}

public static void main(String[] args) {
    HashMap <String , Integer> map = new HashMap<>();
}
}
