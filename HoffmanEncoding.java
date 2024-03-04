import java.util.*;


public class HoffmanEncoding {
    HashMap<Character ,String > encoder ;
    HashMap<String ,Character > decoder ;

    private class  Node implements Comparable<Node> {
        Character data ;
        int cost ;
        Node left  ;
        Node right ;
        
        Node (Character data , int cost ){
            this.data = data ;
            this.cost = cost ;
            left = null ;
            right = null ;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost ;
        }
    }


    public HoffmanEncoding (String s)  throws Exception{
        HashMap <Character ,Integer > freqTable = new HashMap<>() ;
        for (int i =0 ;i < s.length() ; i++){
            char c = s.charAt(i);
            if (freqTable.containsKey(c)){
                int val = freqTable.get(c) + 1 ;
                freqTable.put(c, val) ;
            }
            else {
                freqTable.put(c, 1) ;
            }
        }

        Heap <Node> heap = new Heap<>() ;
        Set<Map.Entry<Character, Integer > > entrySet = freqTable.entrySet();

        for (Map.Entry<Character ,Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue()) ;
            heap.insert(node);
        }

        while (heap.size() != 1){
            Node first = heap.remove() ;
            Node second = heap.remove() ;

            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first ;
            newNode.right = second ;  
            heap.insert(newNode); 
        }


        Node head = heap.remove() ;

        this.encoder = new HashMap<>() ;
        this.decoder = new HashMap<>() ;

        initEncoderDecoder("", head);
    }


    private void initEncoderDecoder (String s , Node node){
        if (node == null) return  ;

        if (node.left == null && node.right == null) {
            this.encoder.put(node.data, s );
            this.decoder.put(s, node.data) ;
        }

        initEncoderDecoder( s + "0", node.left);
        initEncoderDecoder(s+"1", node.right);
    }

    public String encode (String sourse){
        String ans = "" ;
        for (int i = 0; i < sourse.length(); i++) {
            ans = ans + encoder.get(sourse.charAt(i));
        }
        return ans ;
    }

    public String decode (String code){
        String ans = "" ;
        String key = "" ;
        for (int i = 0; i < code.length(); i++) {
            key = key + code.charAt(i) ;
            if (decoder.containsKey(key)){
                ans = ans + decoder.get(key);
                key = "";
            }
        }
        return ans ;
    }
}
