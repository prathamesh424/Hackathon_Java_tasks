public class circularQueue {
protected int [] data ;
private static final int DIFAULT_SIZE=10;

   protected int end = 0 ;
    protected int frout = 0 ;
    private int size = 0 ;


   public circularQueue (){
    this(DIFAULT_SIZE);
   }

   public circularQueue (int size ){
        this .data = new int[size];
   }

   public boolean isEmpty (){
        return size == 0 ;

   }

   public boolean isFull (){
    return size == data.length;
   }
    
   public boolean Insert (int item){
        if (isFull()){
            return false;

        }

        data[end++] = item;
        end = end % data.length;
        size++;
        return true ;
   }

   public int remove () throws Exception{
    if (isEmpty()){
        throw new Exception("This is empty Queue");
    }

    int removed = data[frout];
    frout = frout % data.length ;
    size--;
    return removed;
   }
    
   public int  front () throws Exception{
    if (isEmpty()){
        throw new Exception("This is empty Queue");
    }

    return data[frout];
}

    public void Display (){
        if (isEmpty()){
            System.out.println("is empty ");
            return ;

        }
        int i = frout;
        do {
            System.out.print(data[i] + " -> ");
            i++;
            i %= data.length;
        } while (i != end);
        System.out.println("End ");


    }


    public class DynamicQueue extends circularQueue{
        @Override
        public boolean Insert (int item){
            if (isFull()){
                int[] temp = new int [data.length * 2];
                
                for (int i = 0; i < temp.length; i++) {
                    temp [i]= data[(frout+1) * data.length];  
                }
                frout = 0 ;
                end = data.length;
                data = temp ;
              
            }
            return super.Insert(item);
        }
    
}


}



