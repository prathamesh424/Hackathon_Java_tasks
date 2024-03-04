public class stack {

    // making custom stack in java  
    public int [] data ;  // data should private but to use the Dynamic Stack we make it public 
    private static final int DIFAULT_SIZE = 10 ;
    
    int ptr   = -1 ;

    public stack (){
        this(DIFAULT_SIZE);
    }

    public stack (int size ){
        this.data = new int[size];
    }

    public boolean push ( int item){
        if (isFull()){
            System.out.println("Stack is full ");
            return false ;

        }
        ptr++;
        data[ptr]= item;
        return true ;
    }

    public boolean isFull(){
        return ptr == data.length -1 ;
    }

    public boolean isEmpty (){
        return ptr == -1 ;
    }

    public int pop () throws Exception  {
        if (isEmpty()){
            throw new Exception ("cannot pop from an emoty stack !!");
        }
        int removed = data[ptr];
        ptr -- ;
        return removed ;
}

    public int peek () throws Exception{
        if (isEmpty()){
            throw new Exception (" cannot from an empty stack");
        
        }
        return data[ptr];
    }
}