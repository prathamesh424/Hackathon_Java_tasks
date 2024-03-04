public class Queue {

   private int [] data ;
   private static final int DIFAULT_SIZE=10;

   int end = -1 ;

   public Queue (){
    this(DIFAULT_SIZE);
   }

   public Queue (int size ){
        this .data = new int[size];
   }

   public boolean isEmpty (){
        return end == 0 ;

   }

   public boolean isFull (){
    return end == data.length;
   }
    
   public boolean Insert (int item){
    if (isFull()){
        return false ;
    }

    data[end++] = item;
    return true ;
   }

   public int  remove () throws Exception{
    if (isEmpty()){
        throw new Exception("This is empty Queue");
    }

    int removed = data[0];

    for (int i = 1; i < end ; i++) {
        data[i-1] = data[i];
        
    }
    end--;
    return removed;
   }

   public int  front () throws Exception{
    if (isEmpty()){
        throw new Exception("This is empty Queue");
    }

    return data[0];
}

    public void Display (){
        for (int i = 0; i < end ; i++) {
             System.out.print(data[i] + " ");
        }
        System.out.println( );
    }



}


